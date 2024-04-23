<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
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
            <button type="submit" class="mt-10 px-2 py-2.5 w-full rounded text-sm font-semibold bg-[#333] text-white hover:bg-[#222]">Save</button>
          </form>
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

