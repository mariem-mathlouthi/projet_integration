
<template>


    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
        <router-link to="/OffersList" class="px-6 py-2 rounded bg-purple-400 hover:bg-purple-400 text-white ml-4 mt-4 no-underline">Back</router-link>
        <div class="container mx-auto px-4 py-8">
    <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6 flex justify-between items-center">
    <div>
        <h3 class="text-lg font-medium leading-6 text-gray-900">Edit offre</h3>
        <p class="mt-1 max-w-2xl text-sm text-gray-500">Informations détaillées sur l'offre</p>
    </div>
    
</div>

      <div class="border-t border-gray-200">
        <dl>
          
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Titre</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="titre" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Description</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="description" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Domaine</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="domaine" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">dateDebut</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="dateDebut" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">dateFin</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="dateFin" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">typeOffre</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="typeOffre" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">CahierCharhe</dt>
            <dd class="mt-1 sm:col-span-2">
                <input type="text" v-model="cahierCharge" class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
            </dd>
          </div>
          <div class="flex justify-end px-4 py-4 sm:px-6">
      <form @submit.prevent="save">
    <button type="submit" class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
      Save
    </button>
  </form>
    <router-link to="/OffersList">
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
            offerDetails:"",
            idEntreprise:"",
            offerId:"",
            status: "",
            titre: "",
            description: "",
            domaine: "",
            dateDebut: "",
            dateFin: "",
            typeOffre: "",
            cahierCharge: ""
          
        };
    },
    components: {
      Navbar,
      Sidebar
    },
    created() {
        // Fetch offer details based on route parameter (offer ID)
        
        this.offerId=this.$route.params.id;
        this.idEntreprise=this.$route.params.idEntreprise;
        this.fetchOfferDetails();
    },
    methods: {
        async fetchOfferDetails() {
          console.log(this.idEntreprise);
          console.log(this.offerId);
          try {
          const response = await axios.get(`http://localhost:8000/api/offreDetail/${this.idEntreprise}/${this.offerId}`);
          
          if (response.data.check === true) {
              this.offerDetails=response.data.offre;
              console.log(this.offerDetails);
              this.status=response.data.offre.status;
              this.titre=response.data.offre.titre;
              this.description=response.data.offre.description;
              this.domaine=response.data.offre.domaine;
              this.dateDebut=response.data.offre.dateDebut;
              this.dateFin=response.data.offre.dateFin;
              this.typeOffre=response.data.offre.typeOffre;
              this.cahierCharge=response.data.offre.cahierCharge;
          } else {
              // Handle if check is false
              console.error("Error fetching offer details:", response.data.message);
          }
      } catch (error) {
          console.error("Error fetching offer details:", error);
      }
          
        },

    async save(){
      console.log("hello save");
      let myjson = {
        id: this.offerId,
        status:this.status,
        titre: this.titre,
        description: this.description,
        domaine: this.domaine,
        dateDebut:this.dateDebut,
        dateFin:this.dateFin,
        typeOffre: this.typeOffre,
        cahierCharge: this.cahierCharge
      }
      try {
      const response = await axios.post("http://localhost:8000/api/updateOffre",myjson);
      if(response.data.update==true){
        toast.success("Offre updated succesfully !", {
            autoClose: 2000, 
            });

      }
      else{
        toast.error("Something went wrong !", {
            autoClose: 2000, 
            });
      }
      
    } catch (error) {
      console.error("Error saving offer:", error);
    }
  }
    }

}
  </script>
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


