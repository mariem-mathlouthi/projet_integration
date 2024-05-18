<template>
  <div id="app">
   
    <SidebarMenu></SidebarMenu>

   
    <section id="content">
      <!-- NAVBAR -->
      <NavbarOne></NavbarOne>
      
      <div class="col-span-9 mt-24 mr-24 ml-24">
        <h1 class="text-center font-weight-bold my-4">Liste des Étudiantes</h1>
        
        <table id="example" class="min-w-full divide-y divide-gray-200 font-[sans-serif]">
          <thead class="bg-gray-100 whitespace-nowrap">
            <tr>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                FullName
              </th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Email
              </th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Specialite
              </th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                CIN
              </th>
              <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Action
              </th>
            </tr>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200 whitespace-nowrap">
            <!-- Utiliser v-for pour afficher chaque étudiant -->
            <tr v-for="student in students" :key="student.id">
              <td class="px-6 py-4 text-sm text-[#333]">{{ student.fullname }}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{ student.email }}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{ student.specialite }}</td>
              <td class="px-6 py-4 text-sm text-[#333]">{{ student.cin }}</td>
              <td class="px-6 py-4 text-sm text-[#333]">
                <button class="text-red-500 hover:text-red-700" @click="confirmDeleteStudent(student.id)">Supprimer</button>
              </td>
            </tr>
          </tbody>
        </table>
        
      </div>
    </section>
    <!-- CONTENT -->
  </div>
</template>

<script>
import NavbarOne from "./NavbarOne.vue";
import SidebarMenu from "./SidebarMenu.vue";
import axios from 'axios';

export default {
  name: 'App',
  components: {
    NavbarOne,
    SidebarMenu
  },
  data() {
    return {
      students: [] 
    };
  },
  mounted() {
    this.fetchStudents();
  },
  methods: {
    fetchStudents() {
      axios.get('http://localhost:8000/api/studentsAdmin')
        .then(response => {
          this.students = response.data.students;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des étudiants :', error);
        });
    },
    confirmDeleteStudent(id) {
      if (window.confirm("Êtes-vous sûr de vouloir supprimer cet étudiant ?")) {
        this.deleteStudent(id);
      }
    },
    deleteStudent(id) {
      axios.delete(`http://localhost:8000/api/deleteStudentAdmin/${id}`)
        .then(response => {
          console.log('Étudiant supprimé avec succès:', response.data);
     
          this.fetchStudents();
        })
        .catch(error => {
          console.error('Erreur lors de la suppression de l\'étudiant :', error);
        });
    }
  }
}
</script>

<style scoped>

</style>
