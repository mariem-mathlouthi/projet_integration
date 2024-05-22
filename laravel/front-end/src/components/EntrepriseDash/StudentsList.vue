<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <!-- Boutons de filtrage -->
      <div class="flex justify-end mb-4 font-sans text-center">
        <button @click.prevent="filterByStatut('accepté')"
                class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-green-600 hover:bg-green-300 hover:text-white transition-all duration-300 flex items-center mr-4">
          <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
               xmlns="http://www.w3.org/2000/svg">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
          </svg>
          Approvées
        </button>
        <button @click.prevent="filterByStatut('en execution')"
                class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-orange-400 hover:bg-orange-300 hover:text-white transition-all duration-300 flex items-center mr-4">
          <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
               xmlns="http://www.w3.org/2000/svg">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
          </svg>
          En execution
        </button>
        <button @click.prevent="filterByStatut('en attente')"
                class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-blue-600 hover:bg-blue-300 hover:text-white transition-all duration-300 flex items-center mr-4">
          <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
               xmlns="http://www.w3.org/2000/svg">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
          </svg>
          En attente
        </button>
        <button @click.prevent="filterByStatut('rejeté')"
                class="px-6 py-2 rounded text-black text-sm tracking-wider font-medium outline-none border-2 border-red-600 hover:bg-red-300 hover:text-white transition-all duration-300 flex items-center">
          <svg class="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24"
               xmlns="http://www.w3.org/2000/svg">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
          </svg>
          Rejetées
        </button>
      </div>

      <h2 class="text-2xl font-bold mb-8 mt-8">Liste des demandes des étudiants</h2>

      <!-- Liste des demandes d'étudiants -->
      <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
          <thead class="bg-gray-50">
            <th scope="col"
                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Nom et Prénom
            </th>
            <th scope="col"
                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID Étudiant
            </th>
            <th scope="col"
                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID Offre
            </th>
            <th scope="col"
                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type de Stage
                Demandé
            </th>
            <th scope="col"
                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200">
            <!-- Boucle à travers les demandes d'étudiants -->
            <tr v-for="(demande, index) in storedDemands" :key="index">
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ demande.fullname }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ demande.idEtudiant }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ demande.offerId }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ demande.typeStage }}</td>
              <td class="px-6 py-4 text-sm text-[#333]">
        
               
              
                <!-- Formulaire de suppression avec confirmation -->
                <form @submit.prevent="confirmDelete(demande.demandeId)" class="d-flex space-x-10">
                  <button type="submit" class="text-red-500 hover:text-red-700">Supprimer</button>
                  <div class="mb-4">
                <label for="uploadFile1" class="text-[#007bff] relative top-3" >Importer Attestation</label>
                <input type="file" id='uploadFile1' name="cv" class="hidden" @change="handleFileUpload"   />
              </div>
              <button @click.prevent="envoyer(demande.idEtudiant,demande.offerId)" class="text-green-500">envoyer</button>
                </form>
              </td>
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
import Navbar from './Navbar.vue';
import Sidebar from './SideBar.vue';

export default {
  data() {
    return {
      demands: [], // Liste de toutes les demandes
      filteredDemands: [], // Liste filtrée de demandes
      storedDemands: [], // Liste de demandes à afficher après filtrage
      attestation:"",
    };
  },
  components: {
    Navbar,
    Sidebar
  },
  methods: {
    // Filtrer les demandes par statut
    filterByStatut(statut) {
      this.storedDemands = this.filteredDemands.filter(demande => demande.statut === statut);
    },
    handleFileUpload(event) {
        this.attestation = event.target.files[0];
      },

    async envoyer(idEtudiant,offerId){
      const storedData = localStorage.getItem("EntrepriseAccountInfo");
      const idEntreprise = JSON.parse(storedData).id;
      const entrepriseName=JSON.parse(storedData).name;
      const currentDate = new Date();
      const day = String(currentDate.getDate()).padStart(2, '0');
      const month = String(currentDate.getMonth() + 1).padStart(2, '0');
      const year = currentDate.getFullYear();
      const formattedDate = `${day}-${month}-${year}`;
      const offerResponse = await axios.get(`http://localhost:8000/api/offreDetail2/${offerId}`);
      let offerName= offerResponse.data.offre.titre;
      let message=entrepriseName + " a envoyer une attestation en " + offerName;
      let formData = new FormData();
        formData.append('idEtudiant', idEtudiant);
        formData.append('idEntreprise', idEntreprise);
        formData.append('idOffreDeStage', offerId);
        formData.append('message', message);
        formData.append('date', formattedDate);
        formData.append('attestation', this.attestation);
        console.log(formData);
        const response = await axios.post("http://localhost:8000/api/attestation",formData);
        if (response.data.check === true) {
          toast.success("attestation envoyer  avec succès!", { autoClose: 2000 });
        } 
    },

    // Récupérer toutes les demandes
    async getAllDemandes() {
      try {
        const storedData = localStorage.getItem("EntrepriseAccountInfo");
        const idEntreprise = JSON.parse(storedData).id;

        // Récupérer toutes les offres de stage de l'entreprise
        const response = await axios.get(`http://localhost:8000/api/getOffres/${idEntreprise}`);

        if (response.data.check) {
          for (const offre of response.data.offres) {
            // Récupérer toutes les demandes liées à chaque offre
            const demandeResponse = await axios.get(`http://localhost:8000/api/getDemandeByOfferId/${offre.id}`);

            if (demandeResponse.data.check) {
              for (const demande of demandeResponse.data.demandes) {
                // Récupérer les détails de l'étudiant pour chaque demande
                const studentResponse = await axios.get(`http://localhost:8000/api/getStudentDetail/${demande.idEtudiant}`);
                const student = studentResponse.data.student;

                const myObject = {
                  idEtudiant: student.id,
                  fullname: student.fullname,
                  offerId: demande.idOffreDeStage,
                  typeStage: student.typeStage,
                  statut: demande.statut,
                  demandeId: demande.id,
                };

                this.demands.push(myObject);
              }
            } else {
              toast.error("Une erreur s'est produite lors de la récupération des demandes!", { autoClose: 2000 });
            }
          }
          this.filteredDemands = [...this.demands];
          this.storedDemands = [...this.filteredDemands];
        } else {
          toast.error("Une erreur s'est produite lors de la récupération des offres!", { autoClose: 2000 });
        }
        



      } catch (error) {
        console.error("Erreur:", error);
        toast.error("Une erreur s'est produite lors de la récupération des données!", { autoClose: 2000 });
      }
    },

    // Supprimer une demande par son ID
    async deleteDemande(id) {
      try {
        const response = await axios.delete(`http://localhost:8000/api/deleteDemande/${id}`);
        if (response.data.delete === true) {
          this.demands = this.demands.filter(demande => demande.demandeId !== id);
          toast.success("La demande a été supprimée avec succès!", { autoClose: 2000 });
        } else {
          toast.error("Échec de la suppression de la demande!", { autoClose: 2000 });
        }
      } catch (error) {
        console.error("Erreur", error);
        toast.error("Une erreur s'est produite lors de la suppression de la demande!", { autoClose: 2000 });
      }
    },

    // Confirmer la suppression avec une boîte de dialogue
    confirmDelete(id) {
      if (window.confirm('Êtes-vous sûr de vouloir supprimer cette demande ?')) {
        this.deleteDemande(id);
      }
    }
  },

  mounted() {
    this.getAllDemandes();
  }
};
</script>

<style>
  /* Styles spécifiques au composant si nécessaire */
</style>
