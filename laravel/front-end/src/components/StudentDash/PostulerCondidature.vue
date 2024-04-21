<template>
  <div>
    <Navbar />
    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div class="bg-white rounded-lg shadow-md p-6">
          <h1 class="text-2xl font-semibold mb-4">Postuler à l'offre de stage</h1>
          <form @submit.prevent="submitApplication">
            <div class="mb-4">
              <label for="fullname" class="block text-sm font-medium text-gray-700">Nom complet</label>
              <input type="text" id="fullname" v-model="fullname" placeholder="Entrez votre nom complet"
                class="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div class="mb-4">
              <label for="email" class="block text-sm font-medium text-gray-700">Adresse e-mail</label>
              <input type="email" id="email" v-model="email" placeholder="Entrez votre adresse e-mail"
                class="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500">
            </div>
            <label for="fullname" class="block text-sm font-medium text-gray-700">Importer votre CV</label>
            <div class="mb-4">
              <label for="uploadFile1"
              class="bg-white text-center rounded w-full sm:w-[360px] min-h-[160px] py-4 px-4 flex flex-col items-center justify-center cursor-pointer border-2 border-gray-300 mx-auto font-[sans-serif] m-4">
              <svg xmlns="http://www.w3.org/2000/svg" class="w-8 mb-6 fill-gray-400" viewBox="0 0 24 24">
                <path
                  d="M22 13a1 1 0 0 0-1 1v4.213A2.79 2.79 0 0 1 18.213 21H5.787A2.79 2.79 0 0 1 3 18.213V14a1 1 0 0 0-2 0v4.213A4.792 4.792 0 0 0 5.787 23h12.426A4.792 4.792 0 0 0 23 18.213V14a1 1 0 0 0-1-1Z"
                  data-original="#000000" />
                <path
                  d="M6.707 8.707 11 4.414V17a1 1 0 0 0 2 0V4.414l4.293 4.293a1 1 0 0 0 1.414-1.414l-6-6a1 1 0 0 0-1.414 0l-6 6a1 1 0 0 0 1.414 1.414Z"
                  data-original="#000000" />
              </svg>
              <p class="text-gray-400 font-semibold text-sm">Drag & Drop or <span class="text-[#007bff]">Choose file</span> to
                upload</p>
              <input type="file" id='uploadFile1' class="hidden" />
              <p class="text-xs text-gray-400 mt-2">PNG, JPG SVG, WEBP, and GIF are Allowed.</p>
            </label>
            </div>
            
            <div class="flex px-4 py-4 sm:px-6">

                  <button type="button"
                      class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
                      Save
                  </button>
                  <router-link to="/DetailsOffreStd"> <button type="button"
                      class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">     
              Cancel
                  </button></router-link>
              </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from './NavBarStd.vue';
import Sidebar from './Sidebar.vue';

export default {
  components: {
    Navbar,
    Sidebar
  },
  data() {
    return {
      fullname: '',
      email: '',
      cv: null
    };
  },
  methods: {
    handleFileUpload(event) {
      this.cv = event.target.files[0];
    },
    submitApplication() {
      // Logique pour soumettre la candidature
      console.log('Nom complet:', this.fullname);
      console.log('E-mail:', this.email);
      console.log('CV:', this.cv);
      // Ici, vous pouvez ajouter la logique pour envoyer les données au backend
    }
  }
};
</script>
