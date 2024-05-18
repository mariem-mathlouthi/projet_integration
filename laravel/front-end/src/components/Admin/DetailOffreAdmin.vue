<template>
  <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>

      <div class="col-span-9 mt-24 mr-24">
        <router-link to="/OffresListAdmin" class="px-6 py-2 rounded bg-purple-400 hover:bg-purple-400 text-white ml-4 mt-4 no-underline">Back</router-link>
        <div class="container mx-auto px-4 py-8">
          <div class="bg-white shadow overflow-hidden sm:rounded-lg">
            <div class="px-4 py-5 sm:px-6 flex justify-between items-center">
              <div>
                <h3 class="text-lg font-medium leading-6 text-gray-900">Détails de l'offre</h3>
                <p class="mt-1 max-w-2xl text-sm text-gray-500">Informations détaillées sur l'offre</p>
              </div>
              <div class="flex space-x-4">
                <button @click="updateOfferStatus('accepté')" class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600  hover:text-white transition-all duration-300">Accepter</button>
                <button @click="updateOfferStatus('en attente')" class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-600  hover:text-white transition-all duration-300">Mettre En Attente</button>
                <button @click="updateOfferStatus('refusé')" class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-600 hover:text-white transition-all duration-300">Refuser</button>
                
                <form @submit.prevent="deleteOffre">
                  <button type="submit" class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-600 hover:bg-orange-600 hover:text-white transition-all duration-300" @click="confirmDelete">Delete</button>
                </form>
              </div>
            </div>

            <div class="border-t border-gray-200">
              <dl>
                <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">ID</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.id }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">ID de l'entreprise</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.idEntreprise }}</dd>
                </div>
                <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Statut</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.status }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Titre</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.titre }}</dd>
                </div>
                <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Description</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.description }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Domaine</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.domaine }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Date de début</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.dateDebut }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Date de fin</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.dateFin }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Type d'offre</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.typeOffre }}</dd>
                </div>
                <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                  <dt class="text-sm font-medium text-gray-500">Cahier des charges</dt>
                  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2">{{ offerDetails.cahierCharge }}</dd>
                </div>
              </dl>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
import NavbarOne from "./NavbarOne.vue";
import SidebarMenu from "./SidebarMenu.vue";

export default {
  name: 'app',
  components: {
    NavbarOne,
    SidebarMenu,
  },
  data() {
    return {
      offerDetails: {},
      offerId: "",
    };
  },
  created() {
    // Fetch offer details based on route parameter (offer ID)
    this.fetchOfferDetails(this.$route.params.id);
    this.offerId = this.$route.params.id;
  },
  methods: {
    async fetchOfferDetails(id) {
      try {
        const response = await axios.get(`http://localhost:8000/api/offreDetail2/${id}`);
        if (response.data.check === true) {
          this.offerDetails = response.data.offre;
        } else {
          console.error("Error fetching offer details:", response.data.message);
        }
      } catch (error) {
        console.error("Error fetching offer details:", error);
      }
    },
    async updateOfferStatus(status) {
      try {
        const response = await axios.post(`http://localhost:8000/api/updateOfferStatus/${this.offerId}`, {
          status: status
        });
        if (response.data.offer) {
          this.offerDetails = response.data.offer;
          toast.success("Offer status updated successfully", {
            autoClose: 2000,
          });
        } else {
          console.error('Error updating offer status:', response.data.message);
        }
      } catch (error) {
        console.error('Error updating offer status:', error);
      }
    },
    async deleteOffre() {
      if (window.confirm('Are you sure you want to delete this offer?')) {
        try {
          const response = await axios.post("http://localhost:8000/api/deleteOffre", { id: this.offerId });
          if (response.data.delete === true) {
            this.$router.push('/OffresListAdmin');
          } else {
            toast.error("Something went wrong !", {
              autoClose: 2000,
            });
          }
        } catch (error) {
          console.error("Error", error);
        }
      }
    },
  }
};
</script>

<style scoped>
/* Vos styles CSS ici */
</style>
