
<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
        <div class="font-[sans-serif] mt-12">
           
            <div class="-mt-16 mb-6 px-4">
                <div class="mx-auto max-w-6xl shadow-lg py-8 px-6 relative bg-white rounded">
                    <h2 class="text-2xl text-blue-900 font-bold">Entrer les informations de l'offre</h2>
                    <form class="mt-8 grid sm:grid-cols-2 gap-6" @submit.prevent="addOffre">
                        <div>
                            <label class="font-semibold text-sm">Titre de l'offre</label>
                            <input type='text' placeholder='enter le titre de loffre'
                               required
                                v-model="titre"
                                class="w-full rounded py-2.5 px-4 mt-2 border-2 text-sm outline-[#007bff]" />
                        </div>
                        
                        <div>
                            <label class="font-semibold text-sm">Email de l'entreprise</label>
                            <input type='email' placeholder='Email'
                                v-model="email"
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">Domaine</label>
                            <input type='text' placeholder='Domain.'
                                 required
                                 v-model="domaine"
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">site web</label>
                            <input type='text' placeholder='site web'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">DateDebut</label>
                            <input type='date' placeholder='Company'
                                v-model="dateDebut"
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">DateFin</label>
                            <input type='date' placeholder='Subject'
                                v-model="dateFin"
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">Type Offre</label>
                            <input type='text' placeholder='Subject'
                                v-model="typeOffre"
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm" >Description</label>
                            <textarea
                  v-model="description"
                  required placeholder='entrer la description de loffre ici'
                  class="w-full rounded py-2.5 px-4 mt-2 border-2 text-sm outline-[#007bff]"
                ></textarea>
                        </div>
                        
                        <div>
    <label class="font-semibold text-sm">Cahier de charge</label>
    <div class="mt-1 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md">
        <div class="space-y-1 text-center">
            <svg class="mx-auto h-12 w-12 text-gray-400" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4v4m0 0v4m0-4h4m-12 6h3l-4 4-4-4h3m1-9h6a2 2 0 012 2v14a2 2 0 01-2 2H5a2 2 0 01-2-2V6a2 2 0 012-2z" />
            </svg>
            <div class="flex text-sm text-gray-600">
                <label for="file-upload" class="relative cursor-pointer bg-white rounded-md font-medium text-[#007bff] hover:text-blue-600 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-[#007bff]">
                    <span>Télécharger fichier</span>
                    <input id="file-upload" name="file-upload"  type="file" class="sr-only" @change="handleFileUpload">
                </label>
                <p class="pl-1">glisser-déposer</p>
            </div>
            <p class="text-xs text-gray-500">PNG, JPG, GIF up to 10MB</p>
        </div>
    </div>
</div>
<br><br><br>
<div class="flex px-4 py-4 sm:px-6">
    <button type="submit"
        class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
        Save
    </button>
    <router-link to="/OffersList">
        <button type="button"
        class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">     
Cancel
    </button>
    </router-link>
    
</div>
                     

                        
                    </form>
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
        idEntreprise:"",
        status:"en attente",
        titre:"",
        description:"",
        domaine:"",
        dateDebut:"",
        dateFin:"",
        typeOffre:"",
        cahierCharge:"",
        email:"",
        entrepriseName:"",
    };
  },
    components: {
      Navbar,
      Sidebar
    },
  methods: {
     
    handleFileUpload(event) {
        this.cahierCharge = event.target.files[0];
        console.log(this.cahierCharge);
      },

    async addOffre() {
        console.log("hello");
        let storedData = localStorage.getItem("EntrepriseAccountInfo");
        this.idEntreprise = JSON.parse(storedData).id;

        let myjson = {
        idEntreprise:this.idEntreprise,
        status:this.status,
        titre:this.titre,
        description:this.description,
        domaine:this.domaine,
        dateDebut:this.dateDebut,
        dateFin:this.dateFin,
        typeOffre:this.typeOffre,
        cahierCharge:this.cahierCharge,
        }
        console.log(myjson);

        const currentDate = new Date();
        const day = String(currentDate.getDate()).padStart(2, '0');
        const month = String(currentDate.getMonth() + 1).padStart(2, '0');
        const year = currentDate.getFullYear();
        const formattedDate = `${day}-${month}-${year}`;
        let myObj={
          idEtudiant:0,
          idEntreprise:this.idEntreprise,
          message:this.entrepriseName+" a ajouté une nouvelle offre de stage en "+this.titre,
          destination:"Entreprise",
          type:"offre",
          visibility:"shown",
          date:formattedDate,
        }

        let formData = new FormData();
        formData.append('idEntreprise', this.idEntreprise);
        formData.append('status', this.status);
        formData.append('titre', this.titre);
        formData.append('description', this.description);
        formData.append('domaine', this.domaine);
        formData.append('dateDebut', this.dateDebut);
        formData.append('dateFin', this.dateFin);
        formData.append('typeOffre', this.typeOffre);
        formData.append('cahierCharge', this.cahierCharge);
        console.log(formData);

        
        try {

        const response = await axios.post(
            "http://localhost:8000/api/addOffre",
            formData,
            
        );
        const response2= await axios.post("http://localhost:8000/api/notification",myObj);
        console.log(response2.data);

        if (response.data.check === true) {
            toast.success("Offre added succesfully !", {
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
  },
        getAccountData() {
            let storedData = localStorage.getItem("EntrepriseAccountInfo");
            this.email = JSON.parse(storedData).email;
            this.entrepriseName=JSON.parse(storedData).name;
            
            },

},
    
  mounted() {
   this.getAccountData();
   
  },
  }
  </script>
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


