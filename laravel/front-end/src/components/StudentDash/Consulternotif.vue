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
                <p class="text-gray-600">{{ notification.message }}  <span class="text-blue-500">{{ notification.date }}</span> <router-link v-if="notification.type=='offre'" to="/OffersListStd" class="text-blue-600">consulter la</router-link> 
                  <button v-if="notification.type=='attestation'" class="text-orange-500 ml-2" @click="voirAttestation(notification.attestation)"> voir votre attestation</button>
                </p>
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
        idEtudiant:"",
        

      };
    },
    components: {
      Sidebar,
      Navbar
    },
    methods:{
      getAccountData(){
        let storedData = localStorage.getItem("StudentAccountInfo"); 
          this.idEtudiant = JSON.parse(storedData).id;
          this.fullname= JSON.parse(storedData).fullname;
          this.email= JSON.parse(storedData).email;
      },
      async getNotifications(){
        try {
            const response = await axios.get(
                "http://localhost:8000/api/getAllNotifications"
            );
            console.log(response.data.notifications);
            if (response.data.check === true) {
                for(let i=0;i<response.data.notifications.length;i++){
                 if(response.data.notifications[i].idEtudiant==this.idEtudiant){
                  if(response.data.notifications[i].type=="demande"){
                    let myObj={
                    title:"Notification de votre demande stage",
                    message:response.data.notifications[i].message,
                    date:response.data.notifications[i].date,
                    type:"demande"
                  }
                  this.notifications.push(myObj);
                  }
                 }
                 else{
                  if(response.data.notifications[i].type=="offre"){
                    let myObj={
                    title:"Nouvelle Offre de stage",
                    message:response.data.notifications[i].message,
                    date:response.data.notifications[i].date,
                    type:"offre"
                  }
                  console.log(myObj);
                  this.notifications.push(myObj);
                  console.log(this.notifications);

                  } 
                 }
                }
                
              } else {
                  toast.error("Something went wrong !", {
                      autoClose: 2000,
                  });
              }

              const response2 = await axios.get(
                `http://localhost:8000/api/getAttestation/${this.idEtudiant}`
              );
              if(response2.data.check==true) {
                for(let i=0;i<response2.data.attestation.length;i++){
                  let myObj={
                    title:"Notification d'attestation de  stage",
                    message:response2.data.attestation[i].message,
                    date:response2.data.attestation[i].date,
                    attestation:response2.data.attestation[i].attestation,
                    type:"attestation"
                  }
                  this.notifications.push(myObj);
                }
                
              }
              console.log(this.notifications);
                this.notifications.reverse();
                console.table(this.notifications);
                let myJson ={
                  notifications:this.notifications,
                }
                localStorage.setItem("notifications",JSON.stringify(myJson));

              } catch (error) {
                  console.error("Error:", error);
              }
              
      },
      voirAttestation(filename) {
       console.log(filename);
      // Construct the full URL of the file
      const fileURL = `http://localhost:8000${filename}`;

      // Open the file URL in a new tab to initiate the download
      window.open(fileURL, '_blank');
},
    },
    mounted(){
      this.getNotifications();
      this.getAccountData();
      
    }
  }
  </script>
  
  <style>
  /* Ajoutez des styles CSS personnalisés au besoin */
  </style>