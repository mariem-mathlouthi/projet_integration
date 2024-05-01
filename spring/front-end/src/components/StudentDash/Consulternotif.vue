<template>
    <div>
      <Navbar/>
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-3">
          <Sidebar />
        </div>
        <div class="col-span-9 mt-24 mr-24">
          <header class="text-center mb-8">
            <h1 class="text-3xl font-bold text-gray-800" style="color:purple">Notifications</h1>
          </header>
          <div class="bg-purple-100 rounded-lg shadow-md p-6"> <!-- Changement de la classe bg-purple-100 à bg-purple-50 -->
            <div v-if="notifications.length === 0" class="text-center text-gray-500">Aucune notification pour le moment.</div>
            <div v-else>
              <div v-for="(notification, index) in notifications" :key="index" class="mb-4">
                <h2 class="text-lg font-semibold">{{ notification.title }} </h2>
                <p class="text-gray-600">{{ notification.message }}  <span class="text-blue-500">{{ notification.date }}</span> <router-link to="/OffersListStd" class="text-blue-600">consulter la</router-link></p>
                <hr class="my-2 border-gray-200">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
 
  import Navbar from './NavBarStd.vue'
  import Sidebar from './Sidebar.vue'
  import { toast } from "vue3-toastify";
  import "vue3-toastify/dist/index.css";
  import axios from "axios";
  export default {
    data() {
      return {
        notifications: [],

      };
    },
    components: {
      Sidebar,
      Navbar
    },
    methods:{
      async getNotifications(){
        try {
            const response = await axios.get(
                "http://localhost:8000/api/getAllNotifications"
            );
            if (response.data.check === true) {
                for(let i=0;i<response.data.notifications.length;i++){
                  if(response.data.notifications[i].type=="offre"){
                    let myObj={
                    title:"Nouvelle Offre de stage",
                    message:response.data.notifications[i].message,
                    date:response.data.notifications[i].date,
                  }
                  this.notifications.push(myObj);

                  }
                }
                console.log(this.notifications);
                let myJson ={
                  notifications:this.notifications,
                }
                localStorage.setItem("notifications",JSON.stringify(myJson));
              } else {
                  toast.error("Something went wrong !", {
                      autoClose: 2000,
                  });
              }
              } catch (error) {
                  console.error("Error:", error);
              }
      },
    },
    mounted(){
      this.getNotifications();
      
    }
  }
  </script>
  
  <style>
  /* Ajoutez des styles CSS personnalisés au besoin */
  </style>