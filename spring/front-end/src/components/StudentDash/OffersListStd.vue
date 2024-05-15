<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>

      <div class="col-span-9 mt-24 mr-24">
        <div class="flex justify-end mb-8">
          <div class="flex items-center">
            <select
              v-model="searchCriteria"
              class="px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500"
            >
              <option value="0">Select</option>
              <option value="1">Titre</option>
              <option value="2">Description</option>
              <option value="3">Entreprise</option>
            </select>
            <input
              type="text"
              v-model="searchQuery"
              placeholder="Rechercher..."
              class="ml-4 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500"
            />
            <button
              @click="search(searchQuery, searchCriteria)"
              class="ml-4 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
            >
              Rechercher
            </button>
          </div>
        </div>

        <h2 class="text-2xl font-bold mb-8">Liste des stages disponibles</h2>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <div
            v-for="offre in offres"
            :key="offre.id"
            class="bg-white shadow rounded-lg p-4"
          >
            <h3 class="text-lg font-semibold mb-2">{{ offre.titre }}</h3>
            <p class="text-gray-600 mb-4">{{ offre.description }}</p>
            <p class="text-gray-600 mb-4">{{ offre.entreprise.name }}</p>
            <div class="flex items-center justify-between">
              <router-link :to="'/DetailsOffreStd/' + offre.id">
                <button
                  class="px-4 py-2 bg-purple-500 text-white rounded hover:bg-purple-600"
                >
                  Voir Détails
                </button>
              </router-link>
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
  created() {
    this.getAllOffre();
  },
  components: {
    Navbar,
    Sidebar,
  },
  data() {
    return {
      offres: [],
      AllOffres: [],
      searchCriteria: "0",
      searchQuery: "",
    };
  },
  methods: {
    getAllOffre() {
      try {
        axios.get("http://localhost:8087/api/offres/all").then((res) => {
          this.AllOffres = res.data;
          this.offres = res.data;
        });
      } catch (error) {
        console.error("Error:", error);
      }
    },
    search(searchQuery, searchCriteria) {
      if (searchQuery == "") {
        this.offres = this.AllOffres;
      } else {
        axios
          .get(
            "http://localhost:8087/api/offres/find/" +
              searchCriteria +
              "/" +
              searchQuery
          )
          .then((res) => {
            this.offres = res.data;
          })
          .catch(function (error) {
            toast.error("Something went wrong !", {
              autoClose: 2000,
            });
          });
      }
    },
  },
};
</script>
