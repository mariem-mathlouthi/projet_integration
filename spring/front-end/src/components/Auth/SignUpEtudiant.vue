c:\Users\cyrin\Downloads\std.jpg<template>
    <main class="w-full flex">
      <div class="flex-1 hidden lg:block">
      <img src="./std.jpg" class="w-full h-screen object-cover" />
    </div>
      <div class="flex-1 flex items-center justify-center h-screen">
        <div
          class="w-full max-w-md space-y-8 px-4 bg-white text-gray-600 sm:px-0"
        >
          <div class="">
            
            <div class="mt-5 space-y-2">
              <h3 class="text-gray-800 text-2xl font-bold sm:text-3xl">
                Sign up
              </h3>
              <p class="">
                Already have an account?
                <router-link
                  to="/signin"
                  class="font-medium text-indigo-600 hover:text-indigo-500"
                  >Log in </router-link>
                
              </p>
            </div>
          </div>
          <div class="grid grid-cols-2 gap-x-3">
            <button
              class="flex items-center justify-center py-2.5 border rounded-lg hover:bg-gray-50 duration-150 active:bg-gray-100"
            >
              <!-- Comment: Google Icon SVG here -->
              <img
                src="https://raw.githubusercontent.com/sidiDev/remote-assets/7cd06bf1d8859c578c2efbfda2c68bd6bedc66d8/google-icon.svg"
                alt="Google"
                class="w-5 h-5"
              />
            </button>
            
            <button
              class="flex items-center justify-center py-2.5 border rounded-lg hover:bg-gray-50 duration-150 active:bg-gray-100"
            >
              <!-- Comment: GitHub Icon SVG here -->
              <img
                src="https://raw.githubusercontent.com/sidiDev/remote-assets/0d3b55a09c6bb8155ca19f43283dc6d88ff88bf5/github-icon.svg"
                alt="Github"
                class="w-5 h-5"
              />
            </button>
          </div>
          <div class="relative">
            <span class="block w-full h-px bg-gray-300"></span>
            <p
              class="inline-block w-fit text-sm bg-white px-2 absolute -top-2 inset-x-0 mx-auto"
            >
              Or continue with
            </p>
          </div>
          <form   @submit.prevent="next" class="space-y-5">
            <div class="grid grid-cols-2 gap-x-3">
            <div>
              <label class="font-medium">Full Name</label>
              <input
                v-model="fullname"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Niveau</label>
              <input
              v-model="niveau"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
          </div>
          <div>
              <label class="font-medium">Cin</label>
              <input
               v-model="cin"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Email</label>
              <input
              v-model="email"
                type="email"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div class="grid grid-cols-2 gap-x-3">
            <div>
              <label class="font-medium">Password</label>
              <input
              v-model="password"
                type="password"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Confirm Password</label>
              <input
              v-model="confirmPassword"
                type="password"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            </div>
            <div class="max-w-lg mx-auto px-4 sm:px-0">
        <ul aria-label="Steps" class="flex items-center">
            <li v-for="(item, idx) in stepsCount" :key="idx" :aria-current="currentStep == idx + 1 ? 'step' : false" class="flex-1 last:flex-none flex items-center">
                <div :class="{'w-8 h-8 rounded-full border-2 flex-none flex items-center justify-center': true, 'bg-indigo-600 border-indigo-600': currentStep > idx + 1, 'border-indigo-600': currentStep == idx + 1}">
                    <span :class="{'w-2.5 h-2.5 rounded-full bg-indigo-600': true, 'hidden': currentStep != idx + 1}"></span>
                    <template v-if="currentStep > idx + 1">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5 text-white">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12.75l6 6 9-13.5" />
                        </svg>
                    </template>
                </div>
                <hr :class="{'w-full border': true, 'hidden': idx + 1 == stepsCount.length, 'border-indigo-600': currentStep > idx + 1}" />
            </li>
        </ul>
    </div>
            <button
              class="w-full px-4 py-2 text-white font-medium bg-gray-800 hover:bg-gray-700 active:bg-gray-700 rounded-lg duration-150"
            >
              Suivant
            </button>
            
          </form>
        </div>
      </div>
    </main>
  </template>

<script>
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import axios from "axios";
export default {
  data() {
    return {
      stepsCount: [1, 2],
      currentStep: 1,
      fullname: "",
      niveau: "",
      cin:"",
      email: "",
      password: "",
      confirmPassword: "",
    };
  },
  methods: {

    async next() {
      if(this.password==this.confirmPassword){
        let etudiant = {
        fullname:this.fullname,
        niveau:this.niveau,
        cin:this.cin,
        email:this.email,
        password:this.password,
      }
      console.log(etudiant);
      localStorage.setItem("Etudiant",JSON.stringify(etudiant));
      window.location.href = "/signupEtudiantPart2";
      }
      else{
        toast.error("Confirm your passwordd !", {
              autoClose: 2000, 
        });
      }
     
       
    },
    
  },

  mounted() {
  
  },
  watch:{
    confirmPassword(value) {
    if (value === this.password) {
      this.currentStep++;
    }
    if (value != this.password) {
      this.currentStep=1;
    }
  },
  }
  
};
</script>