<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <header class="text-center mb-8">
          <!-- Filter buttons -->
          <div class="flex justify-end mb-4 font-sans text-center">
            <button
              @click="filterByStatut('accepté')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-300 hover:text-white transition-all duration-300 flex items-center mr-4"
            >
              Approvées
            </button>
            <button
              @click="filterByStatut('en_attente')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-blue-600 hover:bg-blue-300 hover:text-white transition-all duration-300 flex items-center mr-4"
            >
              En attente
            </button>
            <button
              @click="filterByStatut('refusé')"
              class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-red-600 hover:bg-red-300 hover:text-white transition-all duration-300 flex items-center"
            >
              Rejetées
            </button>
          </div>
          <h1 class="text-3xl font-bold text-gray-800">Liste des Stages</h1>
        </header>
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <!-- Display each stage -->
          <div
            v-for="(stage, index) in filteredStages"
            :key="index"
            class="bg-white shadow rounded-lg p-4"
          >
            <h3 class="text-lg font-semibold mb-2">
              {{ stage.offreDeStage.titre }}
            </h3>
            <p class="text-gray-600 mb-4">
              {{ stage.offreDeStage.description }}
            </p>
            <div class="flex items-center justify-between">
              <span class="text-gray-500">{{
                stage.offreDeStage.entreprise.name
              }}</span>
              <button
                @click="selectStage(stage)"
                class="px-4 py-2 bg-orange-500 text-white rounded hover:bg-orange-600"
              >
                Affecter
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "./NavBarStd.vue";
import Sidebar from "./Sidebar.vue";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";

export default {
  components: {
    Navbar,
    Sidebar,
  },
  data() {
    return {
      storedStages: [],
      filteredStages: [],
      idEtudiant: "",
    };
  },
  methods: {
    selectStage(stage) {
      // Logique pour affecter le stage sélectionné
      console.log("Stage sélectionné :", stage);
      // Rediriger ou afficher un message selon les besoins
    },

    async filterByStatut(statut) {
      try {
        this.filteredStages = [];
        this.storedStages.forEach((stage) => {
          if (stage.statut == statut) {
            this.filteredStages.push(stage);
          }
        });
        console.log(this.filteredStages);
      } catch (error) {
        console.error("Error:", error);
        toast.error("Something went wrong !", { autoClose: 2000 });
      }
    },

    async getAllStages() {
      let storedData = localStorage.getItem("StudentAccountInfo");
      this.idEtudiant = JSON.parse(storedData).id;
      const response = await axios
        .get("http://localhost:8087/api/demandes/get/" + this.idEtudiant)
        .then(function (response) {
          return response.data;
        })
        .catch(function (error) {
          console.error("Error:", error);
          toast.error("Something went wrong !", { autoClose: 2000 });
        });
      this.storedStages = response;
      this.filteredStages = response;
    },
  },
  mounted() {
    this.getAllStages();
  },
};
</script>

<style>
/* Styles CSS personnalisés peuvent être ajoutés ici */
</style>
