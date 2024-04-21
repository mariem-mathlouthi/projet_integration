<!-- App.vue -->
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
        
        <div class="col-span-9 mt-24  mr-12">
            <h2 class="text-2xl font-bold mb-8 mt-8">Offers List</h2>
            <div class="overflow-x-auto">
                <div class="flex justify-end mb-4">
                <router-link to="/AddOfferAdmin">
                    <button type="button"
                            class="px-6 py-2 rounded-full text-black text-sm tracking-wider font-medium outline-none border-2 border-purple-600 hover:bg-purple-600 hover:text-white transition-all duration-300 flex items-center gap-2">
                        <i class="fas fa-plus"></i> <!-- Add icon -->
                        <span>Add new Offer</span>
                    </button>
                </router-link>

                </div>
                <div class="overflow-x-auto">
  <table class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
    <thead class="bg-gray-100 whitespace-nowrap">
      <tr>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
        id
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            idEntreprise
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          status
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            titre
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            description
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          Actions
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
          Admin
        </td>
       
      
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-05-15
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
         <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
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
          User
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-20
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
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
          User
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-21
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
      </tr>
    </tbody>
  </table>
</div>
            </div>
        </div>
    </section>
    </div>

</template>

<script>
import NavbarOne from "../Admin/NavbarOne.vue";
import SidebarMenu from "../Admin/SidebarMenu.vue";
import DashboardContent from "../Admin/DashboardContent.vue";


export default {
  name: 'App',
  components: {
    NavbarOne,
    SidebarMenu,
    DashboardContent,
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

