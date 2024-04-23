<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
    <div class="col-span-9 mt-24 mr-24">
        <router-link to="/OffresListAdmin" class="px-6 py-2 rounded bg-blue-400 hover:bg-blue-400 text-white ml-4 mt-4 no-underline">Back</router-link>

        <div class="container mx-auto px-4 py-8">
    <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6 flex justify-between items-center">
    <div>
        <h3 class="text-lg font-medium leading-6 text-gray-900">Détails de l'offre</h3>
        <p class="mt-1 max-w-2xl text-sm text-gray-500">Informations détaillées sur l'offre</p>
    </div>
    <div class="flex space-x-4">


        <router-link to="/OffresListAdmin">
            <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600  hover:text-white transition-all duration-300">Accepte</button>
        </router-link>
        <router-link to="/OffresListAdmin">
            <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600  hover:text-white transition-all duration-300">Metter En Attente</button>
        </router-link>
        <router-link to="/OffresListAdmin">
         <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-600 hover:text-white transition-all duration-300">Supprimer</button>
        </router-link>
        <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-600 hover:text-white transition-all duration-300">Refuser</button>
    </div>
</div>

      <div class="border-t border-gray-200">
        <dl>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">ID</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">1</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">ID de l'entreprise</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">123</dd>
          </div>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Statut</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">Active</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Titre</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">Développeur Web</dd>
          </div>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Description</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">'Recherche un développeur web expérimenté pour rejoindre notre équipe.'</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">Domaine</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">Technologie</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">dateDebut</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">2024-06-01</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">dateFin</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">Technologie</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">typeOffre</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">type</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">CahierCharhe</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">file</dd>
          </div>
          <!-- Ajoutez plus de paires de termes et de définitions pour afficher d'autres détails de l'offre -->
        </dl>
      </div>
    </div>
  </div>

</div>
</section>
</div>
  </template>
  
 
<script>
import NavbarOne from "./NavbarOne.vue";
import SidebarMenu from "./SidebarMenu.vue";
import DashboardContent from "./DashboardContent.vue";

export default {
  name: 'App',
  components: {
    NavbarOne,
    SidebarMenu,
    DashboardContent
  },
mounted() {
    // Call the method to set up toggle sidebar functionality
    this.setupToggleSidebar();
  },
  methods: {
    setupToggleSidebar() {
      // Select elements by IDs
     
      const searchButton = document.querySelector('#content nav form .form-input button');
      const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
      const searchForm = document.querySelector('#content nav form');
      const switchMode = document.getElementById('switch-mode');

      // Add event listeners
     

      if (searchButton) {
        searchButton.addEventListener('click', (e) => {
          if (window.innerWidth < 576 && searchForm) {
            e.preventDefault();
            searchForm.classList.toggle('show');
            if (searchForm.classList.contains('show')) {
              searchButtonIcon.classList.replace('bx-search', 'bx-x');
            } else {
              searchButtonIcon.classList.replace('bx-x', 'bx-search');
            }
          }
        });
      }

      // Handle dark mode switch
      if (switchMode) {
        switchMode.addEventListener('change', () => {
          document.body.classList.toggle('dark');
        });
      }

      // Handle sidebar menu items
      const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
      if (allSideMenu) {
        allSideMenu.forEach(item => {
          const li = item.parentElement;
          item.addEventListener('click', () => {
            allSideMenu.forEach(i => {
              i.parentElement.classList.remove('active');
            });
            li.classList.add('active');
          });
        });
      }
    }
  }
};
</script>
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  




