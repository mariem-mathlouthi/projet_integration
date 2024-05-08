<template>
  <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
      <div class="col-span-9 mt-24 mr-24 ml-24">
        <h1 class="text-center font-weight-bold my-4">Liste des offres</h1>
  <table  class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
    <thead class="bg-gray-100 whitespace-nowrap">
        <tr>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Id</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">status</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">titre</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">description</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Details</th>
        </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200 whitespace-nowrap">
        <tr v-for="(offre, index) in offres" :key="index">
            <td class="px-6 py-4 text-sm text-[#333]">{{ index+1 }}</td>
            <td class="px-6 py-4 text-sm text-[#333]">{{ offre.status }}</td>
            <td class="px-6 py-4 text-sm text-[#333]">{{ offre.titre }}</td>
            <td class="px-6 py-4 text-sm text-[#333]">{{ offre.description }}</td>
            <td class="px-6 py-4 text-sm text-[#333]">
                <button class="text-green-500 hover:text-green-700 mr-4">
                    <router-link :to="'/DetailOffreAdmin/' + offre.id">Details</router-link>
                </button>
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
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
import NavbarOne from "../Admin/NavbarOne.vue";
import SidebarMenu from "../Admin/SidebarMenu.vue";
import DashboardContent from "../Admin/DashboardContent.vue";

export default {
  data() {
    return {
      offres: [],
    };
  },
  components: {
    NavbarOne,
    SidebarMenu,
    DashboardContent,
  },
  methods: {
    async getAllOffresAdmin() {
      try {
        const response = await axios.get(
          `http://localhost:8087/admin/offres`, 
          { 
            headers: { 
              'Cache-Control': 'no-cache' // Ensure no caching 
            } 
          }
        );
        
          this.offres = response.data;
          console.log(this.offres);
          console.table(this.offres);
       
      } catch (error) {
        console.error("Error fetching data:", error);
        
      }
    },
  },
  mounted() {
    this.getAllOffresAdmin();
  },
};
</script>
