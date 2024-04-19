<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
  <div class="bg-white p-6 rounded-lg shadow-md w-250 h-64">
    <h1 class="text-3xl font-semibold text-gray-800 mb-4">Hello, Enterprise!</h1>
    <p class="text-lg text-gray-600">Welcome to your dashboard. Here you can manage your business efficiently.</p>
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
  