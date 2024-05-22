<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <header class="text-center mb-8">
          <h1 class="text-3xl font-bold text-gray-800" style="color: purple">
            Notifications
          </h1>
        </header>
        <div class="bg-purple-100 rounded-lg shadow-md p-6">
          <!-- Changement de la classe bg-purple-100 à bg-purple-50 -->
          <div
            v-if="notifications.length === 0"
            class="text-center text-gray-500"
          >
            Aucune notification pour le moment.
          </div>
          <div v-else>
            <div
              v-for="(notification, index) in notifications"
              :key="index"
              class="mb-4"
            >
              <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                <tr>
                  <td>
                    <h2 class="text-md font-semibold">
                      {{ notification.titre }}
                    </h2>
                  </td>
                  <td class="text-gray-600">
                    {{ notification.message }}
                  </td>
                  <td class="text-blue-500">
                    {{ notification.date }}
                  </td>
                  <td>
                    <router-link
                      v-if="notification.type == 'offre'"
                      to="/OffersListStd"
                      class="text-blue-600"
                      >consulter l'offre</router-link
                    >
                    <button v-if="notification.type == 'demande'">
                      Demande envoyée
                    </button>
                  </td>
                </tr>
              </table>
            </div>

            <div
              v-for="(notification, index) in notificationsOffre"
              :key="index"
              class="mb-4"
            >
              <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                <tr>
                  <td>
                    <h2 class="text-md font-semibold">
                      {{ notification.titre }}
                    </h2>
                  </td>
                  <td class="text-gray-600">
                    {{ notification.message }}
                  </td>
                  <td class="text-blue-500">
                    {{ notification.date }}
                  </td>
                  <td>
                    <router-link
                      v-if="notification.type == 'offre'"
                      to="/OffersListStd"
                      class="text-blue-600"
                      >consulter l'offre</router-link
                    >
                    <button v-if="notification.type == 'demande'">
                      Demande envoyée
                    </button>
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "./NavBarStd.vue";
import Sidebar from "./Sidebar.vue";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
export default {
  data() {
    return {
      notifications: [],
      notificationsOffre:[],
      idEtudiant: "",
    };
  },
  components: {
    Sidebar,
    Navbar,
  },
  methods: {
    async getAccountData() {
      let storedData = localStorage.getItem("StudentAccountInfo");
      this.idEtudiant = JSON.parse(storedData).id;
      this.getNotifications();
    },
    async getNotifications() {
      await axios
        .get("http://localhost:8087/api/notification/demandes/" + this.idEtudiant)
        .then((res) => {
          this.notifications = res.data;
          toast.success("Notifications loaded !", {
            autoClose: 2000,
          });
        })
        .catch(function (error) {
          console.log(error);
          toast.error("Something went wrong !", {
            autoClose: 2000,
          });
        });
        await axios
        .get("http://localhost:8087/api/notification/offre")
        .then((res) => {
          this.notificationsOffre = res.data;
        })
        .catch(function (error) {
          console.log(error);
        });
        console.log(this.notifications);
    },
  },
  mounted() {
    this.getAccountData();
  },
};
</script>

<style>
/* Ajoutez des styles CSS personnalisés au besoin */
</style>
