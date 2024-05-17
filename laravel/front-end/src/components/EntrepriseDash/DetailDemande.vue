
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
        <h3 class="text-lg font-medium leading-6 text-gray-900">Détails de Demande</h3>
        <p class="mt-1 max-w-2xl text-sm text-gray-500">Informations sur les demandes</p>
    </div>
    <div class="flex space-x-4">


        <router-link :to="'/EditDemande/'+demandeId">
            <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-300  hover:text-white transition-all duration-300">Edit</button>
        </router-link>
        <form @submit.prevent="deleteDemande">
          <button type="submit"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-300 hover:text-white transition-all duration-300">Delete</button>
        </form>
        
    </div>
</div>

      <div class="border-t border-gray-200">
        <dl>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Satut</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ statut }}</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Full name</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ fullname }}</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">email</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ email }}</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">offre de Stage</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offreDeStage }}</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <!-- Bouton pour importer le CV -->
            <label for="uploadFile1" class="mt-4 md:mt-0 bg-gray-800 hover:bg-gray-700 text-white text-sm px-4 py-2.5 outline-none rounded w-max cursor-pointer block font-[sans-serif]">
                  <svg xmlns="http://www.w3.org/2000/svg" class="w-5 mr-2 fill-white inline" viewBox="0 0 32 32">
                    <path
                      d="M23.75 11.044a7.99 7.99 0 0 0-15.5-.009A8 8 0 0 0 9 27h3a1 1 0 0 0 0-2H9a6 6 0 0 1-.035-12 1.038 1.038 0 0 0 1.1-.854 5.991 5.991 0 0 1 11.862 0A1.08 1.08 0 0 0 23 13a6 6 0 0 1 0 12h-3a1 1 0 0 0 0 2h3a8 8 0 0 0 .75-15.956z"
                      data-original="#000000" />
                    <path
                      d="M20.293 19.707a1 1 0 0 0 1.414-1.414l-5-5a1 1 0 0 0-1.414 0l-5 5a1 1 0 0 0 1.414 1.414L15 16.414V29a1 1 0 0 0 2 0V16.414z"
                      data-original="#000000" />
                  </svg>
                  <button @click="telechargerCv(cv)">
                  Télécharger le cv 
                </button>
               
                </label>
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
           statut:"",
           cv:"",
           idEtudiant:"",
           offreDeStage:"",
           email:"",
           fullname:"",
        };
    },
    name: 'EntrepriseDashboard',
    components: {
      Navbar,
      Sidebar
    },
    
    created() {
        // Fetch offer details based on route parameter (offer ID)
        this.fetchDemandeDetails(this.$route.params.id);
    },
    methods: {
        async fetchDemandeDetails(id) {
          try {
          const response = await axios.get(`http://localhost:8000/api/getDemandeById/${id}`);
          this.demandeId=response.data.demande[0].id;
          console.log(this.demandeId);
          
          if (response.data.check === true) {
            const response2 = await axios.get(`http://localhost:8000/api/offreDetail2/${response.data.demande[0].idOffreDeStage}`);
            const response3 = await axios.get(`http://localhost:8000/api/getStudentDetail/${response.data.demande[0].idEtudiant}`);
              console.log(response.data);
              console.log(response3.data);
              this.statut=response.data.demande[0].statut;
              this.cv=response.data.demande[0].cv;
              this.offreDeStage=response2.data.offre.titre;
              this.email=response3.data.student.email;
              this.fullname=response3.data.student.fullname;
              
              

          } else {
              // Handle if check is false
              console.error("Error fetching offer details:", response.data.message);
          }
      } catch (error) {
          console.error("Error fetching offer details:", error);
      }
          
        },

      async deleteDemande(){
        try {
          const response = await axios.delete(`http://localhost:8000/api/deleteDemande/${this.demandeId}`);
          if (response.data.delete === true) {
            this.$router.push('/TreatedRequest');
          } else {
            toast.error("Something went wrong !", {
            autoClose: 2000, 
            });
          }
      } catch (error) {
          console.error("Error", error);
      }
        
      },

      telechargerCv(filename) {
      console.log(filename);
  // Construct the full URL of the file
  const fileURL = `http://localhost:8000${filename}`;

  // Open the file URL in a new tab to initiate the download
  window.open(fileURL, '_blank');
},


    }
  }
  </script>
  
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


