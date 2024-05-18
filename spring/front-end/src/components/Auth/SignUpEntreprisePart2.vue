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
         
         
          <form   @submit.prevent="signUp" class="space-y-5">
            <div class="grid grid-cols-2 gap-x-3">
            <div>
              <label class="font-medium">Entreprise name</label>
              <input
               v-model="name"
                type="texts"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            
            <div>
              <label class="font-medium">Secteur</label>
              <input
             v-model="secteur"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
           
           
            </div>
            <div>
              <label class="font-medium">link</label>
              <input
             v-model="link"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">description</label>
              <textarea
                  v-model="description"
                  required
                  class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                ></textarea>
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
              Creer mon Compte
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
      currentStep: 2,
      numeroSIRET:"",
      email: "",
      password: "",
      etablissement:"",
      name: "",
      secteur: "",
      logo: "test.jpg",
      description: "",
      link: "",
     
    };
  },
  methods: {

    async signUp() {

      let storedData = localStorage.getItem("Entreprise");
      this.numeroSIRET = JSON.parse(storedData).numeroSIRET;
      this.email = JSON.parse(storedData).email;
      this.password = JSON.parse(storedData).password;  


    let myjson = {
      numeroSIRET:this.numeroSIRET,
      email:this.email,
      password:this.password,
      name:this.name,
      secteur:this.secteur,
      logo:this.logo,
      description:this.description,
      link:this.link,
    }
    console.log(myjson);
      try {
        const response = await axios.post(
          "http://localhost:8087/api/entreprise/Add",
          myjson,
          
        ).then((res)=>{
            console.log(res.data);
            this.$router.push({name:"signin"});
          })
         /* if (response.data.check === true) {
            toast.success("Account created succesfully !", {
              autoClose: 2000, 
            });

          } else {
            toast.error("Email or cin already exists!", {
              autoClose: 2000, 
            });
          }*/
        } catch (error) {
          console.error("Error:", error);
        }
        
    
    },

  },
  mounted() {
  
  },
  watch:{
    description(value) {
    if (value != "") {
      this.currentStep++;
    }
    if(value==""){
      this.currentStep=2;
    }
  },
  }
  
};
</script>