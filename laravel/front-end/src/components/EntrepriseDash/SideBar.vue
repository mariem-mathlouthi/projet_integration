<template>
    <aside
      id="logo-sidebar"
      class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-900 dark:border-gray-700"
      style="margin-top: 62px;"
      aria-label="Sidebar"
      :class="{
        'translate-x-0': isSidebarOpen,
      }"
    >
      <div class="h-full px-3 pb-4 overflow-y-auto dark:bg-gray-900"
        :style="{
          background: 'linear-gradient(143.6deg, rgba(192, 132, 252, 0) 20.79%, rgba(232, 121, 249, 0.26) 40.92%, rgba(204, 171, 238, 0) 70.35%)',
        }"
      >
        <!-- Navbar items -->
        <nav class="mb-4 mr-4">
  <ul>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 4v16a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V4m-2 0H5a2 2 0 0 0-2 2v10h16V6a2 2 0 0 0-2-2M9 15H5m0 0h4m-4 0a2 2 0 1 1 0-4h6a2 2 0 1 1 0 4m-6 0v-4m6 4v-4"></path>
        </svg>
        Dashboard
      </a>
    </li>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7"></path>
        </svg>
        Offers List
      </a>
    </li>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
</svg>

        Treated Stages
      </a>
    </li>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
        </svg>
        Student Requests List
      </a>
    </li>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
        </svg>
        Account
      </a>
    </li>
    <li class="mb-8">
      <a href="#" class="text-lg text-purple-600 flex items-center gap-2">
        <svg class="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
        </svg>
        Log Out
      </a>
    </li>
  </ul>
</nav>


      </div>
    </aside>
  </template>
  
  <script>
  export default {
    name: 'Sidebar',  
  }
  </script>
  