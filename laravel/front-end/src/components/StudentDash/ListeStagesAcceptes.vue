<template>
    <div>
      <Navbar/>
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
            <div>
          
            </div>
            <header class="text-center mb-8">
                <h1 class="text-3xl font-bold text-gray-800">Liste des Stages Acceptés</h1>
            </header>
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                <!-- Boucle sur la liste des stages acceptés -->
                <div v-for="(stage, index) in AcceptedStages" :key="index" class="bg-white shadow rounded-lg p-4">
                <h3 class="text-lg font-semibold mb-2">{{ stage.title }}</h3>
                <p class="text-gray-600 mb-4">{{ stage.description }}</p>
                <div class="flex items-center justify-between">
                    <span class="text-gray-500">{{ stage.company }}</span>
                    <button @click="selectStage(stage)" class="px-4 py-2 bg-orange-500 text-white rounded hover:bg-orange-600">Affecter</button>
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
        // Exemple de liste de stages acceptés
        AcceptedStages:[],
        demandes:[],
        idEtudiant:"",
        acceptedStages: [
          {
            title: "Stage en Développement Web",
            description: "Stage de développement web pour un site e-commerce.",
            company: "AwesomeTech Inc."
          },
          {
            title: "Stage en Data Science",
            description: "Stage de data science pour analyser des données financières.",
            company: "DataAnalytics Corp."
          },
          {
            title: "Stage en Marketing Digital",
            description: "Stage de marketing digital pour promouvoir une nouvelle application.",
            company: "MarketingPros Ltd."
          }
          // Ajoutez d'autres stages acceptés au besoin
        ]
      }
    },
    methods: {
      selectStage(stage) {
        // Logique pour affecter le stage sélectionné
        console.log("Stage sélectionné :", stage)
        // Rediriger ou afficher un message selon les besoins
      },
      

      async getAllAcceptedStages(){
        let storedData = localStorage.getItem("StudentAccountInfo"); 
        this.idEtudiant = JSON.parse(storedData).id;
        console.log(this.idEtudiant);
        try {
            const response = await axios.get(
                `http://localhost:8000/api/getDemandes/${this.idEtudiant}`
            );
            if (response.data.check === true) {
                this.demandes = response.data.demandes;
                for(let i=0;i<this.demandes.length;i++){
                  if(this.demandes[i].statut=="accepté"){
                    console.log(this.demandes[i]);
                    const response2 = await axios.get(
                `http://localhost:8000/api/offreDetail2/${this.demandes[i].idOffreDeStage}`
              );
                    console.log(response2.data);
                    const response3 = await axios.get(
                `http://localhost:8000/api/getEntreprise/${response2.data.offre.idEntreprise}`
                );
                console.log(response3);
                      let myobject = {
                        title:response2.data.offre.titre,
                        description:response2.data.offre.description,
                        company:response3.data.entreprise.name,
                      }

                      this.AcceptedStages.push(myobject);
                    }
                  }
                  console.table(this.AcceptedStages);
              } else {
                  toast.error("Something went wrong !", {
                      autoClose: 2000,
                  });
              }
              } catch (error) {
                  console.error("Error:", error);
              }

      }



    },
    mounted(){
      this.getAllAcceptedStages();
    }
  }
  </script>
  
  <style>
  /* Styles CSS personnalisés peuvent être ajoutés ici */
  </style>
  