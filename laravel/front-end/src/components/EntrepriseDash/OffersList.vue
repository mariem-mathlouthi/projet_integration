<template>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <Navbar/>
    <div  class="grid grid-cols-12">
        <div class="col-span-3">
            <Sidebar />
        </div>

        
        <div class="col-span-9 mt-24  mr-12">
            <h2 class="text-2xl font-bold mb-8 mt-8">Offers List</h2>
            <div class="overflow-x-auto">
                <div class="flex justify-end mb-4">
                <router-link to="/AddOffer">
                    <button type="button"
                            class="px-6 py-2 rounded-full text-black text-sm tracking-wider font-medium outline-none border-2 border-purple-600 hover:bg-purple-600 hover:text-white transition-all duration-300 flex items-center gap-2">
                        <i class="fas fa-plus"></i> <!-- Add icon -->
                        <span>Add new Offer</span>
                    </button>
                </router-link>

                </div>
                <div class="overflow-x-auto">
  <table class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
    <thead class="bg-gray-100 whitespace-nowrap">
      <tr>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
        id
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            idEntreprise
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          status
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            titre
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            description
        </th>
        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
          Actions
        </th>
      </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200 whitespace-nowrap">
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          John Doe
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          john@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          Admin
        </td>
       
      
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-05-15
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
         <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
      </tr>
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          Jane Smith
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          jane@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          User
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-20
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
      </tr>
      <tr>
        <td class="px-6 py-4 text-sm text-[#333]">
          Alen doe
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          alen@example.com
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          User
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
          2022-07-21
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            Développement Web
        </td>
        <td class="px-6 py-4 text-sm text-[#333]">
            <button class="text-green-500 hover:text-green-700 mr-4">
            <router-link to="/detailoffre">Details</router-link>
            </button>
          <!--<button class="text-blue-500 hover:text-blue-700 mr-4">Edit</button>
          <button class="text-red-500 hover:text-red-700">Delete</button>--> 
        </td>
      </tr>
    </tbody>
  </table>
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

</style>
