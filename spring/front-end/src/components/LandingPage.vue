<template>
  <header>
    
      <nav class="items-center pt-5 px-4 mx-auto max-w-screen-xl sm:px-8 sm:flex sm:space-x-6">
        <a href="javascript:void(0)" data-aos="fade-left">
          <img src="../assets/logo.png" width="120" height="50" alt="Float UI logo" />
        </a>
        <ul class="py-4 flex-1 items-center flex space-x-3 sm:space-x-6 sm:justify-end" data-aos="fade-right">
          <li v-for="link in navigation" :key="link.id" class="text-gray-900">
            <a :href="link.router">
              {{ link.title }}
            </a>
          </li>
          <li>
            <router-link  to="/signin" class="flex items-center text-gray-900">
              Log In
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 ml-2" viewBox="0 0 20 20" fill="currentColor">
                <path fillRule="evenodd"
                  d="M3 3a1 1 0 011 1v12a1 1 0 11-2 0V4a1 1 0 011-1zm7.707 3.293a1 1 0 010 1.414L9.414 9H17a1 1 0 110 2H9.414l1.293 1.293a1 1 0 01-1.414 1.414l-3-3a1 1 0 010-1.414l3-3a1 1 0 011.414 0z"
                  clipRule="evenodd" />
              </svg>
            </router-link>
          </li>
        </ul>
      </nav>
    </header>
    <section  data-aos="fade-up">
      <div class="max-w-screen-xl mx-auto px-4 py-28 gap-12 text-gray-600 md:px-8">
          <div class="space-y-5 max-w-4xl mx-auto text-center">
              <h2 class="text-4xl text-gray-800 font-extrabold mx-auto md:text-5xl">
                welcome aboard! <span class="text-transparent bg-clip-text bg-gradient-to-r from-[#4F46E5] to-[#E114E5]">! Let's embark on this exciting journey together</span>
              </h2>
              <p class="max-w-2xl mx-auto">
                  Sed ut perspiciatis unde omnis iste natus voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae.
              </p>
              <div class="items-center justify-center gap-x-3 space-y-3 sm:flex sm:space-y-0">
                  <router-link to="/signupEntreprise" class="flex items-center justify-center gap-x-2 py-2 px-4 text-white font-medium text-sm bg-gray-800 duration-150 hover:bg-gray-700 active:bg-gray-900 rounded-lg md:inline-flex">
                      Entreprise
                    </router-link>
                  <router-link to="/signupEtudiant" class="block py-2 px-4 text-gray-700 hover:text-gray-500 font-medium duration-150 text-sm active:bg-gray-100 border rounded-lg">
                      Etudiant
                  </router-link>
              </div>
          </div>
         
      </div>
    </section>
  </template>
<script>
import "aos/dist/aos.css";
import AOS from "aos";

export default {
  data: function () {
    return {
      navigation: [
        { title: "Teams", router: "#" },
        { title: "Contact", router: "/contact" },
      ]
    }
  },
  methods:{
   
  },
  mounted(){


  },
  created() {
      this.$nextTick(() => {
        AOS.init({
          duration: 2500,
          easing: "ease-in-out",
          once: true,
          mirror: false,
        });
      });
    },
}
</script>