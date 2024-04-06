<template>
    <main class="w-full flex">
      <div class="flex-1 hidden lg:block">
      <img src="https://images.unsplash.com/photo-1697135807547-5fa9fd22d9ec?auto=format&fit=crop&q=80&w=3387&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="w-full h-screen object-cover" />
    </div>
      <div class="flex-1 flex items-center justify-center h-screen">
        <div
          class="w-full max-w-md space-y-8 px-4 bg-white text-gray-600 sm:px-0"
        >
          <div class="">
            <img
              src="https://floatui.com/logo.svg"
              width="150"
              class="lg:hidden"
            />
            <div class="mt-5 space-y-2">
              <h3 class="text-gray-800 text-2xl font-bold sm:text-3xl">
                Sign up
              </h3>
              <p class="">
                Already have an account?
                <router-link
                  to="/signin"
                  class="font-medium text-indigo-600 hover:text-indigo-500"
                  >Log in </router-link>
                
              </p>
            </div>
          </div>
     
          <form  class="space-y-5">
            <div>
              <label class="font-medium">Email</label>
              <input
                type="email"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Password</label>
              <input
                type="password"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div class="grid grid-cols-2 gap-x-3">
            <div>
              <label class="font-medium">Entreprise name</label>
              <input
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            <div>
              <label class="font-medium">Secteur</label>
              <input
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
          </div>
            <div>
              <label class="font-medium">Description</label>
              <textarea
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              ></textarea>
            </div>
            <div>
              <label class="font-medium">Link</label>
              <input
                type="text"
                required
                class="w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg"
              />
            </div>
            
            <button
              class="w-full px-4 py-2 text-white font-medium bg-gray-800 hover:bg-gray-700 active:bg-gray-700 rounded-lg duration-150"
            >
              Create account
            </button>
          </form>
        </div>
      </div>
    </main>
  </template>