<template>
    <Navbar/>
   <div class="grid grid-cols-12 gap-4">
   <div class="col-span-3">
     <Sidebar />
   </div>
   <div class="col-span-9 mt-24 mr-24">
    <div
  class="bg-gray-50 text-center px-4 rounded w-80 flex flex-col items-center justify-center cursor-pointer border-2 border-gray-400 border-dashed mx-auto font-[sans-serif]">
  <div class="py-6">
    <svg xmlns="http://www.w3.org/2000/svg" class="w-10 mb-2 fill-gray-600 inline-block" viewBox="0 0 32 32">
      <path
        d="M23.75 11.044a7.99 7.99 0 0 0-15.5-.009A8 8 0 0 0 9 27h3a1 1 0 0 0 0-2H9a6 6 0 0 1-.035-12 1.038 1.038 0 0 0 1.1-.854 5.991 5.991 0 0 1 11.862 0A1.08 1.08 0 0 0 23 13a6 6 0 0 1 0 12h-3a1 1 0 0 0 0 2h3a8 8 0 0 0 .75-15.956z"
        data-original="#000000" />
      <path
        d="M20.293 19.707a1 1 0 0 0 1.414-1.414l-5-5a1 1 0 0 0-1.414 0l-5 5a1 1 0 0 0 1.414 1.414L15 16.414V29a1 1 0 0 0 2 0V16.414z"
        data-original="#000000" />
    </svg>
    <h4 class="text-base font-semibold text-gray-600">Drag and drop files here</h4>
  </div>

  <hr class="w-full border-gray-400 my-2" />
  
  <div class="py-6">
    <input type="file" id='uploadFile1' class="hidden" />
    <label for="uploadFile1"
      class="block px-6 py-2.5 rounded text-gray-600 text-sm tracking-wider font-semibold border-none outline-none bg-gray-200 hover:bg-gray-100">Browse
      Files</label>
    <p class="text-xs text-gray-400 mt-4">PNG, JPG SVG, WEBP, and GIF are Allowed.</p>
  </div>
</div>
  
   </div>
   </div>

</template>
<script>
import "aos/dist/aos.css";
import AOS from "aos";
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import Sidebar from "./Sidebar.vue";
import Navbar from "./NavBarStd.vue";
export default {
 data: function () {
   return {
    fullname:"",
   }
 },
 components:{
   Sidebar,Navbar
 }
}
</script>