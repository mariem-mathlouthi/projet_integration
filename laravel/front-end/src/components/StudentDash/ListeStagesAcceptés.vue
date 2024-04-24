@ -1,76 +0,0 @@
<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div></div>
        <header class="text-center mb-8">
          <h1 class="text-3xl font-bold text-gray-800">
            Liste des Stages Acceptés
          </h1>
        </header>
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <!-- Boucle sur la liste des stages acceptés -->
          <div
            v-for="(stage, index) in acceptedStages"
            :key="index"
            class="bg-white shadow rounded-lg p-4"
          >
            <h3 class="text-lg font-semibold mb-2">{{ stage.titre }}</h3>
            <p class="text-gray-600 mb-4">{{ stage.description }}</p>
            <div class="flex items-center justify-between">
              <span class="text-gray-500">{{ stage.name }}</span>
              <button
                @click="selectStage(stage)"
                class="px-4 py-2 bg-orange-500 text-white rounded hover:bg-orange-600"
              >
                Affecter
              </button>
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
import StageService from "../../service/StageService/StageService";

export default {
  created() {
    this.getAllStages();
  },
  components: {
    Navbar,
    Sidebar,
  },
  data() {
    return {
      // Exemple de liste de stages acceptés
      acceptedStages: [
        // {
        //   title: "Stage en Développement Web",
        //   description: "Stage de développement web pour un site e-commerce.",
        //   company: "AwesomeTech Inc.",
        // },
        // {
        //   title: "Stage en Data Science",
        //   description:
        //     "Stage de data science pour analyser des données financières.",
        //   company: "DataAnalytics Corp.",
        // }
      ],
    };
  },
  methods: {
    selectStage(stage) {
      // Logique pour affecter le stage sélectionné
      console.log("Stage sélectionné :", stage);
      // Rediriger ou afficher un message selon les besoins
    },
    getAllStages() {
      StageService.getAllStages().then((res) => {
        this.acceptedStages = res.data;
      });
    },
  },
};
</script>

<style>
/* Styles CSS personnalisés peuvent être ajoutés ici */
</style>
