<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <!-- Ajoutez des boutons pour choisir le type de liste -->

      <h2 class="text-2xl font-bold mb-8 mt-8">Liste des étudiants</h2>

      <!-- Liste des demandes d'étudiants -->
      <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
          <thead class="bg-gray-50">
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
              ID Étudiant
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              ID Offre
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              Type de Stage Demandé
            </th>
            <th
              scope="col"
              class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
            >
              Actions
            </th>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200">
            <!-- Boucle à travers les demandes d'étudiants -->
            <tr v-for="(demande, index) in filteredDemands" :key="index">
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.etudiant.fullname }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.etudiant.id }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.offreDeStage.id }}
              </td>
              <td
                class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
              >
                {{ demande.etudiant.typeStage }}
              </td>
              <td class="px-6 py-4 text-sm text-[#333]">
                <button
                  class="text-green-500 hover:text-green-700 mr-4"
                ></button>

                <button
                  type="submit"
                  class="text-red-500 hover:text-red-700"
                  @click="deleteDemande(demande.id)"
                >
                  Supprimer Demande
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

    async deleteDemande(id) {
      await axios
        .get("http://localhost:8087/api/demandes/delete/" + id)
        .then(function (response) {
          toast.success("demande est supprimée", {
            autoClose: 2000,
          });
          setTimeout(() => {
            window.location.reload();
          }, "2000");
        })
        .catch(function (error) {
          console.error("Error:", error);
          toast.error("An error occurred while deleting the demande!", {
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

<style></style>
