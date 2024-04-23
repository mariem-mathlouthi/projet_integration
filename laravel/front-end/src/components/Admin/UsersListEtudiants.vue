<!-- App.vue -->
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
      
<div class="col-span-9 mt-24 mr-24 ml-24">
 <h1 class="text-center font-weight-bold my-4">Liste des Etudiantes</h1>


      <table class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
    <thead class="bg-gray-100 whitespace-nowrap">
      <tr>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
        FullName
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            Email
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          Specialite
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            CIN
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            logo
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          Action
        </th>
      </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200 whitespace-nowrap">
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          John Doe
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          john@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
        INFO
        </td>
       
      
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-05-15
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
             <button class="text-red-500 hover:text-red-700">Supprimer</button>
         <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Supprimer</button>--> 
        </td>
      </tr>
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          Jane Smith
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          jane@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          INFO
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-20
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
             <button class="text-red-500 hover:text-red-700">Supprimer</button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
      </tr>
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          Alen doe
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          alen@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          INFO
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-21
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Supprimer</button>--> 
          <button class="text-red-500 hover:text-red-700">Supprimer</button>
        </td>
      </tr>
    </tbody>
  </table>
</div>
    </section>
    <!-- CONTENT -->
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

