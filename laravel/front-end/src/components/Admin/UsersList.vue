<template>
  <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
      <div class="col-span-9 mt-24 mr-24 ml-24">
        <h1 class="text-center font-weight-bold my-4">Liste des Entreprises</h1>
        <table id="example" class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
          <thead class="bg-gray-100 whitespace-nowrap">
            <tr>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">NomEntreprise</th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Email</th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Secteur</th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Numero SIRET</th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
            </tr>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200 whitespace-nowrap">
            <tr v-for="enterprise in enterprises" :key="enterprise.id">
              <td class="px-6 py-4 text-sm text-[#333]">{{enterprise.name}}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{enterprise.email}}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{enterprise.secteur}}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{enterprise.numeroSIRET}}</td>
              <td class="px-6 py-4 text-sm text-[#333]">
                <button class="text-red-500 hover:text-red-700" @click="deleteEnterprise(enterprise.id)">Supprimer</button>
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
import axios from 'axios';

export default {
  name: 'App',
  components: {
    NavbarOne,
    SidebarMenu
  },
  data() {
    return {
      enterprises: [] // to store fetched enterprises
    };
  },
  mounted() {
    this.fetchEnterprises();
  },
  methods: {
    fetchEnterprises() {
      axios.get('http://localhost:8000/api/enterprisesAdmin')
        .then(response => {
          this.enterprises = response.data.enterprises;
          console.table(this.enterprises);
        })
        .catch(error => {
          console.error('Error fetching enterprises:', error);
        });
    },
    deleteEnterprise(id) {
      if (window.confirm("Êtes-vous sûr de vouloir supprimer cette entreprise ?")) {
        axios.delete(`http://localhost:8000/api/enterprisesAdmin/${id}`)
          .then(response => {
            console.log(response.data.message); // Afficher un message de confirmation
            this.fetchEnterprises(); // Recharger la liste des entreprises après la suppression
          })
          .catch(error => {
            console.error('Erreur lors de la suppression de l\'entreprise :', error);
          });
      }
    }
  }
}
</script>

<style scoped>
/* Your scoped styles here */
</style>
