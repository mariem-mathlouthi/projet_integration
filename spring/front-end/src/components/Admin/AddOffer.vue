
<template>
 <div id="app">
    <!-- SIDEBAR -->
    <SidebarMenu></SidebarMenu>

    <!-- CONTENT -->
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
    <div class="col-span-9 mt-24 mr-24">
  
   
        <div class="font-[sans-serif] mt-12">
           
            <div class="-mt-28 mb-6 px-4">
                <div class="mx-auto max-w-6xl shadow-lg py-8 px-6 relative bg-white rounded">
                    <h2 class="text-xl text-[#333] font-bold">Product or Service Inquiry</h2>
                    <form class="mt-8 grid sm:grid-cols-2 gap-6">
                        <div>
                            <label class="font-semibold text-sm">Offer titre</label>
                            <input type='text' placeholder='Enter Name'
                                class="w-full rounded py-2.5 px-4 mt-2 border-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">Company Email</label>
                            <input type='email' placeholder='Email'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">Domain</label>
                            <input type='email' placeholder='Phone No.'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">Website</label>
                            <input type='text' placeholder='Website'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">DateDebut</label>
                            <input type='date' placeholder='Company'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">DateFin</label>
                            <input type='date' placeholder='Subject'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
                            <label class="font-semibold text-sm">TpeOffre</label>
                            <input type='text' placeholder='Subject'
                                class="w-full rounded py-2.5 px-4 border-2 mt-2 text-sm outline-[#007bff]" />
                        </div>
                        <div>
    <label class="font-semibold text-sm">Cahier de charge</label>
    <div class="mt-1 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md">
        <div class="space-y-1 text-center">
            <svg class="mx-auto h-12 w-12 text-gray-400" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4v4m0 0v4m0-4h4m-12 6h3l-4 4-4-4h3m1-9h6a2 2 0 012 2v14a2 2 0 01-2 2H5a2 2 0 01-2-2V6a2 2 0 012-2z" />
            </svg>
            <div class="flex text-sm text-gray-600">
                <label for="file-upload" class="relative cursor-pointer bg-white rounded-md font-medium text-[#007bff] hover:text-blue-600 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-[#007bff]">
                    <span>Upload a file</span>
                    <input id="file-upload" name="file-upload" type="file" class="sr-only">
                </label>
                <p class="pl-1">or drag and drop</p>
            </div>
            <p class="text-xs text-gray-500">PNG, JPG, GIF up to 10MB</p>
        </div>
    </div>
</div>

<div class="flex px-4 py-4 sm:px-6">
    <button type="button"
        class="inline-flex items-center px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-orange-600 hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
        Save
    </button>
    <router-link to="/OffresList"> <button type="button"
        class="inline-flex items-center ml-4 px-6 py-2 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">     
Cancel
    </button></router-link>
</div>
                     

                        
                    </form>
                </div>
            </div>
        </div>

</div>
    </section>
  </div>
  </template>
  
  <script>
  import NavbarOne from './NavbarOne.vue';
  import SidebarMenu from './SidebarMenu.vue';
  export default {
    name: 'EntrepriseDashboard',
    components: {
      NavbarOne,
      SidebarMenu
    }
  }
  </script>
  
  <style>
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


