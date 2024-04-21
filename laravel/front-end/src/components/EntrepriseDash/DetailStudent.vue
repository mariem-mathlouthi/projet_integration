
<template>



    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
        <router-link to="/OffersList" class="px-6 py-2 rounded bg-purple-400 hover:bg-purple-400 text-white ml-4 mt-4 no-underline">Back</router-link>
        <div class="container mx-auto px-4 py-8">
    <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6 flex justify-between items-center">
    <div>
        <h3 class="text-lg font-medium leading-6 text-gray-900">Détails de l'Etudiant</h3>
        <p class="mt-1 max-w-2xl text-sm text-gray-500">Informations détaillées sur l'Etudiant</p>
    </div>
    <div class="flex space-x-4">


        <router-link to="/EditOffre">
            <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600  hover:text-white transition-all duration-300">Edit</button>
        </router-link>
        <button type="button"
            class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-600 hover:text-white transition-all duration-300">Delete</button>
    </div>
</div>

      <div class="border-t border-gray-200">
        <dl>
          <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">ID</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">1</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">ID de l'etudiant</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">123</dd>
          </div>
          <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
            <dt class="text-sm font-medium text-gray-500">nom</dt>
            <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">cyycy</dd>
          </div>
        
          <!-- Ajoutez plus de paires de termes et de définitions pour afficher d'autres détails de l'offre -->
        </dl>
      </div>
    </div>
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
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


