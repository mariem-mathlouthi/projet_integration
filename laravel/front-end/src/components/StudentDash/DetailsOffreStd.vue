<template>
    <div>
      <Navbar />
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <div>
            <router-link to="/OffersListStd">
              <button type="button" class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 relative active:top-[1px]">
                Annuler
              </button>
            </router-link>
          </div>
          <div>
            <header class="text-center mb-8">
              <h1 class="text-3xl font-bold text-gray-800">Détails de l'offre</h1>
            </header>
            <div class="bg-purple-100 rounded-lg shadow-md p-6" v-if="offre">
              <h3 class="text-lg font-semibold mb-2"><span class="text-blue-800 font-bold">Titre :</span> {{ offre.titre }}</h3>
             
              <p class="text-gray-700 mb-4"><span class="text-blue-800 font-bold">Description :</span> {{ offre.description }}</p>

              <div class="flex flex-col md:flex-row items-center justify-between mb-4">
                <div class="flex items-center">
                  <p class="text-gray-700 mb-4"><span class="text-blue-800 font-bold">Entreprise :</span> {{ offre.entrepriseName }}</p>
                </div>
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
                  <button @click="telechargerCahierCharge(offre.cahierCharge)">
                  Télécharger Cahier de charge
                </button>
               
                </label>
              </div>
              <router-link :to="'/PostulerCondidature/'+ offre.id">
                <button class="ml-4 px-2 py-2 min-w-[140px] shadow-lg shadow-purple-200 rounded-full text-black text-sm tracking-wider font-medium outline-none border-2 border-purple-600 active:shadow-inner">
                  Postuler
                </button>
              </router-link>
            </div>
            <div v-else>
              <p>Chargement en cours...</p>
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Sidebar from "./Sidebar.vue";
  import Navbar from "./NavBarStd.vue";
  import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
  export default {
    
    data() {
      return {
        offre: null,
        offerId:"",
      };
    },
    created() {
  
      this.offerId = this.$route.params.id;
      this.getOfferDetail(this.offerId);
      
    },
    methods: {

      async getOfferDetail(id){

        try {
            const response = await axios.get(
              `http://localhost:8000/api/offreDetail2/${id}`
            );
            if (response.data.check === true) {
              console.log(response.data.offre);
             
             
              const response2 = await axios.get(
                `http://localhost:8000/api/getEntreprise/${response.data.offre.idEntreprise}`
                );
                console.log(response2.data.entreprise.name);
                let myObject ={
                  id:response.data.offre.id,
                  titre:response.data.offre.titre,
                  description:response.data.offre.description,
                  entrepriseName:response2.data.entreprise.name,
                  cahierCharge:response.data.offre.cahierCharge,
                  
                }
                console.log(myObject);
                this.offre=myObject;
           
              } else {
                  toast.error("Something went wrong !", {
                      autoClose: 2000,
                  });
              }
              } catch (error) {
                  console.error("Error:", error);
              }


      },

      telechargerCahierCharge(filename) {
      console.log(filename);
  // Construct the full URL of the file
  const fileURL = `http://localhost:8000${filename}`;

  // Open the file URL in a new tab to initiate the download
  window.open(fileURL, '_blank');
},


     
  
    },
    components: {
      Sidebar,
      Navbar
    }
  };
  </script>