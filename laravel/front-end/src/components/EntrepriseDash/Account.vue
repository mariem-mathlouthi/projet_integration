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
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Numero SIRET</label>
                <input type="text" placeholder="Enter SIRET number"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Name</label>
                <input type="text" placeholder="Enter company name"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Email</label>
                <input type="email" placeholder="Enter email"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Password</label>
                <input type="password" placeholder="Enter password"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Secteur</label>
                <input type="text" placeholder="Enter company sector"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center sm:col-span-2">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Description</label>
                <input type="text" placeholder="Enter company description"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
              <div class="relative flex items-center sm:col-span-2">
                <label class="text-[13px] absolute top-[-10px] left-0 font-semibold">Logo</label>
                <input type="file" accept="image/*"
                  class="px-2 pt-5 pb-2 bg-white w-full text-sm border-b-2 border-gray-100 focus:border-[#333] outline-none" />
              </div>
            </div>
            <button type="submit" class="mt-10 px-2 py-2.5 w-full rounded text-sm font-semibold bg-[#333] text-white hover:bg-[#222]">Submit</button>
          </form>
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
  