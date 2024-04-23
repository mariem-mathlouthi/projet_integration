<template>
    <div>
      <Navbar /> <!-- Supposons que vous avez un composant Navbar déjà créé -->
      <div class="grid grid-cols-12 gap-4">
        <!-- Colonne de la barre latérale -->
        <div class="col-span-3">
          <Sidebar /> <!-- Supposons que vous avez un composant Sidebar déjà créé -->
        </div>
        
        <!-- Colonne principale -->
        <div class="col-span-9 mt-24 mr-24">
        
  
          <!-- Barre de recherche -->
          <div class="flex justify-end mb-8">
            <div class="flex items-center">
              <select v-model="searchCriteria" class="px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500">
                <option value="title">Titre</option>
                <option value="description">Description</option>
                <option value="company">Entreprise</option>
              </select>
              <input type="text" v-model="searchQuery" placeholder="Rechercher..." class="ml-4 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500">
              <button @click="search" class="ml-4 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Rechercher</button>
            </div>
          </div>
    <!-- Titre de la page -->
    <h2 class="text-2xl font-bold mb-8">Liste des stages disponibles</h2>
          <!-- Liste des stages filtrée par la recherche -->
          <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            <div v-for="(stage, index) in filteredStages" :key="index" class="bg-white shadow rounded-lg p-4">
              <h3 class="text-lg font-semibold mb-2">{{ stage.title }}</h3>
              <p class="text-gray-600 mb-4">{{ stage.description }}</p>
              <div class="flex items-center justify-between">
                <span class="text-gray-500">{{ stage.company }}</span>
                <RouterLink to="/DetailsOffreStd" >
                <button class="px-4 py-2 bg-purple-500 text-white rounded hover:bg-purple-600">Voir Détails</button>
               </RouterLink>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
    // Importez les composants Navbar et Sidebar si nécessaire
    import { RouterLink } from 'vue-router';
import Navbar from './NavBarStd.vue';
    import Sidebar from './Sidebar.vue';
  
    export default {
      components: {
        Navbar,
        Sidebar
      },
      data() {
        return {
          searchCriteria: 'title', // Critère de recherche par défaut
          searchQuery: '', // Requête de recherche saisie par l'utilisateur
          stages: [ // Liste des stages (peut être remplie avec vos données réelles)
            { title: 'Stage en développement web', description: 'Description du stage...', company: 'Entreprise XYZ' },
            { title: 'Stage en marketing digital', description: 'Description du stage...', company: 'Entreprise ABC' },
            { title: 'Stage en design graphique', description: 'Description du stage...', company: 'Entreprise XYZ' }
            // Ajoutez d'autres stages si nécessaire
          ]
        };
      },
      computed: {
        filteredStages() {
          // Filtrer les stages en fonction du critère de recherche et de la requête de recherche
          return this.stages.filter(stage => {
            return stage[this.searchCriteria].toLowerCase().includes(this.searchQuery.toLowerCase());
          });
        }
      },
      methods: {
        search() {
          // Cette méthode peut être utilisée pour déclencher une recherche manuelle si nécessaire
          // Vous pouvez ajouter ici la logique pour gérer la recherche au clic sur le bouton de recherche
        }
      }
    };
  </script>
  