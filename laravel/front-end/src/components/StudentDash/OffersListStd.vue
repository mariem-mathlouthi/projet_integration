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
              @click="search(searchCriteria, searchQuery)"
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
            <div class="flex items-center justify-between">
              <span class="text-gray-500">{{ offre.idEntreprise }}</span>

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
import OffreService from "../../service/offreService/OffreService";


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
      searchCriteria: "",
      searchQuery: "",
    };
  },
  methods: {
    getAllOffre() {
      OffreService.getAllOffre().then((res) => {
        this.offres = res.data.data;
      });
    },
    search(key, searchValue) {
      OffreService.searchOffre(key, searchValue).then((res) => {
        this.offres = res.data;
      });
    },
  },
};
</script>
