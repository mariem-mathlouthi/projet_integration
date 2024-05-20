<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <router-link
        to="/OffersList"
        class="px-6 py-2 rounded bg-purple-400 hover:bg-purple-400 text-white ml-4 mt-4 no-underline"
        >Back</router-link
      >
      <div class="container mx-auto px-4 py-8">
        <div class="bg-white shadow overflow-hidden sm:rounded-lg">
          <div class="px-4 py-5 sm:px-6 flex justify-between items-center">
            <div>
              <h3 class="text-lg font-medium leading-6 text-gray-900">
                Edit offre
              </h3>
              <p class="mt-1 max-w-2xl text-sm text-gray-500">
                Informations détaillées sur l'offre
              </p>
            </div>
          </div>

          <div class="border-t border-gray-200">
            <dl>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">Titre</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.titre"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">Description</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.description"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">Domaine</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.domaine"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">dateDebut</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.dateDebut"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">dateFin</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.dateFin"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">typeOffre</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="text"
                    v-model="this.offerDetails.typeOffre"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div
                class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6"
              >
                <dt class="text-sm font-medium text-gray-500">CahierCharhe</dt>
                <dd class="mt-1 sm:col-span-2">
                  <input
                    type="file"
                    @change="handleFileUpload"
                    accept=".pdf"
                    class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </dd>
              </div>
              <div class="flex justify-end px-4 py-4 sm:px-6">
                <button
                  @click="save"
                  class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
                >
                  Save
                </button>
                <router-link to="/OffersList">
                  <button
                    type="button"
                    class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
                  >
                    Cancel
                  </button>
                </router-link>
              </div>
              <!-- Ajoutez plus de paires de termes et de définitions pour afficher d'autres détails de l'offre -->
            </dl>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
import Navbar from "./Navbar.vue";
import Sidebar from "./SideBar.vue";
export default {
  data() {
    return {
      offerDetails: "",
      idEntreprise: "",
      offerId: "",
      update: false,
      NvcahierCharge: null,
    };
  },
  components: {
    Navbar,
    Sidebar,
  },
  created() {
    // Fetch offer details based on route parameter (offer ID)
    this.offerId = this.$route.params.id;
    this.idEntreprise = this.$route.params.idEntreprise;
    this.fetchOfferDetails();
  },
  methods: {
    handleFileUpload(event) {
      this.NvcahierCharge = event.target.files[0];
      this.update = true;
      console.log(this.NvcahierCharge);
    },

    async fetchOfferDetails() {
      const response = await axios
        .get("http://localhost:8087/api/offres/" + this.offerId)
        .then(function (response) {
          return response.data;
        })
        .catch(function (error) {
          console.error("Error:", error);
          toast.error("Something went wrong !", { autoClose: 2000 });
        });
      console.log(response);
      this.offerDetails = response;
    },

    async save() {
      // upload cahierCharge
      if (this.update) {
        var FileData = new FormData();
        FileData.append("file", this.NvcahierCharge);

        await axios
          .post("http://localhost:8087/file/upload", FileData)
          .then(function (response) {
            toast.success("Cahier de Charge uploaded succesfully !", {
              autoClose: 2000,
            });
          })
          .catch(function (error) {
            toast.error("failed to upload file !" + error.message, {
              autoClose: 2000,
            });
            console.log(error);
          });
      }

      let myjson = {
        id: this.offerId,
        status: this.offerDetails.status,
        titre: this.offerDetails.titre,
        description: this.offerDetails.description,
        domaine: this.offerDetails.domaine,
        dateDebut: this.offerDetails.dateDebut,
        dateFin: this.offerDetails.dateFin,
        typeOffre: this.offerDetails.typeOffre,
        cahierCharge: this.offerDetails.cahierCharge,
      };
      if (this.update) {
        myjson.cahierCharge = this.NvcahierCharge.name;
      }

      await axios
        .post("http://localhost:8087/api/offres/updateOffre", myjson)
        .then(function (response) {
          toast.success("Offre updated succesfully !", {
            autoClose: 2000,
          });
        })
        .catch(function (error) {
          toast.error("Something went wrong !", {
            autoClose: 2000,
          });
        });
    },
  },
};
</script>

<style>
.bg-gray-500 {
  margin-right: 250px;
}
</style>
