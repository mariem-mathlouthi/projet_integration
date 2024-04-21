<!-- App.vue -->
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
     
     <table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Pays</th>
                <th>Age</th>
                <th>Start date</th>
               
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011-04-25</td>
              
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011-07-25</td>
                
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009-01-12</td>
              
            </tr>
           
            <tr>
                <td>Bruno Nash</td>
                <td>Software Engineer</td>
                <td>London</td>
                <td>38</td>
                <td>2011-05-03</td>
                
            </tr>
          
    
            <tr>
                <td>Donna Snider</td>
                <td>Customer Support</td>
                <td>New York</td>
                <td>27</td>
                <td>2011-01-25</td>
               
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
             
            </tr>
        </tfoot>
    </table>
    </section>
  </div>
</template>


<script>
import NavbarOne from "../../components/Admin/NavbarOne.vue";
import SidebarMenu from "../../components/Admin/SidebarMenu.vue";



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

