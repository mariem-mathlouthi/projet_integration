<template>
    
    <div class="flex flex-col full-height" :style="{
        background: 'linear-gradient(143.6deg, rgba(0, 123, 255, 0) 20.79%, rgba(0, 186, 255, 0.26) 40.92%, rgba(102, 204, 255, 0) 70.35%)',
    }">
    <header>
    <nav class="items-center pt-5 px-4 mx-auto max-w-screen-xl sm:px-8 sm:flex sm:space-x-6">
      <router-link to="/" data-aos="fade-left">
        <img src="../assets/logo.png" width="120" height="50" alt="Float UI logo" />
      </router-link>
      <ul class="py-4 flex-1 items-center flex space-x-3 sm:space-x-6 sm:justify-end" data-aos="fade-right">
        <li v-for="link in navigation" :key="link.id" class="text-gray-900">
          <a :href="link.router">
            {{ link.title }}
          </a>
        </li>
        <li>
          <router-link  to="/signin" class="flex items-center text-gray-900">
            Connexion
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
    
      <section class="py-36 flex-grow" data-aos="fade-up">
        <div class="max-w-screen-xl mx-auto px-4 md:px-8">
          <div class="max-w-3xl mx-auto text-center">
            <h3 class="text-indigo-600 font-semibold pb-6">l'Equipe</h3>
            <Carousel :itemsToShow="1" :wrapAround="true" :autoplayInterval="4000" ref="carousel">
              <Slide v-for="(testimonial, index) in testimonials" :key="index"  @slideChange="">
                <figure>
                  <blockquote>
                    <p class="text-gray-800 text-xl font-semibold sm:text-2xl">{{ testimonial.quote }}</p>
                  </blockquote>
                  <div class="mt-6">
                    <img :src="testimonial.avatar" class="w-16 h-16 mx-auto rounded-full" />
                    <div class="mt-3">
                      <span class="block text-gray-800 font-semibold">{{ testimonial.name }}</span>
                      <span class="block text-gray-600 text-sm mt-0.5">{{ testimonial.title }}</span>
                    </div>
                  </div>
                </figure>
              </Slide>
              <Navigation />
              <Pagination :totalSlides="testimonials.length"  />
            </Carousel>
          </div>
          
        </div>
      </section>
    </div>
  </template>
  
  <script>
  import { Carousel, Slide, Navigation, Pagination } from "vue3-carousel";
  import "vue3-carousel/dist/carousel.css";
  import cyrine from "../assets/cyrine.jpg"
  import souhail from "../assets/souhail.jpg"
  import mazen from "../assets/mazen.jpg"
  import mariem from "../assets/mariem.jpg"

    import "aos/dist/aos.css";
    import AOS from "aos";
  export default {
    data() {
      return {
        navigation: [
        { title: "Team", router: "/teams" },
        { title: "Contact", router: "/contact" },
      ],
        testimonials: [
          {
            avatar:cyrine,
            name: 'Laribi Cyrine ',
            title: 'Leader & Full stack developer',
            quote: 'Leading with expertise and grace, I orchestrate digital landscapes as a CO Full Stack Developer, crafting visionary solutions while championing innovation and collaboration .'
          },
          {
            avatar: 'https://i.postimg.cc/7Ykd8v4K/hatem.jpg',
            name: 'Atik Hatem',
            title: 'Full stack developer',
            quote: 'Im always in the mood for some coding and doing the best for my team . '
          },
          {
            avatar: souhail,
            name: 'Dridi Souhail',
            title: 'Full stack developer',
            quote: 'At the helm with precision and creativity, I navigate the digital realm as a seasoned CO Full Stack Developer, sculpting pioneering solutions while fostering a culture of innovation and teamwork .'
          },
          {
            avatar: mazen,
            name: 'Jebali mazen',
            title: 'Backend developer',
            quote: 'Eager to learn & apply my skills in a collaborative team environment projects .'
          },
          {
            avatar: mariem,
            name: 'Mathlouthi Mariem',
            title: 'Full stack developer',
            quote: 'Passionate Full Stack Developer always eager to tackle coding challenges and create innovative applications .'
          }
        ]
      };
    },
   
    components: {
      Carousel,
      Slide,
      Navigation,
      Pagination
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
    
  };
  </script>
  
  <style scoped>
  .full-height {
    height: 100vh; 
    min-height: 100%; 
  }
  
  html, body {
    height: 100%; 
    margin: 0; 
    padding: 0;
  }
  </style>
  