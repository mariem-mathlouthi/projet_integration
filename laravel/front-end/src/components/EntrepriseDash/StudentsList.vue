<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      
          <h2 class="text-2xl font-bold mb-8 mt-8">Liste des demandes des étudiants</h2>
          

      <!-- Liste des demandes d'étudiants -->
      <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
          <thead class="bg-gray-50">
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Nom et Prénom</th>
              <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID Étudiant</th>
              <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID Offre</th>
              <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type de Stage Demandé</th>
              <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200">
            <!-- Boucle à travers les demandes d'étudiants -->
            <tr >
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">cyrine</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">1</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">123</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">pfe</td>
              <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/DetailStudent">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>

              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr>  
           
            <tr>
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">mazen</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">1</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">123</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">pfe</td>
              <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/DetailStudent">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr> 
             <tr >
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">mariem</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">1</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">123</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">pfe</td>
              <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/DetailStudent">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr>  <tr>
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">sohsoh</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">1</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">123</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">pfe</td>
              <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/DetailStudent">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr> 
             <tr >
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">hatem</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">1</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">123</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">pfe</td>
              <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr>
          </tbody>
        </table>
      
    </div>
    
</div>




  </div>
  </template>
  
  <script>
  import Navbar from './Navbar.vue';
  import Sidebar from './SideBar.vue';
  export default {
    name: 'EntrepriseDashboard',
    components: {
      Navbar,
      Sidebar
    }
  }
  </script>
  
  <style>
  /* Styles spécifiques à votre tableau de bord d'entreprise */
  </style>
  