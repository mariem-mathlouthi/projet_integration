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
          <form   @submit.prevent="signUp" class="space-y-5">
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
              <label class="font-medium">Classe</label>
              <input
              v-model="classe"
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
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
            <button
              class="w-full px-4 py-2 text-white font-medium bg-gray-800 hover:bg-gray-700 active:bg-gray-700 rounded-lg duration-150"
            >
              Create account
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
      fullname: "",
      classe: "",
      email: "",
      password: "",
      confirmPassword: "",
      image: "",
    };
  },
  methods: {

    async signUp() {
      
        if (this.password === this.confirmPassword) {
          const myjson = {
          name: this.fullname,
          email: this.email,
          password: this.password,  
          image:"test.jpg",
          classe: this.classe,
        };
        console.log(myjson);
        try {
          const response = await axios.post(
            "http://localhost:8000/api/signupStudent",
            myjson,
            
          );
          if (response.data.check === true) {
            toast.success("Account created succesfully !", {
              autoClose: 2000, 
            });
            //window.location.href = "/signin";
          } else {
            toast.error("Email already exists!", {
              autoClose: 2000, 
            });
          }
        } catch (error) {
          console.error("Error:", error);
        }}
        else{
          toast.error("Confirm your password!", {
              autoClose: 2000, 
            });
        }
      
    },
    
  },
  mounted() {
   
  },
};
</script>