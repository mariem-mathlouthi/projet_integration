<template>
    <div>
      <Navbar />
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <div class="bg-white rounded-lg shadow-md p-6">
            <h1 class="text-2xl font-semibold mb-4">Postuler à l'offre de stage</h1>
            <form @submit.prevent="submitApplication">
              <div class="mb-4">
                <label for="fullname" class="block text-sm font-medium text-gray-700">Nom complet</label>
                <input type="text" id="fullname" v-model="fullname" placeholder="Entrez votre nom complet"
                  class="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500">
              </div>
              <div class="mb-4">
                <label for="email" class="block text-sm font-medium text-gray-700">Adresse e-mail</label>
                <input type="email" id="email" v-model="email" placeholder="Entrez votre adresse e-mail"
                  class="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500">
              </div>
              <label for="fullname" class="block text-sm font-medium text-gray-700">Importer votre CV</label>
              <div class="mb-4">
                <label for="uploadFile1"
                class="bg-white text-center rounded w-full sm:w-[360px] min-h-[160px] py-4 px-4 flex flex-col items-center justify-center cursor-pointer border-2 border-gray-300 mx-auto font-[sans-serif] m-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="w-8 mb-6 fill-gray-400" viewBox="0 0 24 24">
                  <path
                    d="M22 13a1 1 0 0 0-1 1v4.213A2.79 2.79 0 0 1 18.213 21H5.787A2.79 2.79 0 0 1 3 18.213V14a1 1 0 0 0-2 0v4.213A4.792 4.792 0 0 0 5.787 23h12.426A4.792 4.792 0 0 0 23 18.213V14a1 1 0 0 0-1-1Z"
                    data-original="#000000" />
                  <path
                    d="M6.707 8.707 11 4.414V17a1 1 0 0 0 2 0V4.414l4.293 4.293a1 1 0 0 0 1.414-1.414l-6-6a1 1 0 0 0-1.414 0l-6 6a1 1 0 0 0 1.414 1.414Z"
                    data-original="#000000" />
                </svg>
                <p class="text-gray-400 font-semibold text-sm">Drag & Drop or <span class="text-[#007bff]">Choose file</span> to
                  upload</p>
                <input type="file" id='uploadFile1' name="cv" class="hidden" @change="handleFileUpload"   />
                <p class="text-xs text-gray-400 mt-2">PNG, JPG SVG, WEBP, and GIF are Allowed.</p>
              </label>
              </div>
              
              <div class="flex px-4 py-4 sm:px-6">
  
                    <button type="submit"
                        class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
                        Save
                    </button>
                    <router-link to="/OffersListStd"> <button type="button"
                        class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">     
                Cancel
                    </button></router-link>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from './NavBarStd.vue';
  import Sidebar from './Sidebar.vue';
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import axios from "axios";
  export default {
    data() {
      return {
        idEtudiant: "",
        idOffreDeStage:"",
        statut: "en attente",
        DateSoumission:"23-04-2024",
        cv: "",
        fullname: "",
        email: "",
        idEntreprise:"",
        entrepriseName:"",
      };
    },
    components: {
      Navbar,
      Sidebar
    },

    created() {
   this.idOffreDeStage=this.$route.params.id;
   this.getAccountData();
   
  },
    methods: {
      handleFileUpload(event) {
        this.cv = event.target.files[0];
      },

      getAccountData(){
        let storedData = localStorage.getItem("StudentAccountInfo"); 
          this.idEtudiant = JSON.parse(storedData).id;
          this.fullname= JSON.parse(storedData).fullname;
          this.email= JSON.parse(storedData).email;
      },

      async submitApplication() {
        console.log("hello!");
        console.log(this.cv);
        
        try {
        const response= await axios.get(`http://localhost:8000/api/offreDetail2/${this.idOffreDeStage}`);
        console.log(response.data.offre)
        this.idEntreprise=response.data.offre.idEntreprise;
        const response2= await axios.get(`http://localhost:8000/api/getEntreprise/${this.idEntreprise}`);
        this.entrepriseName=response2.data.entreprise.name;
        console.log(this.entrepriseName);

        const currentDate = new Date();
        const day = String(currentDate.getDate()).padStart(2, '0');
        const month = String(currentDate.getMonth() + 1).padStart(2, '0');
        const year = currentDate.getFullYear();
        const formattedDate = `${day}-${month}-${year}`;
        console.log(formattedDate);
        let myObj={
          idEtudiant:this.idEtudiant,
          idEntreprise:this.idEntreprise,
          message:this.fullname+" a déposer une demande de stage en "+response.data.offre.titre,
          destination:"Entreprise",
          type:"demande",
          visibility:"shown",
          date:formattedDate,
        }

        console.log(myObj);
        
       //const response3= await axios.post("http://localhost:8000/api/notification",myObj);
       //console.log(response3.data);
        let formData = new FormData();
        formData.append('idEtudiant', this.idEtudiant);
        formData.append('idOffreDeStage', this.idOffreDeStage);
        formData.append('statut', this.statut);
        formData.append('DateSoumission', this.DateSoumission);
        formData.append('cv', this.cv);
        console.log(formData);

          

          
            const response4 = await axios.post(
                "http://localhost:8000/api/addDemande",formData
            );

            if (response4.data.check === true) {
              toast.success("demande posted successfully !", {
                      autoClose: 2000,
                  });
              } else {
                  toast.error("Something went wrong !", {
                      autoClose: 2000,
                  });
              }
              } catch (error) {
                  console.error("Error:", error);
              }

      }
    }
  };
  </script>