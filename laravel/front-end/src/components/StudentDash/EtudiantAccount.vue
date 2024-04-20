<template>
    <div>
      <Navbar/>
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <form class="font-sans text-[#333] max-w-4xl mx-auto px-6 my-6">
            <div class="grid sm:grid-cols-2 gap-10">
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Prénom</label>
                <input type="text" placeholder="Entrez votre prénom"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Nom</label>
                <input type="text" placeholder="Entrez votre nom de famille"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Adresse e-mail</label>
                <input type="email" placeholder="Entrez votre adresse e-mail"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Mot de passe</label>
                <input type="password" placeholder="Entrez votre mot de passe"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Date de naissance</label>
                <input type="date" placeholder="Entrez votre date de naissance"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center sm:col-span-2">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Photo de profil</label>
                <input type="file" accept="image/*"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
            </div>
            <button type="submit" class="mt-10 px-2 py-2.5 w-full rounded text-sm font-semibold bg-[#333] text-white hover:bg-[#222]">Soumettre</button>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from './NavBarStd.vue';
  import Sidebar from './Sidebar.vue';
  
  export default {
    name: 'StudentDashboard', // Changement du nom du composant
    components: {
      Navbar,
      Sidebar
    }
  }
  </script>
  
  <style>
  /* Styles spécifiques à votre tableau de bord étudiant */
  </style>
  