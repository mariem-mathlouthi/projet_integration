<template>
  <div>
    <NavBarStd class="w-full fixed z-50"></NavBarStd>

    <div class="grid grid-cols-12 gap-4">
      <div class="col-span-3">
        <Sidebar />
      </div>
      <div class="col-span-9 mt-24 mr-24">
        <div
          class="relative md:left-10 md:w-3/4 my-4 border px-4 shadow-xl sm:mx-4 sm:rounded-xl sm:px-4 sm:py-4 md:mx-auto"
          data-aos="fade-down"
        >
          <div class="flex flex-col border-b py-4 sm:flex-row sm:items-start">
            <div class="shrink-0 mr-auto sm:py-3">
              <p class="font-medium">Account Details</p>
              <p class="text-sm text-gray-600">Edit your account details</p>
            </div>
          </div>
          <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
            <p class="shrink-0 w-32 font-medium">Full Name</p>
            <input
              v-model="fullname"
              placeholder="Full Name"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
            <p class="shrink-1 w-32 font-medium">Niveau</p>
            <input
              v-model="niveau"
              placeholder="2eme"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
          </div>
          <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
            <p class="shrink-0 w-32 font-medium">Email</p>
            <input
              v-model="email"
              placeholder="your.email@domain.com"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
              disabled
            />
          </div>

          <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
            <p class="shrink-0 w-32 font-medium">Domaine</p>
            <input
              v-model="domaine"
              placeholder="Technologie Informatique"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
            <p class="shrink-1 w-32 font-medium">Specialite</p>
            <input
              v-model="specialite"
              placeholder="DSI"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
          </div>

          <div class="flex flex-col gap-4 border-b py-4 sm:flex-row">
            <p class="shrink-0 w-32 font-medium">Etablissement</p>
            <input
              v-model="etablissement"
              placeholder="Technologie Informatique"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
            <p class="shrink-1 w-32 font-medium">TypeStage</p>
            <input
              v-model="typeStage"
              placeholder="DSI"
              class="w-full rounded-md border bg-white px-2 py-2 outline-none ring-gray-600 focus:ring-1"
            />
          </div>

          <div class="flex flex-col gap-4 py-4 lg:flex-row">
            <div class="shrink-0 w-32 sm:py-4">
              <p class="mb-auto font-medium">Avatar</p>
              <p class="text-sm text-gray-600">Change your avatar</p>
            </div>
            <div
              class="flex h-70 w-full flex-col items-center justify-center gap-4 rounded-xl border border-dashed border-gray-300 p-5 text-center"
            >
              <img class="h-16 w-16 rounded-full" :src="imageUrl" alt="" />
              <p class="text-sm text-gray-600">
                Drop your desired image file here to start the upload
              </p>
              <input
                type="file"
                accept=".png, .jpeg, .jpg"
                @change="handleImageChange"
                class="max-w-full rounded-lg px-2 font-medium text-blue-600 outline-none ring-blue-600 focus:ring-1"
              />
            </div>
          </div>
          <div
            class="flex flex-col gap-4 border-b py-4 sm:flex-row sm:justify-center"
          >
            <button
              @click="saveChanges"
              class="rounded-lg border-2 border-transparent bg-gray-950 px-4 py-2 font-medium text-white sm:inline focus:outline-none focus:ring hover:bg-gray-800"
            >
              Save Changes
            </button>
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
import NavBarStd from "./NavBarStd.vue";
import axios from "axios";
import Sidebar from "./Sidebar.vue";
export default {
  data() {
    return {
      id: null,
      fullname: "",
      niveau: "",
      email: "",
      domaine: "",
      specialite: "",
      typeStage: "",
      etablissement: "",
      cin: "",
      update: false,
      image:"",
      imageUrl: "",
      file: null,
    };
  },
  components: {
    NavBarStd,
    Sidebar,
  },

  methods: {
    async getAccountData() {
      let storedData = localStorage.getItem("StudentAccountInfo");
      this.id = JSON.parse(storedData).id;
      this.email = JSON.parse(storedData).email;
      // get etudiant data using id
      let etudiantData = await axios
        .get("http://localhost:8087/etudiant/" + this.id)
        .then((response) => {
          return response.data.student;
        })
        .catch((error) => {
          toast.error("Error fetching data! Please try to reLogin", {
            autoClose: 3000,
          });
        });
      this.fullname = etudiantData.fullname;
      this.niveau = etudiantData.niveau;
      this.domaine = etudiantData.domaine;
      this.specialite = etudiantData.specialite;
      this.typeStage = etudiantData.typeStage;
      this.etablissement = etudiantData.etablissement;
      this.image = etudiantData.image;
      this.cin = etudiantData.cin;

      if (this.image == "test.jpg") {
        this.imageUrl =
          "https://i.postimg.cc/mDWkzGDv/istockphoto-1200064810-170667a.jpg";
      } else {
        this.imageUrl = "http://localhost:8087/file/get/" + this.image;
      }
    },

    handleImageChange(event) {
      this.file = event.target.files[0];
      this.update = true;
      console.log(this.file);
    },

    saveChanges() {
      if (this.update) {
        var Avatar = new FormData();
        Avatar.append("file", this.file);
        axios
          .post("http://localhost:8087/file/upload", Avatar, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
          .then(function (response) {
            toast.success("avatar uploaded succesfully !", {
              autoClose: 2000,
            });
          })
          .catch(function (error) {
            toast.error("Something went wrong !", {
              autoClose: 2000,
            });
          });
      }

      // let etudiant = new FormData();
      // etudiant.append("id", this.id);
      // etudiant.append("fullname", this.fullname);
      // etudiant.append("niveau", this.niveau);
      // etudiant.append("domaine", this.domaine);
      // etudiant.append("specialite", this.specialite);
      // etudiant.append("type_stage", this.typeStage);
      // etudiant.append("etablissement", this.etablissement);
      // etudiant.append("image", this.imageUrl);
      let etudiant = {
        id: this.id,
        fullname: this.fullname,
        niveau: this.niveau,
        cin: this.cin,
        domaine: this.domaine,
        typeStage: this.typeStage,
        specialite: this.specialite,
        etablissement: this.etablissement,
        image: this.image,
      };
      if (this.update) {
        etudiant.image = this.file.name;
      }

      axios
        .post("http://localhost:8087/etudiant/modify", etudiant)
        .then(function (response) {
          toast.success("Account modified succesfully !", {
            autoClose: 2000,
          });
        })
        .catch(function (error) {
          toast.error("Something went wrong !", {
            autoClose: 2000,
          });
        });
    },
  },
  mounted() {
    this.getAccountData();
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
