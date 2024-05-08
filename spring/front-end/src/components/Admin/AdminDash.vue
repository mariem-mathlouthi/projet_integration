<!-- App.vue -->
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>

     <DashboardContent></DashboardContent>
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
     

      

      // Handle dark mode switch
      if (switchMode) {
        switchMode.addEventListener('change', () => {
          document.body.classList.toggle('dark');
        });
      }

      // Handle sidebar menu items
      
    }
  }
};
</script>

