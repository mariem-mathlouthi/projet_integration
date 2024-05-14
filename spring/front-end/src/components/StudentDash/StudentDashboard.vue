<template>
  <Navbar />
  <div class="grid grid-cols-12 gap-4">
    <div class="col-span-3">
      <Sidebar />
    </div>
    <div class="col-span-9 mt-24 mr-24">
      <div class="bg-gray-100 px-6 py-12 font-[sans-serif]">
        <div class="container mx-auto p-6 bg-white rounded-lg shadow-md">
          <div class="grid grid-cols-1 md:grid-cols-2 gap-10">
            <div>
              <img
                src="https://readymadeui.com/management-img.webp"
                alt="Image"
                class="rounded-md object-cover w-full h-full"
              />
            </div>
            <div>
              <h2 class="text-3xl font-extrabold text-purple-700 mb-4">
                Immerse Yourself in Creativity
              </h2>
              <p class="text-gray-700 text-sm leading-6">
                Unleash your imagination and explore a world of endless
                possibilities. Lorem ipsum dolor sit amet, consectetur
                adipiscing elit. Sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua.
              </p>
              <ul class="list-disc text-sm text-gray-700 space-y-2 pl-4 mt-6">
                <li>Discover innovative ideas.</li>
                <li>Create unique projects.</li>
                <li>Collaborate with like-minded individuals.</li>
                <li>Transform your visions into reality.</li>
              </ul>
              <div class="mt-6">
                <a
                  href="javascript:void(0);"
                  class="text-purple-600 text-sm font-semibold hover:underline"
                  >Get Started</a
                >
              </div>
            </div>
          </div>
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
      fullname: "",
    };
  },
  components: {
    Sidebar,
    Navbar,
  },

  methods: {},
  mounted() {
    toast.success("Hi you're Welcome ", {
      autoClose: 2000,
    }); /*
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
};
</script>
