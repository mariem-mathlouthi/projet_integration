
<template>


    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
        <router-link to="/TreatedRequest" class="px-6 py-2 rounded bg-purple-400 hover:bg-purple-400 text-white ml-4 mt-4 no-underline">Back</router-link>
        <div class="container mx-auto px-4 py-8">
    <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6 flex justify-between items-center">

    <div>
        <h3 class="text-lg font-medium leading-6 text-gray-900">Edit Demande</h3>
        
    </div>
    
</div>

      <div class="border-t border-gray-200">
        <dl>
          
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Status</dt>
        
            <select class="mt-1 sm:col-span-2" v-model="statut" @change="selectedOption">
                <option type="text"  class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" disabled>please select one</option>
                <option type="text"  class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">en attente</option>
                <option type="text"  class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">accepté</option>
                <option type="text"  class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">rejeté</option>
            </select>
          </div>
          
          <div class="flex justify-end px-4 py-4 sm:px-6">
      <form @submit.prevent="updateDemandeStatut">
    <button type="submit" class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
      Save
    </button>
  </form>
    <router-link to="/TreatedRequest">
    <button type="button"
        class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">     
Cancel
    </button>
  </router-link>
</div>
          <!-- Ajoutez plus de paires de termes et de définitions pour afficher d'autres détails de l'offre -->
        </dl>
      </div>
    </div>
  </div>

</div>






  </div>
  </template>
  
  <script>
  
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import axios from "axios";
  import Navbar from './Navbar.vue';
  import Sidebar from './SideBar.vue';
  export default {
    data() {
        return {
            demandeId:"",
            statut: "en attente",
            idEntreprise:"",
          
        };
    },
    components: {
      Navbar,
      Sidebar
    },
    created() {      
        this.demandeId=this.$route.params.id;
        this.getAccountData();
        
       
    },
    methods: {
    selectedOption() {
      console.log(this.statut);
    },

    getAccountData() {
            let storedData = localStorage.getItem("EntrepriseAccountInfo");
            this.entrepriseName=JSON.parse(storedData).name;
            this.idEntreprise=JSON.parse(storedData).id;
            },
        async updateDemandeStatut() {
          let myObject ={
            statut:this.statut
        }
        console.log(myObject);
          try {
          const response = await axios.post(`http://localhost:8000/api/updateSatutDemande/${this.demandeId}`,myObject);
          const response2 = await axios.get(`http://localhost:8000/api/getDemandeById/${this.demandeId}`);
          const response3 = await axios.get(`http://localhost:8000/api/getStudentDetail/${response2.data.demande[0].idEtudiant}`);
          const response4 = await axios.get(`http://localhost:8000/api/offreDetail2/${response2.data.demande[0].idOffreDeStage}`);
          console.log(response3.data);
          console.log(response4.data);
        
          const currentDate = new Date();
          const day = String(currentDate.getDate()).padStart(2, '0');
          const month = String(currentDate.getMonth() + 1).padStart(2, '0');
          const year = currentDate.getFullYear();
          const formattedDate = `${day}-${month}-${year}`;
          

       

          if (response.data.update === true) {
            toast.success("Status updated succesfully !", {
            autoClose: 2000, 
            });
            if(this.statut=="accepté"){
              let myObj={
              idEtudiant:response3.data.student.id,
              idEntreprise:this.idEntreprise,
              message:this.entrepriseName+" a accepté votre demande de stage en "+response4.data.offre.titre,
              destination:"Etudiant",
              type:"demande",
              visibility:"shown",
              date:formattedDate,
            }
            console.log(myObj);
            const response5= await axios.post("http://localhost:8000/api/notification",myObj);
            console.log(response5.data);

            }
            else if(this.statut=="rejeté"){
              let myObj={
              idEtudiant:response3.data.student.id,
              idEntreprise:this.idEntreprise,
              message:this.entrepriseName+" a rejeté votre demande de stage en "+response4.data.offre.titre,
              destination:"Etudiant",
              type:"demande",
              visibility:"shown",
              date:formattedDate,
            }
            console.log(myObj);
            const response5= await axios.post("http://localhost:8000/api/notification",myObj);
            console.log(response5.data);
            }
            else if(this.statut=="en execution"){
              let myObj={
              idEtudiant:response3.data.student.id,
              idEntreprise:this.idEntreprise,
              message:this.entrepriseName+" votre demande de stage en "+response4.data.offre.titre+" en execution",
              destination:"Etudiant",
              type:"demande",
              visibility:"shown",
              date:formattedDate,
            }
            console.log(myObj);
            const response5= await axios.post("http://localhost:8000/api/notification",myObj);
            console.log(response5.data);
            }

              
          } else {
            toast.error("Something went wrong !", {
            autoClose: 2000, 
            });
            
          }
      } catch (error) {
          console.error("Error while updating demande status:", error);
      }
          
        },

    
    }

}
  </script>
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


