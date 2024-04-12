<template>
    <main class="w-full flex">
      <div class="flex-1 hidden lg:block">
      <img src="https://images.unsplash.com/photo-1697135807547-5fa9fd22d9ec?auto=format&fit=crop&q=80&w=3387&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="w-full h-screen object-cover" />
    </div>
      <div class="flex-1 flex items-center justify-center h-screen">
        <div
          class="w-full max-w-md space-y-8 px-4 bg-white text-gray-600 sm:px-0"
        >
          <div class="">
            <img
              src="https://floatui.com/logo.svg"
              width="150"
              class="lg:hidden"
            />
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
     
          <form  @submit.prevent="next" class="space-y-5">
            <div>
              <label class="font-medium">numeroSIRET</label>
              <input
                type="text"
                v-model="numeroSIRET"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Email</label>
              <input
                type="email"
                v-model="email"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Password</label>
              <input
                type="password"
                v-model="password"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Confirm Password</label>
              <input
                type="password"
                v-model="confirmPassword"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
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
      numeroSIRET:"",
      email: "",
      password: "",
      confirmPassword:"",
    };
  },
  methods: {

    async next() {
      if(this.password==this.confirmPassword){
        let entreprise = {
        numeroSIRET:this.numeroSIRET,
        email:this.email,
        password:this.password,
      }
      console.log(entreprise);
      localStorage.setItem("Entreprise",JSON.stringify(entreprise));
      window.location.href = "/signupEntreprisePart2";
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