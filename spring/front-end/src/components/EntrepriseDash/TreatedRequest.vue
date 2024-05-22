<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <!-- Ajoutez des boutons pour choisir le type de liste -->
      <div class="flex justify-end mb-4 font-sans text-center">
        <button
          @click.prevent="filterByStatut('accepté')"
          class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-300 hover:text-white transition-all duration-300 flex items-center mr-4"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M5 13l4 4L19 7"
            ></path>
          </svg>
          Approvées
        </button>
        <button
          @click.prevent="filterByStatut('en_execution')"
          class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-400 hover:bg-orange-300 hover:text-white transition-all duration-300 flex items-center mr-4"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M5 13l4 4L19 7"
            ></path>
          </svg>
          En execution
        </button>
        <button
          @click.prevent="filterByStatut('en_attente')"
          class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-blue-600 hover:bg-blue-300 hover:text-white transition-all duration-300 flex items-center mr-4"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M5 13l4 4L19 7"
            ></path>
          </svg>
          En attente
        </button>

        <button
          @click.prevent="filterByStatut('refusé')"
          class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-red-600 hover:bg-red-300 hover:text-white transition-all duration-300 flex items-center"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M5 13l4 4L19 7"
            ></path>
          </svg>
          Rejetées
        </button>
      </div>

      <h2 class="text-2xl font-bold mb-8 mt-8">
        Liste des demandes des étudiants
      </h2>

      <!-- Liste des demandes d'étudiants -->
      <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
          <thead class="bg-gray-50">
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              ID
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              Nom et Prénom
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              Status
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              Date Soumission
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              CV
            </th>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200">
            <!-- Boucle à travers les demandes d'étudiants -->
            <tr v-for="(demande, index) in filteredDemands" :key="index">
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.id }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.etudiant.fullname }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.statut }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.dateSoumission }}
              </td>
              <td class="px-6 py-4 text-sm text-[#333]">
                <button
                  class="text-green-500 hover:text-red-700"
                  @click="downloadCV(demande.cv)"
                >
                  Télécharger CV</button
                ><br />
                <button
                  v-if="this.currentStatus == 'en_execution'"
                  class="text-green-500 hover:text-red-700"
                  @click="generateAttestation(demande)"
                >
                  valider Stage
                </button>
              </td>

              <!-- Ajoutez d'autres colonnes pour afficher d'autres informations sur les demandes -->
            </tr>
          </tbody>
        </table>
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
      currentStatus: "",
      demands: [],
      filteredDemands: [],
      storedDemands: [],
    };
  },
  components: {
    Navbar,
    Sidebar,
  },
  methods: {
    filterByStatut(statut) {
      this.filteredDemands = [];
      this.currentStatus = statut;
      this.storedDemands.forEach((demande) => {
        if (demande.statut == statut) {
          this.filteredDemands.push(demande);
        }
      });
    },

    async getAllDemandes() {
      const storedData = localStorage.getItem("EntrepriseAccountInfo");
      const idEntreprise = JSON.parse(storedData).id;

      const response = await axios
        .get("http://localhost:8087/api/demandes/all/")
        .then(function (response) {
          return response.data;
        })
        .catch(function (error) {
          console.error("Error:", error);
          toast.error("An error occurred while fetching data!", {
            autoClose: 2000,
          });
        });

      response.forEach((demande) => {
        if (demande.offreDeStage.entreprise.id == idEntreprise) {
          this.storedDemands.push(demande);
        }
      });
      this.filteredDemands = this.storedDemands;
    },
    async downloadCV(CVname) {
      await axios
        .get("http://localhost:8087/file/download/" + CVname, {
          responseType: "blob",
        })
        .then((res) => {
          const FileData = new Blob([res.data], {
              type: res.headers["content-type"],
            }),
            FileURL = window.URL.createObjectURL(FileData),
            HyperLink = document.createElement("a");

          HyperLink.href = FileURL;
          HyperLink.setAttribute("download", CVname);
          document.body.appendChild(HyperLink);
          HyperLink.click();
          // remove unused constants
          window.URL.revokeObjectURL(FileURL);
          document.body.removeChild(HyperLink);

          toast.success("File is downlloading", {
            autoClose: 2000,
          });
        })
        .catch(function (error) {
          console.log(error);
          toast.error("Something went wrong !", {
            autoClose: 2000,
          });
        });
    },
    async generateAttestation(demande) {
      await axios
        .post("http://localhost:8087/file/generateAtt", demande, {
          responseType: "blob",
        })
        .then((res) => {
          const FileData = new Blob([res.data], {
              type: res.headers["content-type"],
            }),
            FileURL = window.URL.createObjectURL(FileData),
            HyperLink = document.createElement("a");

          HyperLink.href = FileURL;
          HyperLink.setAttribute("download", "attestation.pdf");
          document.body.appendChild(HyperLink);
          HyperLink.click();
          // remove unused constants
          window.URL.revokeObjectURL(FileURL);
          document.body.removeChild(HyperLink);

          toast.success("Attestation Generated", {
            autoClose: 2000,
          });
        })
        .catch(function (error) {
          console.log(error);
          toast.error("Something went wrong !", {
            autoClose: 2000,
          });
        });
    },
  },

  mounted() {
    this.getAllDemandes();
  },
};
</script>

<style>
/* Ajoutez vos styles de tableau de bord spécifiques ici */
</style>
