<template>
    <main class="w-full h-screen flex flex-col items-center justify-center px-4">
        <div class="max-w-sm w-full text-gray-600">
            <div class="text-center">
                
                <div class="mt-5 space-y-2">
                    <h3 class="text-gray-800 text-2xl font-bold sm:text-3xl">Log in to your account</h3>
                    <p class="">
                Dont't you have an account?
                <router-link
                  to="/"
                  class="font-medium text-indigo-600 hover:text-indigo-500"
                  >Sign up </router-link>
                
              </p>
                    
                </div>
            </div>
            <form
            @submit.prevent="Signin"
                class="mt-8 space-y-5"
            >
                <div>
                    <label class="font-medium">
                        Email
                    </label>
                    <input
                        type="email"
                        v-model="email"
                        required
                        class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                    />
                </div>
                <div>
                    <label class="font-medium">
                        Password
                    </label>
                    <input
                        type="password"
                        v-model="password"
                        required
                        class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
                    />
                </div>
                <button
                    class="w-full px-4 py-2 text-white font-medium bg-gray-800 hover:bg-gray-700 active:bg-gray-700 rounded-lg duration-150"
                >
                    Sign in
                </button>
                <div class="text-center">
                    <a href="javascript:void(0)" class="hover:text-indigo-600">Forgot password?</a>
                </div>
            </form>
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
      email: "",
      password: "",
    };
  },
  methods: {

    async Signin() {
    let myjson = {
        email:this.email,
        password:this.password,
      }
      console.log(myjson);
        try {
          const response = await axios.post(
            "http://localhost:8000/api/login",
            myjson,
            
          );
          if (response.data.check === true) {

            if(response.data.role === "entreprise"){
              let EntrepriseAccount = {
                id:response.data.user.id,
                numeroSIRET:response.data.user.numeroSIRET,
                email:response.data.user.email,
                name:response.data.user.name,
                secteur:response.data.user.secteur,
                description:response.data.user.description,
              }
            localStorage.setItem("EntrepriseAccountInfo",JSON.stringify(EntrepriseAccount));
            this.$router.push('/EntrepriseDash'); // Redirection vers le tableau de bord de l'entreprise
             
            }
            else if(response.data.role === "student"){
              let StudentAccount = {
                id:response.data.user.id,
                fullname:response.data.user.fullname,
                email:response.data.user.email,
                niveau:response.data.user.niveau,
                domaine:response.data.user.domaine,
                specialite:response.data.user.specialite,
                typeStage:response.data.user.typeStage,
                etablissement:response.data.user.etablissement,
                
              }
            localStorage.setItem("StudentAccountInfo",JSON.stringify(StudentAccount));
            this.$router.push('/StudentDash');
            }
           else if(response.data.role === "admin"){
              this.$router.push('/Admin');
              toast.success("Admin Account Exist !", {
              autoClose: 2000, 
            });

            }
        
          } else {
            toast.error("Invalid email or password !", {
              autoClose: 2000, 
            });
          }
        } catch (error) {
          console.error("Error:", error);
        }
        
    

    }
    
  },
  mounted() {
   
  },
};
</script>