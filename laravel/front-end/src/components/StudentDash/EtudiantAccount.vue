<template>
    <div>
      <NavBarStd class="w-full fixed z-50 "></NavBarStd>

        <div class="grid grid-cols-12 gap-4">
          <div class="col-span-3">
            <Sidebar />
          </div>
          <div class="col-span-9 mt-24 mr-24">
    <div
      class="relative md:left-10  md:w-3/4 my-4 border px-4 shadow-xl sm:mx-4 sm:rounded-xl sm:px-4 sm:py-4 md:mx-auto"
      data-aos="fade-down"
    >
      <div class="flex flex-col border-b py-4 sm:flex-row sm:items-start">
        <div class="shrink-0 mr-auto sm:py-3">
          <p class="font-medium">Account Details</p>
          <p class="text-sm text-gray-600">Edit your account details</p>
        </div>
      </div>
      <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
        <p class="shrink-0 w-32 font-medium">Full Name</p>
        <input
          v-model="fullname"
          placeholder="Full Name"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
        <p class="shrink-1 w-32 font-medium">Niveau</p>
        <input
          v-model="niveau"
          placeholder="2eme"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
      </div>
      <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
        <p class="shrink-0 w-32 font-medium">Email</p>
        <input
          v-model="email"
          placeholder="your.email@domain.com"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
      </div>
  
      <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
        <p class="shrink-0 w-32 font-medium">Domaine</p>
        <input
          v-model="domaine"
          placeholder="Technologie Informatique"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
        <p class="shrink-1 w-32 font-medium">Specialite</p>
        <input
          v-model="specialite"
          placeholder="DSI"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
      </div>
  
      <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
        <p class="shrink-0 w-32 font-medium">Etablissement</p>
        <input
          v-model="etablissement"
          placeholder="Technologie Informatique"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
        <p class="shrink-1 w-32 font-medium">TypeStage</p>
        <input
          v-model="typeStage"
          placeholder="DSI"
          class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
        />
      </div>
      
      <div class="flex flex-col gap-4 py-4 lg:flex-row">
        <div class="shrink-0 w-32 sm:py-4">
          <p class="mb-auto font-medium">Avatar</p>
          <p class="text-sm text-gray-600">Change your avatar</p>
        </div>
        <div
          class="flex h-70 w-full flex-col items-center justify-center gap-4 rounded-xl border border-dashed border-gray-300 p-5 text-center"
        >
          <img  v-if="imageUrl!=''"
            class="h-16 w-16 rounded-full"
            :src="imageUrl"
            alt=""
          />
          <img  v-if="imageUrl==''"
            class="h-16 w-16 rounded-full"
            src="https://i.postimg.cc/mDWkzGDv/istockphoto-1200064810-170667a.jpg"
            alt=""
          />

          
          
          <p class="text-sm text-gray-600">
            Drop your desired image file here to start the upload
          </p>
          <input
            type="file"
            @change="handleImageChange"
            class="max-w-full rounded-lg px-2 font-medium text-blue-600 outline-none ring-blue-600 focus:ring-1"
          />
        </div>
      </div>
      <div
        class="flex flex-col gap-4 border-b py-4 sm:flex-row sm:justify-center"
      >
        <button
          @click="saveChanges"
          class="rounded-lg border-2 border-transparent bg-gray-950 px-4 py-2 font-medium text-white sm:inline focus:outline-none focus:ring hover:bg-gray-800"
        >
          Save Changes
        </button>
      </div>
    </div>
    </div>
    </div>
    </div>
  </template>
  <script>
  
  import "aos/dist/aos.css";
  import AOS from "aos";
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import NavBarStd from "./NavBarStd.vue";
  import axios from "axios";
  import Sidebar from "./Sidebar.vue";
  export default {
    data() {
      return {
        idEtudiant: "",
        fullname: "",
        niveau: "",
        email: "",
        domaine: "",
        specialite:"",
        typeStage:"",
        etablissement:"",
        update: false,
        storedImage: "",
        imageUrl:"",
  
      };
    },
    components:{
        NavBarStd,
        Sidebar,
    },
  
    methods: {
     
      getAccountData() {
        let storedData = localStorage.getItem("StudentAccountInfo");
        this.fullname = JSON.parse(storedData).fullname;
        this.niveau = JSON.parse(storedData).niveau;
        this.email = JSON.parse(storedData).email;
        this.domaine =JSON.parse(storedData).domaine;
        this.specialite=JSON.parse(storedData).specialite;
        this.typeStage=JSON.parse(storedData).typeStage;
        this.etablissement=JSON.parse(storedData).etablissement;
  
      },
      async handleImageChange(event) {
        const file = event.target.files[0];
        this.imageUrl = file;
      },

      async getImageUrl(){
        let storedData = localStorage.getItem("StudentAccountInfo"); 
        this.idEtudiant = JSON.parse(storedData).id;
        console.log(this.idEtudiant);
        try {
        const response = await axios.get(
          `http://localhost:8000/api/getStudentDetail/${this.idEtudiant}`);
        if (response.data.check==true) {
          console.log(response.data);
          if( response.data.student.image=='test.jpg'){
           this.imageUrl="";
           console.log(this.imageUrl);
          }
          else{
            this.imageUrl = "http://localhost:8000"+response.data.student.image;
            console.log(this.imageUrl);
          
          }
          
        } else {
          toast.error("error !", {
            autoClose: 2000, 
          });
        }
      } catch (error) {
        console.error("Error:", error);
      }
      },

    async saveChanges() {

      let formData = new FormData();
      formData.append('fullname', this.fullname);
      formData.append('niveau', this.niveau);
      formData.append('email', this.email);
      formData.append('domaine', this.domaine);
      formData.append('typeStage', this.typeStage);
      formData.append('specialite', this.specialite);
      formData.append('etablissement', this.etablissement);
      formData.append('image', this.imageUrl);
      console.log(this.imageUrl);
        try {
          const response = await axios.post(
            "http://localhost:8000/api/modifyStudent",
            formData,
            
          );
          if (response.data.update === true) {
            toast.success("Account updated succesfully !", {
              autoClose: 2000, 
            });
  
          } else {
            toast.error("Email not found !", {
              autoClose: 2000, 
            });
          }
        } catch (error) {
          console.error("Error:", error);
        }
      },
    },
    mounted() {
     this.getAccountData();
     this.getImageUrl();
    },
    created() {
      this.$nextTick(() => {
        AOS.init({
          duration: 2500,
          easing: "ease-in-out",
          once: true,
          mirror: false,
        });
      });
    },
  };
  </script>