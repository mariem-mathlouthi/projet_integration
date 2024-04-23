<template>
   <nav class=" md:w-2/3 relative md:left-72" :style="{
        background: 'linear-gradient(143.6deg, rgba(192, 132, 252, 0) 20.79%, rgba(232, 121, 249, 0.26) 40.92%, rgba(204, 171, 238, 0) 70.35%)',
      }">
    <div class="items-center px-4 max-w-screen-xl mx-auto lg:flex lg:px-8">
      <div class="flex items-center justify-between py-3 py-4 block">
         
      <div class="flex items-center   rounded-lg">
            <a href="#">
               <svg xmlns="http://www.w3.org/2000/svg" class="w-6 h-6 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
               <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                  </svg>
            </a>
           
               <input
                  type="text"
                  placeholder="Search"
                  class="w-full md:w-96 px-2 py-2 text-gray-500 bg-transparent rounded-md outline-none"
                  
               />
      </div>
      <div class="">
         <ul class="md:hidden flex flex-col-reverse space-x-0 lg:space-x-6 lg:flex-row">
            <li class=" -mt-2">
              <a href="#">
               <span class="inline-block w-4 h-4 rounded-full bg-red-600 text-white text-xs flex items-center justify-center ml-4 mt-1">0</span>
               <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
               <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2M8 1.918l-.797.161A4 4 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4 4 0 0 0-3.203-3.92zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5 5 0 0 1 13 6c0 .88.32 4.2 1.22 6"/>
               </svg>
            </a>
            </li>
         </ul>
      </div>
      
      <div class="md:hidden flex items-center space-x-4">
         <button
            ref="profileRef"
            class="w-8 h-8 outline-none rounded-full ring-offset-2 ring-gray-200 ring-2 lg:focus:ring-indigo-600"
            @click="toggleState"
         >
            <img
            :src="imageUrl"
            alt="Profile"
            class="w-full h-full rounded-full"
            />
         </button>
         
     </div>



        <div class="lg:hidden">
          <button class="text-gray-700 outline-none p-2 rounded-md"
          data-drawer-target="logo-sidebar"
   data-drawer-toggle="logo-sidebar"
   aria-controls="logo-sidebar"
   @click="toggleSidebar" type="button" >
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" viewBox="0 0 20 20" fill="currentColor"
              :class="[open ? 'block' : 'hidden']">
              <path fillRule="evenodd"
                d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                clipRule="evenodd" />
            </svg>
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
              :class="[open ? 'hidden' : 'block']" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 8h16M4 16h16" />
            </svg>
          </button>
        </div>
      </div>
      <div class="flex-1 justify-between flex-row-reverse lg:overflow-visible lg:flex lg:pb-0 lg:pr-0 lg:h-auto" :class="[open ? 'h-screen pb-20 overflow-auto pr-4' : 'hidden']">
        <div>
          <ul class="flex flex-col-reverse space-x-0 lg:space-x-6 lg:flex-row">
            <li class=" -mt-1">
              <a href="#">
               <span class="inline-block w-4 h-4 rounded-full bg-red-600 text-white text-xs flex items-center justify-center ml-4 mt-1">0</span>
               <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
               <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2M8 1.918l-.797.161A4 4 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4 4 0 0 0-3.203-3.92zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5 5 0 0 1 13 6c0 .88.32 4.2 1.22 6"/>
               </svg>
            </a>
            </li>

            <div class="flex items-center space-x-4">
         <button
            ref="profileRef"
            class="w-10 h-10 outline-none rounded-full ring-offset-2 ring-gray-200 ring-2 lg:focus:ring-indigo-600"
            @click="toggleState"
         >
            <img
            :src="imageUrl"
            alt="Profile"
            class="w-full h-full rounded-full"
            />
         </button>
         
     </div>
           
            
          </ul>
        </div>
       
      </div>
    </div>
  </nav>
   

   <aside
   
     id="logo-sidebar"
     class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-900 dark:border-gray-700"
     aria-label="Sidebar"
     :class="{
       'translate-x-0': isSidebarOpen,
     }"
   >
   <router-link to="/">
      <span class="relative -top-14 left-10 self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Logo</span>
   </router-link>
   
     <div class="h-full px-3 pb-4 overflow-y-auto dark:bg-gray-900"
     :style="{
        background: 'linear-gradient(143.6deg, rgba(192, 132, 252, 0) 20.79%, rgba(232, 121, 249, 0.26) 40.92%, rgba(204, 171, 238, 0) 70.35%)',
      }">
      
       <ul class="space-y-4 font-medium">
         <li data-aos="fade-up">
           <router-link
             to="/StudentDash"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <svg
               class="w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
               aria-hidden="true"
               xmlns="http://www.w3.org/2000/svg"
               fill="currentColor"
               viewBox="0 0 22 21"
             >
               <path
                 d="M16.975 11H10V4.025a1 1 0 0 0-1.066-.998 8.5 8.5 0 1 0 9.039 9.039.999.999 0 0 0-1-1.066h.002Z"
               />
               <path
                 d="M12.5 0c-.157 0-.311.01-.565.027A1 1 0 0 0 11 1.02V10h8.975a1 1 0 0 0 1-.935c.013-.188.028-.374.028-.565A8.51 8.51 0 0 0 12.5 0Z"
               />
             </svg>
             <span class="ms-3">Dashboard</span>
           </router-link>
         </li>
 
         <li data-aos="fade-up">
           <a
             href="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
            
             <span class="flex-1 ms-3 whitespace-nowrap">Accepted Stages</span>
           </a>
         </li>
         <li data-aos="fade-up">
           <router-link
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <span class="flex-1 ms-3 whitespace-nowrap">Apply For Stages</span>
           </router-link>
         </li>
         <li data-aos="fade-up">
           <router-link
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <span class="flex-1 ms-3 whitespace-nowrap">Consult Stages</span>
           </router-link>
         </li>
         <li data-aos="fade-up">
           <router-link
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <span class="flex-1 ms-3 whitespace-nowrap">Filter Stages</span>
           </router-link>
         </li>
         <li>
           <router-link
            data-aos="fade-up"
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <span class="flex-1 ms-3 whitespace-nowrap">Offer Details</span>
           </router-link>
         </li>
         <li>
           <router-link
            data-aos="fade-up"
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <span class="flex-1 ms-3 whitespace-nowrap">Submit Cv</span>
           </router-link>
         </li>
 
         <li>
           <router-link
           data-aos="fade-up"
             to="/StudentAccount"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <svg
               xmlns="http://www.w3.org/2000/svg"
               width="16"
               height="16"
               fill="currentColor"
               class="bi bi-person-check-fill"
               viewBox="0 0 16 16"
             >
               <path
                 fill-rule="evenodd"
                 d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0"
               />
               <path
                 d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"
               />
             </svg>
             <span class="flex-1 ms-3 whitespace-nowrap">Account</span>
           </router-link>
         </li>
         <li data-aos="fade-up">
           <router-link
             to="#"
             class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
           >
             <svg
               xmlns="http://www.w3.org/2000/svg"
               width="16"
               height="16"
               fill="currentColor"
               class="bi bi-door-closed-fill"
               viewBox="0 0 16 16"
             >
               <path
                 d="M12 1a1 1 0 0 1 1 1v13h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V2a1 1 0 0 1 1-1zm-2 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2"
               />
             </svg>
             <span class="flex-1 ms-3 whitespace-nowrap">Log out</span>
            </router-link>
         </li>
         <li></li>
         
       </ul>
     </div>
   </aside>
 </template>
 <script>
 export default {
   data() {
     return {
       isSidebarOpen: false, // Track the sidebar visibility
       state: false, // Initial state for visibility of additional information
       imageUrl: 'https://i.postimg.cc/mDWkzGDv/istockphoto-1200064810-170667a.jpg'
     };
   },
   methods: {
     // Method to toggle the sidebar
     toggleSidebar() {
       this.isSidebarOpen = !this.isSidebarOpen;
     },
   },

   mounted() {
    
   
}


   

 };
 </script>

