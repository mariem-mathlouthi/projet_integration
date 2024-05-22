<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <div class="font-[sans-serif] mt-12">
        <div class="-mt-28 mb-6 px-4">
          <div
            class="mx-auto max-w-6xl shadow-lg py-8 px-6 relative bg-white rounded"
          >
            <h2 class="text-xl text-[#333] font-bold">
              Product or Service Inquiry
            </h2>
            <form
              class="mt-8 grid sm:grid-cols-2 gap-6"
              @submit.prevent="addOffre"
            >
              <div>
                <label class="font-semibold text-sm">Offer titre</label>
                <input
                  type="text"
                  placeholder="Enter Name"
                  required
                  v-model="titre"
                  class="w-full rounded py-2.5 px-4 mt-2 border-2 text-sm outline-[#007bff]"
                />
              </div>

              <div>
                <label class="font-semibold text-sm">Company Email</label>
                <input
                  type="email"
                  placeholder="Email"
                  v-model="email"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                  disabled
                />
              </div>
              <div>
                <label class="font-semibold text-sm">Domain</label>
                <input
                  type="text"
                  placeholder="Phone No."
                  required
                  v-model="domaine"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                />
              </div>
              <div>
                <label class="font-semibold text-sm">Website</label>
                <input
                  type="text"
                  placeholder="Website"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                />
              </div>
              <div>
                <label class="font-semibold text-sm">DateDebut</label>
                <input
                  type="date"
                  placeholder="Company"
                  v-model="dateDebut"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                />
              </div>
              <div>
                <label class="font-semibold text-sm">DateFin</label>
                <input
                  type="date"
                  placeholder="Subject"
                  v-model="dateFin"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                />
              </div>
              <div>
                <label class="font-semibold text-sm">TypeOffre</label>
                <input
                  type="text"
                  placeholder="Subject"
                  v-model="typeOffre"
                  class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]"
                />
              </div>
              <div>
                <label class="font-semibold text-sm">Description</label>
                <textarea
                  v-model="description"
                  required
                  class="w-full rounded py-2.5 px-4 mt-2 border-2 text-sm outline-[#007bff]"
                ></textarea>
              </div>

              <div>
                <label class="font-semibold text-sm">Cahier de charge</label>
                <div
                  class="mt-1 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md"
                >
                  <div class="space-y-1 text-center">
                    <svg
                      class="mx-auto h-12 w-12 text-gray-400"
                      xmlns="http://www.w3.org/2000/svg"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke="currentColor"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4v4m0 0v4m0-4h4m-12 6h3l-4 4-4-4h3m1-9h6a2 2 0 012 2v14a2 2 0 01-2 2H5a2 2 0 01-2-2V6a2 2 0 012-2z"
                      />
                    </svg>
                    <div class="flex text-sm text-gray-600">
                      <label
                        for="file-upload"
                        class="relative cursor-pointer bg-white rounded-md font-medium text-[#007bff] hover:text-blue-600 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-[#007bff]"
                      >
                        <span>Upload a file</span>
                        <input
                          id="file-upload"
                          name="file-upload"
                          type="file"
                          class="sr-only"
                          accept=".pdf"
                          @change="handleFileUpload"
                        />
                      </label>
                      <p class="pl-1">or drag and drop</p>
                    </div>
                    <p class="text-xs text-gray-500">only PDF is Allowed.</p>
                  </div>
                </div>
              </div>
              <br /><br /><br />
              <div class="flex px-4 py-4 sm:px-6">
                <button
                  type="submit"
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
            </form>
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
import router from "../../router/index.js";
export default {
  data() {
    return {
      idEntreprise: "",
      status: "en_attente",
      titre: "",
      description: "",
      domaine: "",
      dateDebut: "",
      dateFin: "",
      typeOffre: "",
      cahierCharge: "test.pdf",
      email: "",
      entrepriseName: "",
      NotificationData: {
        date: new Date(),
        message: "",
        titre: "Nouveau offre !",
        type: "offre",
        visibility: "shown",
        entreprise: { id: null },
      },
    };
  },
  components: {
    Navbar,
    Sidebar,
  },
  methods: {
    handleFileUpload(event) {
      this.cahierCharge = event.target.files[0];
      console.log(this.cahierCharge);
    },
    addOffre() {
      // upload cahierCharge
      var FileData = new FormData();
      FileData.append("file", this.cahierCharge);

      axios
        .post("http://localhost:8087/file/upload", FileData)
        .then(function (response) {
          setTimeout(() => {
            toast.success("Cahier de Charge uploaded succesfully !", {
              autoClose: 2000,
            });
          });
        })
        .catch(function (error) {
          setTimeout(() => {
            toast.error("failed to upload file !" + error.message, {
              autoClose: 2000,
            });
          }, "500");
          console.log(error);
        });

      // add offre
      let storedData = localStorage.getItem("EntrepriseAccountInfo");
      this.idEntreprise = JSON.parse(storedData).id;

      let myjson = {
        entreprise: { id: this.idEntreprise },
        status: this.status,
        titre: this.titre,
        description: this.description,
        domaine: this.domaine,
        dateDebut: this.dateDebut,
        dateFin: this.dateFin,
        typeOffre: this.typeOffre,
        cahierCharge: this.cahierCharge.name,
      };
      console.log(myjson);

      // add notification
      this.NotificationData.message =
        "Nouveau offre est postulée par l'entreprise N°(" +
        this.idEntreprise +
        ")";
      this.NotificationData.entreprise.id = this.idEntreprise;

      axios
        .post(
          "http://localhost:8087/api/notification/add",
          this.NotificationData
        )
        .then(function (response) {
          console.log("offre notifiée");
        })
        .catch(function (error) {
          console.log("something went wrong!");
        });
      // upload offre data
      try {
        axios
          .post("http://localhost:8087/api/offres/add", myjson)
          .then(function (response) {
            setTimeout(() => {
              toast.success("Offre added succesfully !", {
                autoClose: 2000,
              });
            }, "500");
            router.push({ name: "OffersList" });
          });
      } catch (error) {
        toast.error("Something went wrong !", {
          autoClose: 2000,
        });
        console.log(error);
      }
    },
    getAccountData() {
      let storedData = localStorage.getItem("EntrepriseAccountInfo");
      this.email = JSON.parse(storedData).email;
      this.entrepriseName = JSON.parse(storedData).name;
    },
  },

  mounted() {
    this.getAccountData();
  },
};
</script>

<style>
.bg-gray-500 {
  margin-right: 250px;
}
</style>
