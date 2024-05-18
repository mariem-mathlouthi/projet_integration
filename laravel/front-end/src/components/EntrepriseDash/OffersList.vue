<template>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <Navbar/>
    <div  class="grid grid-cols-12">
        <div class="col-span-3">
            <Sidebar />
        </div>
        
        <div class="col-span-9 mt-24  mr-12">
            <h2 class="text-2xl font-bold mb-8 mt-8">Liste des offres</h2>
            <div class="overflow-x-auto">
                <div class="flex justify-end mb-4">
                <router-link to="/AddOffer">
                    <button type="button"
                            class="px-6 py-2 rounded-full text-black text-sm tracking-wider font-medium outline-none border-2 border-purple-600 hover:bg-purple-300 hover:text-white transition-all duration-300 flex items-center gap-2">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter une nouvelle offre</span>
                    </button>
                </router-link>

                </div>
                <div class="overflow-x-auto">
  <table class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
    <thead class="bg-gray-100 whitespace-nowrap">
      <tr>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          Id
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
          Details
        </th>
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
                      <router-link :to="'/detailoffre/' + offre.id">Dtails</router-link>
                  </button>
              </td>
          </tr>
      </tbody>
  </table>
</div>
            </div>
        </div>
    </div>
</template>

<script>
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
import Navbar from './Navbar.vue';
import Sidebar from './SideBar.vue';
export default {
  data() {
    return {
        offres:[],
        idEntreprise:"",
    };
  },
    components: {
        Navbar,
        Sidebar
    },
    methods: {


      async getAllOffres() {
    let storedData = localStorage.getItem("EntrepriseAccountInfo"); 
    this.idEntreprise = JSON.parse(storedData).id;
    console.log(this.idEntreprise);
    try {
        const response = await axios.get(
            `http://localhost:8000/api/getOffres/${this.idEntreprise}`
        );
        
        if (response.data.check === true) {
            this.offres = response.data.offres;
            console.table(this.offres);
        } else {
            toast.error("Something went wrong !", {
                autoClose: 2000,
            });
        }
    } catch (error) {
        console.error("Error:", error);
    }
},

    

},

mounted() {
this.getAllOffres();
},
}
</script>

<style>

</style>
