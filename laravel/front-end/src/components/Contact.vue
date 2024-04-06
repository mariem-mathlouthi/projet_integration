<template>
    <section class="py-14">
      <div class="max-w-screen-xl mx-auto px-4 text-gray-600 md:px-8">
        <div
          data-aos="fade-right"
          class="max-w-lg mx-auto gap-12 justify-between lg:flex lg:max-w-none"
        >
          <div class="max-w-lg space-y-3">
            <p
              class="text-gray-600 text-center text-3xl font-semibold sm:text-4xl"
            >
              Contact
              <span class="text-blue-700 text-3xl font-semibold sm:text-4xl"
                >US</span
              >
            </p>
            <br />
            <p>
              Nous sommes là pour vous aider et répondre à toute question que vous
              pourriez avoir. Nous sommes impatients de recevoir de vos nouvelles
              ! Veuillez remplir le formulaire ou utiliser les coordonnées
              ci-dessous pour nous contacter.
            </p>
            <div>
              <ul class="mt-6 flex flex-wrap gap-x-10 gap-y-6 items-center">
                <li class="flex items-center gap-x-3">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-envelope-at-fill"
                    viewBox="0 0 16 16"
                  >
                    <path
                      d="M2 2A2 2 0 0 0 .05 3.555L8 8.414l7.95-4.859A2 2 0 0 0 14 2zm-2 9.8V4.698l5.803 3.546zm6.761-2.97-6.57 4.026A2 2 0 0 0 2 14h6.256A4.5 4.5 0 0 1 8 12.5a4.49 4.49 0 0 1 1.606-3.446l-.367-.225L8 9.586zM16 9.671V4.697l-5.803 3.546.338.208A4.5 4.5 0 0 1 12.5 8c1.414 0 2.675.652 3.5 1.671"
                    />
                    <path
                      d="M15.834 12.244c0 1.168-.577 2.025-1.587 2.025-.503 0-1.002-.228-1.12-.648h-.043c-.118.416-.543.643-1.015.643-.77 0-1.259-.542-1.259-1.434v-.529c0-.844.481-1.4 1.26-1.4.585 0 .87.333.953.63h.03v-.568h.905v2.19c0 .272.18.42.411.42.315 0 .639-.415.639-1.39v-.118c0-1.277-.95-2.326-2.484-2.326h-.04c-1.582 0-2.64 1.067-2.64 2.724v.157c0 1.867 1.237 2.654 2.57 2.654h.045c.507 0 .935-.07 1.18-.18v.731c-.219.1-.643.175-1.237.175h-.044C10.438 16 9 14.82 9 12.646v-.214C9 10.36 10.421 9 12.485 9h.035c2.12 0 3.314 1.43 3.314 3.034zm-4.04.21v.227c0 .586.227.8.581.8.31 0 .564-.17.564-.743v-.367c0-.516-.275-.708-.572-.708-.346 0-.573.245-.573.791"
                    /></svg
                  >hatematig25@gmail.com
                </li>
                <li class="flex items-center gap-x-3">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-telephone-fill"
                    viewBox="0 0 16 16"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z"
                    />
                  </svg>
                  53688551
                </li>
              </ul>
              <ul class="mt-6 flex flex-wrap gap-x-10 gap-y-6 items-center">
                <li class="flex items-center gap-x-3">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-geo-alt-fill"
                    viewBox="0 0 16 16"
                  >
                    <path
                      d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6"
                    />
                  </svg>
                  Ariana , Soukra Dar Fadhal
                </li>
              </ul>
            </div>
            <div
              class="w-80 flex items-center justify-center"
              ref="lottieContainer"
            ></div>
          </div>
          <div data-aos="fade-right" class="flex-1 mt-12 sm:max-w-lg lg:max-w-md">
            <form class="space-y-5" @submit.prevent="submitForm">
              <div>
                <label class="font-medium"> Full name </label>
                <input
                  type="text"
                  v-model="fullname"
                  required
                  class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                />
              </div>
              <div>
                <label class="font-medium"> Email </label>
                <input
                  type="email"
                  v-model="email"
                  required
                  class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                />
              </div>
  
              <div>
                <label class="font-medium"> Message </label>
                <textarea
                  v-model="message"
                  required
                  class="w-full mt-2 h-36 px-3 py-2 resize-none appearance-none bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                ></textarea>
              </div>
              <button
                type="submit"
                class="bg-gradient-to-r from-indigo-600 to-indigo-7 shadow-lg bg-indigo-900 w-full px-4 py-2 text-white font-medium hover:bg-indigo-500 active:bg-indigo-600 rounded-lg duration-150"
              >
                Envoyer
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>
  </template>
  
  <script>
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import "aos/dist/aos.css";
  import AOS from "aos";
  import { Lottie } from "lottie-web";
  import animationData from "../assets/animation/contact.json";
  import axios from "axios";
  export default {
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
    data() {
      return {
        fullname: "",
        email: "",
        message: "",
      };
    },
    methods: {
      initializeLottie() {
        if (typeof Lottie === "undefined") {
          import("lottie-web")
            .then(({ default: lottie }) => {
              this.loadAnimations(lottie, [
                { data: animationData, container: this.$refs.lottieContainer },
              ]);
            })
            .catch((error) => {
              console.error("Error loading Lottie:", error);
            });
        } else {
          this.loadAnimations(Lottie, [
            { data: animationData, container: this.$refs.lottieContainer },
          ]);
        }
      },
      loadAnimations(lottieInstance, animations) {
        animations.forEach(({ data, container }) => {
          this.loadAnimationWithData(lottieInstance, data, container);
        });
      },
      loadAnimationWithData(lottieInstance, animationData, container) {
        if (!container || !lottieInstance || !animationData) return;
  
        lottieInstance.loadAnimation({
          container: container,
          renderer: "svg",
          loop: true,
          autoplay: true,
          animationData: animationData,
        });
      },
      async submitForm() {
        const { fullname, email, message } = this;
        try {
          const response = await axios.post(
            "https://server-rlwuyzc0s-hatem6.vercel.app/contact",
            {
              fullname,
              email,
              message,
            }
          );
          if (response.status === 200) {
            toast.success("Message sent successfully!", {
              autoClose: 3000, // Optionally set autoClose time
              onClose: () => {
                // Code to execute after toast auto-closes
                this.message = "";
              },
            });
          }
        } catch (error) {
          console.error("Error submitting form:", error);
        }
      },
    },
    mounted() {
      this.initializeLottie();
    },
  };
</script>