<template>
  <div>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <header class="text-center mb-8">
          <!-- Filter buttons -->
          <div class="flex justify-end mb-4 font-sans text-center">
            <button @click.prevent="filterByStatut('accepté')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-300 hover:text-white transition-all duration-300 flex items-center mr-4">
              Approvées
            </button>
            <button @click.prevent="filterByStatut('en execution')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-400 hover:bg-orange-300 hover:text-white transition-all duration-300 flex items-center mr-4">
              En execution
            </button>
            
            <button @click.prevent="filterByStatut('en attente')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-blue-600 hover:bg-blue-300 hover:text-white transition-all duration-300 flex items-center mr-4">
              En attente
            </button>
            <button @click.prevent="filterByStatut('rejeté')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-red-600 hover:bg-red-300 hover:text-white transition-all duration-300 flex items-center">
              Rejetées
            </button>
          </div>
          <h1 class="text-3xl font-bold text-gray-800">Liste des Stages</h1>
        </header>
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <!-- Display each stage -->
          <div v-for="(stage, index) in storedStages" :key="index" class="bg-blue-100 shadow rounded-lg p-4">
            <h3 class="text-lg font-semibold mb-2"><span class="text-blue-800 font-bold">Titre :</span> {{ stage.title }}</h3>
            <p class="text-gray-600 mb-4"><span class="text-blue-800 font-bold">Description :</span>{{ stage.description }}</p>
            <div class="flex items-center justify-between">
              <span class="text-gray-500"><span class="text-blue-800 font-bold">Company :</span>{{ stage.company }}</span>
              <div>
              <button v-if="stage.statut=='accepté'" @click.prevent="affecter(stage.DemandeId)" class="px-4 py-2 bg-green-400 text-white rounded hover:bg-green-500">Affecter</button>
              <div v-if="stage.statut=='en attente'" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">en attente</div>
              <div v-if="stage.statut=='rejeté'"  class="px-4 py-2 bg-red-600 text-white rounded hover:bg-red-500">rejeté</div>
              <div v-if="stage.statut=='en execution'" class="px-4 py-2 bg-orange-400 text-white rounded hover:bg-orange-400">en execution</div>
            </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from './NavBarStd.vue'
import Sidebar from './Sidebar.vue'
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";

export default {
  components: {
    Navbar,
    Sidebar
  },
  data() {
    return {
      stagesList: [],
      storedStages: [],
      filteredStages: [],
      demandes: [],
      idEtudiant: "",
    }
  },
  methods: {
    

    async affecter(id){
      let myObject ={
            statut:"en execution",
        }
      console.log(myObject);
      const response = await axios.post(`http://localhost:8000/api/updateSatutDemande/${id}`,myObject);
      if (response.data.update === true) {
            toast.success("Statut updated succesfully !", {
            autoClose: 2000, 
            });
          } else {
            toast.error("Something went wrong !", {
            autoClose: 2000, 
            });
          }
    },


    async filterByStatut(statut) {
      try {
        const filteredStages = this.stagesList.filter(stage => {
          return stage.statut === statut;
        });
        this.storedStages = filteredStages;
      } catch (error) {
        console.error("Error:", error);
        toast.error("Something went wrong !", { autoClose: 2000 });
      }
    },

    async getAllStages() {
      try {
        let storedData = localStorage.getItem("StudentAccountInfo"); 
        this.idEtudiant = JSON.parse(storedData).id;
        console.log(this.idEtudiant);
        const response = await axios.get(`http://localhost:8000/api/getDemandes/${this.idEtudiant}`);
        if (response.data.check === true) {
          this.demandes = response.data.demandes;
          for (const demande of this.demandes) {
            const response2 = await axios.get(`http://localhost:8000/api/offreDetail2/${demande.idOffreDeStage}`);
            const response3 = await axios.get(`http://localhost:8000/api/getEntreprise/${response2.data.offre.idEntreprise}`);
            let myobject = {
              title: response2.data.offre.titre,
              description: response2.data.offre.description,
              DemandeId:demande.id,
              company: response3.data.entreprise.name,
              statut: demande.statut
            }
            console.log(demande);
            this.stagesList.push(myobject);
          }
          console.table(this.stagesList);
          console.log(this.stagesList);
          this.storedStages = this.stagesList;
        } else {
          toast.error("Something went wrong !", { autoClose: 2000 });
        }
      } catch (error) {
        console.error("Error:", error);
        toast.error("Something went wrong !", { autoClose: 2000 });
      }
    }
  },
  mounted() {
    this.getAllStages();
  }
}
</script>

<style>
/* Styles CSS personnalisés peuvent être ajoutés ici */
</style>
