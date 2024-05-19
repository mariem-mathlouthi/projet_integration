<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div class="grid sm:grid-cols-2 gap-10">
          <div class="relative flex items-center">
            <label class="text-[13px] absolute top-[-25px] left-0 font-semibold"
              >Numero SIRET</label
            >
            <input
              type="text"
              placeholder="SIRET number"
              v-model="numeroSIRET"
              class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none"
            />
          </div>
          <div class="relative flex items-center">
            <label class="text-[13px] absolute top-[-25px] left-0 font-semibold"
              >Name</label
            >
            <input
              type="text"
              placeholder="company name"
              v-model="name"
              class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none"
            />
          </div>
          <div class="relative flex items-center">
            <label class="text-[13px] absolute top-[-25px] left-0 font-semibold"
              >Email</label
            >
            <input
              type="email"
              placeholder="email"
              v-model="email"
              class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none"
              disabled
            />
          </div>
          <div class="relative flex items-center">
            <label class="text-[13px] absolute top-[-25px] left-0 font-semibold"
              >Secteur</label
            >
            <input
              type="text"
              placeholder="company sector"
              v-model="secteur"
              class="px-2 pt-3 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none"
            />
          </div>

          <div class="relative flex items-center sm:col-span-2">
            <label class="text-[13px] absolute top-[-25px] left-0 font-semibold"
              >Description</label
            >
            <input
              type="text"
              placeholder="description"
              v-model="description"
              class="px-2 pt-3 pb-20 bg-white w-full text-sm border-b-2 border-gray-100 rounded outline-none"
            />
          </div>
          <div class="relative flex items-center sm:col-span-2">
            <label class="text-[13px] absolute top-[-10px] left-0 font-semibold"
              >Logo</label
            >

            <input
              type="file"
              accept=".png, .jpeg, .jpg"
              @change="handleLogoChange"
              class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none"
            />
          </div>
        </div>
        <button
          @click="handleSubmit"
          class="mt-10 px-2 py-2.5 w-full rounded text-sm font-semibold bg-[#333] text-white hover:bg-[#222]"
        >
          Submit
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "./Navbar.vue";
import Sidebar from "./SideBar.vue";
import "aos/dist/aos.css";
import AOS from "aos";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
export default {
  name: "EntrepriseDashboard",
  data() {
    return {
      id: null,
      numeroSIRET: "",
      name: "",
      email: "",
      secteur: "",
      description: "",
      logoURL: "",
      update: false,
      file: null,
    };
  },
  components: {
    Navbar,
    Sidebar,
  },

  methods: {
    async getAccountData() {
      let storedData = localStorage.getItem("EntrepriseAccountInfo");
      this.id = JSON.parse(storedData).id;
      this.email = JSON.parse(storedData).email;
      // get etudiant data using id
      let entrepriseData = await axios
        .get("http://localhost:8087/api/entreprise/" + this.id)
        .then((response) => {
          return response.data;
        })
        .catch((error) => {
          toast.error("Error fetching data! Please try to reLogin", {
            autoClose: 3000,
          });
        });
      this.numeroSIRET = entrepriseData.numeroSIRET;
      this.name = entrepriseData.name;
      this.secteur = entrepriseData.secteur;
      this.description = entrepriseData.description;
      this.logo = entrepriseData.logo;
    },

    handleLogoChange(event) {
      this.file = event.target.files[0];
      this.update = true;
      console.log(this.file);
    },

    // Function to submit the form
    async handleSubmit() {
      if (this.update) {
        var Avatar = new FormData();
        Avatar.append("file", this.file);
        axios
          .post("http://localhost:8087/file/upload", Avatar, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
          .then(function (response) {
            toast.success("avatar uploaded succesfully !", {
              autoClose: 2000,
            });
          })
          .catch(function (error) {
            toast.error("Something went wrong !", {
              autoClose: 2000,
            });
          });
      }

      let myjson = {
        numeroSIRET: this.numeroSIRET,
        name: this.name,
        secteur: this.secteur,
        description: this.description,
        logo: this.logo,
        id: this.id,
      };
      if (this.update) {
        myjson.logo = this.file.name;
      }

      console.log(myjson);
      const response = await axios
        .post("http://localhost:8087/api/entreprise/modify", myjson)
        .then(function (response) {
          toast.success("Account updated succesfully !", {
            autoClose: 2000,
          });
          console.log(response);
        })
        .catch(function (error) {
          toast.error("something went wrong !", {
            autoClose: 2000,
          });
          console.error("Error:", error);
        });
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
