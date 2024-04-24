@ -1,51 +0,0 @@
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
              <h2 class="text-lg font-semibold">{{ notification.title }}</h2>
              <p class="text-gray-600">{{ notification.message }}</p>
              <hr class="my-2 border-gray-200" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from "./Sidebar.vue";
import Navbar from "./NavBarStd.vue";

export default {
  data() {
    return {
      notifications: [
        {
          title: "Nouvelle offre de stage",
          message:
            "Une nouvelle offre de stage est disponible. Consultez-la dès maintenant !",
        },
        {
          title: "Rappel: Date limite de candidature",
          message:
            "La date limite de candidature pour le stage X est le 30 avril. Assurez-vous de soumettre votre candidature à temps !",
        },
        // Ajoutez d'autres notifications au besoin
      ],
    };
  },
  components: {
    Sidebar,
    Navbar,
  },
};
</script>

<style>
/* Ajoutez des styles CSS personnalisés au besoin */
</style>
