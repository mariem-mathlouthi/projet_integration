<template>
    <div>
      <Navbar/>
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <form class="font-sans text-[#333] max-w-4xl mx-auto px-6 my-6" @submit.prevent="handleSubmit">
            <div class="grid sm:grid-cols-2 gap-10">
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-25px] left-0 font-semibold">Numero SIRET</label>
                <input type="text" placeholder="SIRET number"
                  v-model="numeroSIRET"
                  class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-25px] left-0 font-semibold">Name</label>
                <input type="text" placeholder="company name"
                  v-model="name"
                  class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-25px] left-0 font-semibold">Email</label>
                <input type="email" placeholder="email"
                  v-model="email"
                  class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-25px] left-0 font-semibold">Secteur</label>
                <input type="text" placeholder="company sector"
                   v-model="secteur"
                  class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none" />
              </div>
              
              <div class="relative flex items-center sm:col-span-2">
                <label class="text-[13px] absolute top-[-25px] left-0 font-semibold">Description</label>
                <input type="text" placeholder="description"
                  v-model="description"
                  class="px-2 pt-3 pb-20 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none" />
              </div>
              <div class="relative flex items-center sm:col-span-2">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Logo</label>
          
                <input type="file"  accept="image/*"
                @change="handleLogoChange"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333]  outline-none" />
              </div>
            </div>
            <button type="submit" class="mt-10 px-2 py-2.5 w-full rounded text-sm font-semibold bg-[#333] text-white hover:bg-[#222]">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </template>

<script>
import Navbar from './Navbar.vue';
import Sidebar from './SideBar.vue';
import "aos/dist/aos.css";
import AOS from "aos";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";

export default {
  name: 'EntrepriseDashboard',
  data() {
    return {
      numeroSIRET: "",
      name: "",
      email: "",
      secteur:"",
      description:"",
      logo:"", // Change this to null
    };
  },
  components:{
    Navbar,
    Sidebar,
  },

  methods: {
    getAccountData() {
      let storedData = localStorage.getItem("EntrepriseAccountInfo");
      this.numeroSIRET = JSON.parse(storedData).numeroSIRET;
      this.email = JSON.parse(storedData).email;
      this.name = JSON.parse(storedData).name;
      this.secteur = JSON.parse(storedData).secteur;
      this.description = JSON.parse(storedData).description;
    },
    handleLogoChange(event) {
      // Read the file content and assign it to logo
      this.logo = event.target.files[0];
    },
    async handleSubmit() {
     
  let formData = new FormData();
  formData.append('numeroSIRET', this.numeroSIRET);
  formData.append('email', this.email);
  formData.append('name', this.name);
  formData.append('secteur', this.secteur);
  formData.append('description', this.description);
  formData.append('logo', this.logo);

      
      try {
        const response = await axios.post(
          "http://localhost:8000/api/modifyEntreprise",
          formData,
        );
        if (response.data.update === true) {
          toast.success("Account updated successfully !", {
            autoClose: 2000, 
          });
          let existingData = localStorage.getItem('EntrepriseAccountInfo');
          existingData = JSON.parse(existingData);
          existingData.numeroSIRET = this.numeroSIRET;
          existingData.name = this.name;
          existingData.secteur = this.secteur;
          existingData.description = this.description;
          const updatedData = JSON.stringify(existingData);
          localStorage.setItem('EntrepriseAccountInfo', updatedData);
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