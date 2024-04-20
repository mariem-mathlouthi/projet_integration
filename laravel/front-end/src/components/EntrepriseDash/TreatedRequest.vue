<template>
    <div>
      <Navbar />
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <h2 class="text-2xl font-bold mb-8">Liste des demandes traitées</h2>
          <!-- Ajoutez des boutons pour choisir le type de liste -->
          <div class="flex justify-end mb-4 font-sans text-center">
  <button
    class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-purple-600 hover:bg-purple-600 hover:text-white transition-all duration-300 flex items-center mr-4">
    <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
    </svg>
    Approuvées
  </button>
  <button
    class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-blue-600 hover:bg-blue-600 hover:text-white transition-all duration-300 flex items-center mr-4">
    <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
    </svg>
  on hold
  </button>
  <button
    class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600 hover:text-white transition-all duration-300 flex items-center mr-4">
    <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
    </svg>
   on execution
  </button>
  <button
    class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-red-600 hover:bg-red-600 hover:text-white transition-all duration-300 flex items-center">
    <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
    </svg>
    Rejetées
  </button>
</div>



          <div class="overflow-x-auto">
            <ul class="divide-y divide-gray-200">
              <li  class="py-6 flex justify-between items-center">
                <div class="flex items-center">
                  <div class="mr-4 flex-shrink-0">
                    <svg class="h-6 w-6 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
                    </svg>
                  </div>
                  <div>
                    <p class="text-sm font-medium text-gray-900">demande1</p>
                    <p class="text-sm text-gray-500">Approuvées</p>
                  </div>
                </div>
                <div class="flex items-center">
                    <router-link to="/detailoffre"><button class="text-blue-500 hover:text-blue-700 mr-4">Détails</button></router-link>
                 
                </div>
              </li>
              <li  class="py-6 flex justify-between items-center">
                <div class="flex items-center">
                  <div class="mr-4 flex-shrink-0">
                    <svg class="h-6 w-6 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
                    </svg>
                  </div>
                  <div>
                    <p class="text-sm font-medium text-gray-900">demande2</p>
                    <p class="text-sm text-gray-500">on hold</p>
                  </div>
                </div>
                <div class="flex items-center">
                    <router-link to="/detailoffre"><button class="text-blue-500 hover:text-blue-700 mr-4">Détails</button></router-link>
          
                </div>
              </li>
              <li class="py-6 flex justify-between items-center">
                <div class="flex items-center">
                  <div class="mr-4 flex-shrink-0">
                    <svg class="h-6 w-6 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
                    </svg>
                  </div>
                  <div>
                    <p class="text-sm font-medium text-gray-900">demande 3</p>
                    <p class="text-sm text-gray-500">traités</p>
                  </div>
                </div>
                <div class="flex items-center">
                    <router-link to="/detailoffre"><button class="text-blue-500 hover:text-blue-700 mr-4">Détails</button></router-link>
                 
                </div>
              </li>
              <li class="py-6 flex justify-between items-center">
                <div class="flex items-center">
                  <div class="mr-4 flex-shrink-0">
                    <svg class="h-6 w-6 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
                    </svg>
                  </div>
                  <div>
                    <p class="text-sm font-medium text-gray-900">demande 4</p>
                    <p class="text-sm text-gray-500">traités</p>
                  </div>
                </div>
                <div class="flex items-center">
                    <router-link to="/detailoffre"><button class="text-blue-500 hover:text-blue-700 mr-4">Détails</button></router-link>
             
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from './Navbar.vue';
  import Sidebar from './SideBar.vue';
  
  export default {
    name: 'TreatedRequests',
    components: {
      Navbar,
      Sidebar
    },
    
  }
  </script>
  
  <style>
  /* Ajoutez vos styles de tableau de bord spécifiques ici */
  </style>
  