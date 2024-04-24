<template>
    <Sidebar></Sidebar>
    <div
      class="relative md:left-40  md:w-3/4 my-4 border px-4 shadow-xl sm:mx-4 sm:rounded-xl sm:px-4 sm:py-4 md:mx-auto"
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
          <div
            v-if="imageBase64 == null"
            class="h-16 w-16 rounded-full">
            <img
            class="h-16 w-16 rounded-ful"
            :src="imageUrl"
            alt=""
          />
        </div>
          <img
            v-if="imageBase64 != null"
            class="h-16 w-16 rounded-full"
            :src="imageBase64"
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
  </template>
  <script>
  
import "aos/dist/aos.css";
import AOS from "aos";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
import Sidebar from "./Sidebar.vue";
export default {
    data() {
      return {
        fullname: "",
        niveau: "",
        email: "",
        domaine: "",
        specialite:"",
        typeStage:"",
        etablissement:"",
        imageBase64: null,
        update: false,
        storedImage: "",
        imageUrl:"https://i.postimg.cc/mDWkzGDv/istockphoto-1200064810-170667a.jpg",

      };
    },
    components:{
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
        if (file) {
          const reader = new FileReader();
          reader.onload = () => {
            // Set the base64 URL to your data property
            this.imageBase64 = reader.result;
          };
          reader.readAsDataURL(file);
        }
      },
      async saveChanges() {
        console.log(this.imageBase64);

        let myjson = {
        fullname:this.fullname,
        niveau:this.niveau,
        email:this.email,
        domaine:this.domaine,
        typeStage:this.typeStage,
        specialite:this.specialite,
        etablissement:this.etablissement,
        image:"test.jpg",
      }
      console.log(myjson);
        try {
          const response = await axios.post(
            "http://localhost:8000/api/modifyStudent",
            myjson,
            
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
  