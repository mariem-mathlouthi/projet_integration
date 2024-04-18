<template>
    <Sidebar></Sidebar>
    <br><br><br>
    <div class="relative md:left-72  md:w-4/5 "
    
    >
    <div class="h-96" data-aos="fade-down">
      <br><br><br><br>
      <h2 class="text-4xl text-gray-800 text-center font-extrabold mx-auto md:text-5xl">
                welcome To <span class="text-transparent bg-clip-text bg-gradient-to-r from-[#4F46E5] to-[#E114E5]">Student Dashboard</span>
      </h2>
    
       
    </div>
    
       
    </div>
    

</template>
<script>
import "aos/dist/aos.css";
import AOS from "aos";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import Sidebar from "./Sidebar.vue"

export default {
  data: function () {
    return {
     fullname:"",
    }
  },
  components:{
    Sidebar,
  },
  
  methods:{
   
  },
  mounted(){
    toast.success("Hi you're Welcome ", {
              autoClose: 2000, 
    });/*
    toast.success("Hi"+this.fullname+" !", {
              autoClose: 2000, 
    });
    let storedData = localStorage.getItem("Etudiant");
    this.fullname = JSON.parse(storedData).fullname;*/
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