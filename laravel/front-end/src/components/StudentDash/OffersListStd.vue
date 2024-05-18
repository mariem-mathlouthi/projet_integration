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
              <option value="title">Titre</option>
              <option value="description">Description</option>
              <option value="company">Entreprise</option>
            </select>
            <input
              type="text"
              v-model="searchQuery"
              placeholder="Rechercher..."
              class="ml-4 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500"
            />
            <button
              @click.prevent="search(searchQuery, searchCriteria)"
              class="ml-4 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
            >
              Rechercher
            </button>
          </div>
        </div>

        <h2 class="text-2xl font-bold mb-8">Liste des stages disponibles</h2>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <div
            v-for="offre in filteredOffres"
            :key="offre.id"
            class="bg-purple-100 border border-purple-300 shadow-lg rounded-lg p-4"
          >
          <h3 class="text-lg font-semibold mb-2"><span class="text-blue-800 font-bold">Titre :</span> {{ offre.titre }}</h3>
            <p class="text-gray-700 mb-4"><span class="text-blue-800 font-bold">Description :</span> {{ offre.description }}</p>
            <p class="text-gray-700 mb-4"><span class="text-blue-800 font-bold">Entreprise :</span> {{ offre.entrepriseName }}</p>
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
import Navbar from './NavBarStd.vue';
import Sidebar from './Sidebar.vue';
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
      filteredOffres: [],
      searchCriteria: "title",
      searchQuery: "",
    };
  },
  methods: {
    async getAllOffre() {
      try {
        const response = await axios.get("http://localhost:8000/api/allOffres");
        if (response.data.check === true) {
          console.log(response.data.offres);
          
          for (let i = 0; i < response.data.offres.length; i++) {
            if (response.data.offres[i].status === 'accepté') {
              const response2 = await axios.get(
                `http://localhost:8000/api/getEntreprise/${response.data.offres[i].idEntreprise}`
              );
              let myObject = {
                id: response.data.offres[i].id,
                titre: response.data.offres[i].titre,
                description: response.data.offres[i].description,
                entrepriseName: response2.data.entreprise.name,
              };
              console.log(myObject);
              this.offres.push(myObject);
              console.log(this.offres);
              this.filteredOffres = this.offres;
            }
          }
        } else {
          toast.error("Something went wrong!", {
            autoClose: 2000,
          });
        }
      } catch (error) {
        console.error("Error:", error);
      }
    },

    search(searchQuery, searchCriteria) {
      const query = searchQuery.toLowerCase();
      const queryWords = query.split(" ");
      
      if (query === "all") {
        this.filteredOffres = this.offres;
        return;
      }

      this.filteredOffres = this.offres.filter((offre) => {
        if (searchCriteria === "title") {
          return queryWords.some((word) =>
            offre.titre.toLowerCase().includes(word)
          );
        } else if (searchCriteria === "description") {
          return queryWords.some((word) =>
            offre.description.toLowerCase().includes(word)
          );
        } else if (searchCriteria === "company") {
          return queryWords.some((word) =>
            offre.entrepriseName.toLowerCase().includes(word)
          );
        }
      });
    },
  },
};
</script>
