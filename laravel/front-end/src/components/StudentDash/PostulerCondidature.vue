@ -0,0 +1,88 @@
<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div class="bg-white rounded-lg shadow-md p-6">
          <h1 class="text-2xl font-semibold mb-4">
            Postuler à l'offre de stage
          </h1>
          <form @submit.prevent="submitApplication">
            <div class="mb-4">
              <label
                for="description"
                class="block text-sm font-medium text-gray-700"
                >description *</label
              >
              <textarea
                rows="4"
                id="description"
                v-model="reqData.description"
                placeholder="Entrez description"
                class="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500"
              ></textarea>
            </div>
            <label
              for="uploadFile"
              class="block text-sm font-medium text-gray-700"
              >Importer votre CV</label
            >
            <div class="mb-4">
              <label
                for="uploadFile"
                class="bg-white text-center rounded w-full sm:w-[360px] min-h-[160px] py-4 px-4 flex flex-col items-center justify-center cursor-pointer border-2 border-gray-300 mx-auto font-[sans-serif] m-4"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  class="w-8 mb-6 fill-gray-400"
                  viewBox="0 0 24 24"
                >
                  <path
                    d="M22 13a1 1 0 0 0-1 1v4.213A2.79 2.79 0 0 1 18.213 21H5.787A2.79 2.79 0 0 1 3 18.213V14a1 1 0 0 0-2 0v4.213A4.792 4.792 0 0 0 5.787 23h12.426A4.792 4.792 0 0 0 23 18.213V14a1 1 0 0 0-1-1Z"
                    data-original="#000000"
                  />
                  <path
                    d="M6.707 8.707 11 4.414V17a1 1 0 0 0 2 0V4.414l4.293 4.293a1 1 0 0 0 1.414-1.414l-6-6a1 1 0 0 0-1.414 0l-6 6a1 1 0 0 0 1.414 1.414Z"
                    data-original="#000000"
                  />
                </svg>
                <p class="text-gray-400 font-semibold text-sm">
                  Drag & Drop or
                  <span class="text-[#007bff]">Choose file</span> to upload
                </p>
                <input
                  type="file"
                  id="uploadFile"
                  class="hidden"
                  @change="assignCV"
                />
                <p class="text-xs text-gray-400 mt-2">
                  only PDF files are Allowed.
                </p>
              </label>
            </div>

            <div class="flex px-4 py-4 sm:px-6">
              <button
                type="button"
                class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
                @click="submitApplication(reqData)"
              >
                Save
              </button>
              <button
                type="button"
                class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
                @click="previousPage()"
              >
                Cancel
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "./NavBarStd.vue";
import Sidebar from "./Sidebar.vue";
import DemandeService from "../../service/demandeService/DemandeService";
import { toast } from "vue3-toastify";

export default {
  components: {
    Navbar,
    Sidebar,
  },
  data() {
    return {
      reqData: {
        description: "",
        idEtudiant: -1,
        idOffreDeStage: this.$route.params.idoffre,
        status: "en attend",
        DateSoumission: new Date().toLocaleDateString(),
        cv: null,
      },
    };
  },
  methods: {
    submitApplication(data) {
      console.log("uploading file...");
      DemandeService.addDemande(data)
        .then((response) => {
          toast.success("Offre sent !", {
            autoClose: 2000,
          });
        })
        .catch((error) => {
          toast.error("Error occured while sending offre !", {
            autoClose: 2000,
          });
        })
        .finally(() => {
          setTimeout(() => {
            this.previousPage();
          }, 3000);
        });
    },
    assignCV(e) {
      let files = e.target.files || e.dataTransfer.files;
      if (!files.length) return;
      this.reqData.cv = files[0];
    },
    previousPage() {
      this.$router.go(-1);
    },
  },
  created() {
    let storedData = localStorage.getItem("StudentAccountInfo"),
      email = JSON.parse(storedData).email;
    DemandeService.getIdEtudiant(email)
      .then((response) => {
        this.reqData.idEtudiant = response.data;
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>
