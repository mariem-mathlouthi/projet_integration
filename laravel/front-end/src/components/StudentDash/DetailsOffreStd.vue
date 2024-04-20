<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div>
          <header class="text-center mb-8">
            <h1 class="text-3xl font-bold text-gray-800">Détails de l'offre</h1>
          </header>
          <div class="bg-purple-100 rounded-lg shadow-md p-6">
            <h2 class="text-xl font-semibold text-gray-800 mb-4">{{ offer.title }}</h2>
            <p class="text-gray-600 mb-4">{{ offer.description }}</p>
            <div class="flex items-center justify-between">
              <p class="text-gray-500">{{ offer.company }}</p>
              <button @click="apply" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Postuler</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import "aos/dist/aos.css";
  import AOS from "aos";
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import Sidebar from "./Sidebar.vue";
  import Navbar from "./NavBarStd.vue";
  
  export default {
    data() {
      return {
        offer: {
          title: "Développeur Full Stack",
          description: "Nous recherchons un développeur Full Stack pour rejoindre notre équipe dynamique et travailler sur des projets passionnants.",
          company: "AwesomeTech Inc.",
          // Autres détails de l'offre...
        }
      };
    },
    methods: {
      apply() {
        // Logique pour postuler à l'offre
        alert("Vous avez postulé à cette offre !");
      }
    },
    components: {
      Sidebar,
      Navbar
    }
  }
  </script>
  