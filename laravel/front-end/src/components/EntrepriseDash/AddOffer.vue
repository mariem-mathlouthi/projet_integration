
<template>
    <Navbar/>
    <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
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

                        
                        <div class="flex items-center col-span-full">
                            <input id="checkbox1" type="checkbox"
                                class="w-4 h-4 mr-3" />
                            <label for="checkbox1" class="text-sm text-gray-400">I agree to the <a href="javascript:void(0);" class="underline">Terms and Conditions</a> and <a href="javascript:void(0);" class="underline">Privacy Policy</a></label>
                        </div>
                        <div class="flex justify-between">
                        <button type='button'
                                class="text-white bg-[#007bff] hover:bg-blue-600 font-semibold rounded text-sm px-6 py-3">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16px" height="16px" fill='#fff' class="mr-2 inline" viewBox="0 0 548.244 548.244">
                                <path fill-rule="evenodd" d="M392.19 156.054 211.268 281.667 22.032 218.58C8.823 214.168-.076 201.775 0 187.852c.077-13.923 9.078-26.24 22.338-30.498L506.15 1.549c11.5-3.697 24.123-.663 32.666 7.88 8.542 8.543 11.577 21.165 7.879 32.666L390.89 525.906c-4.258 13.26-16.575 22.261-30.498 22.338-13.923.076-26.316-8.823-30.728-22.032l-63.393-190.153z" clip-rule="evenodd" data-original="#000000" />
                            </svg>
                            Add offer
                        </button>
                        <router-link to="/OffersList">
                            <button type='button'
                                    class="text-white bg-gray-500 hover:bg-gray-600 font-semibold rounded text-sm px-6 py-3 ml-2">
                                Back
                          </button>
</router-link>

                    </div>

                        
                    </form>
                </div>
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
.bg-gray-500{
    margin-right: 250px;
}
  </style>
  


