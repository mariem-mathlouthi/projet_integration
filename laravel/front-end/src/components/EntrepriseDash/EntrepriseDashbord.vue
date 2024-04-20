<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <div class="font-sans text-[#333] max-w-6xl max-md:max-w-md mx-auto">
      <div class="grid md:grid-cols-2 items-center md:gap-8 gap-6">
        <div class="max-md:order-1 max-md:text-center">
          <p class="mt-4 text-sm font-bold text-blue-600"><span class="rotate-90 inline-block mr-2 mb-2">|</span> ENTREPRISE </p>
          <h2 class="md:text-5xl text-3xl font-extrabold mb-4 md:!leading-[55px]">Hello and welcome to your dashboard</h2>
          <p class="mt-4 text-base text-gray-500 leading-relaxed">We're delighted to have you here. How can we assist you today?</p>
        
          <div class="flex items-center mt-10">
            <input id="checkbox3" type="checkbox" class="hidden peer" checked />
            <label for="checkbox3"
              class="relative flex items-center justify-center p-1 peer-checked:before:hidden before:block before:absolute before:w-full before:h-full before:bg-white w-5 h-5 cursor-pointer bg-blue-500 border rounded-full overflow-hidden">
              <svg xmlns="http://www.w3.org/2000/svg" class="w-full fill-white" viewBox="0 0 520 520">
                <path
                  d="M79.423 240.755a47.529 47.529 0 0 0-36.737 77.522l120.73 147.894a43.136 43.136 0 0 0 36.066 16.009c14.654-.787 27.884-8.626 36.319-21.515L486.588 56.773a6.13 6.13 0 0 1 .128-.2c2.353-3.613 1.59-10.773-3.267-15.271a13.321 13.321 0 0 0-19.362 1.343q-.135.166-.278.327L210.887 328.736a10.961 10.961 0 0 1-15.585.843l-83.94-76.386a47.319 47.319 0 0 0-31.939-12.438z"
                  data-name="7-Check" data-original="#000000" />
              </svg>
            </label>
           
          </div>
        </div>
        <div class="md:h-[450px] p-2">
          <img src="https://readymadeui.com/image-1.webp" class="w-full h-full object-contain shadow-[0_2px_22px_-10px_rgba(93,96,127,0.2)]" alt="Dining Experience" />
        </div>
      </div>
      <div class="mt-12 grid grid-cols-2 md:grid-cols-4 gap-4 items-center">
        <img src="https://readymadeui.com/google-logo.svg" class="w-28 mx-auto" alt="google-logo" />
        <img src="https://readymadeui.com/facebook-logo.svg" class="w-28 mx-auto" alt="facebook-logo" />
        <img src="https://readymadeui.com/linkedin-logo.svg" class="w-28 mx-auto" alt="linkedin-logo" />
        <img src="https://readymadeui.com/pinterest-logo.svg" class="w-28 mx-auto" alt="pinterest-logo" />
      </div>
    </div>
</div>






  </div>
  </template>
  
  <script>
  import Navbar from './Navbar.vue';
  import Sidebar from './SideBar.vue';
  export default {
    name: 'EntrepriseDashboard',
    components: {
      Navbar,
      Sidebar
    }
  }
  </script>
  
  <style>
  /* Styles spécifiques à votre tableau de bord d'entreprise */
  </style>
  