<template>
  <main>
    <div class="head-title">
      <div class="left">
        <h1>Dashboard</h1>
        <ul class="breadcrumb">
          <li>
            <a href="#">Dashboard</a>
          </li>
          <li><i class='bx bx-chevron-right'></i></li>
          <li>
            <a class="active" href="#">Home</a>
          </li>
        </ul>
      </div>
    </div>

    <ul class="box-info">
      <li>
        <i class='bx bxs-calendar-check'></i>
        <span class="text">
          <h3>{{ newOrders }}</h3>
          <p>New Order</p>
        </span>
      </li>
      <li>
        <i class='bx bxs-group'></i>
        <span class="text">
          <h3>{{ students }}</h3>
          <p>Students</p>
        </span>
      </li>
      <li>
        <i class='bx bxs-briefcase'></i>
        <span class="text">
          <h3>{{ companies }}</h3>
          <p>Companies</p>
        </span>
      </li>
    </ul>

   <div class="table-data">
				<div class="order">
					<div class="head">
						<h3>Recent Orders</h3>
						<i class='bx bx-search'></i>
						<i class='bx bx-filter'></i>
					</div>
					<table>
						<thead>
							<tr>
								<th>Company</th>
								<th>domaine </th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="(offre, index) in offres" :key="index">
								<td>
									<img src="../../assets/people.png">
									<p>{{ offre.titre }}</p>
								</td>
								<td>{{ offre.domaine }}</td>
								<td><span >{{ offre.status }}</span></td>
							</tr>
						</tbody>
					</table>
				</div>
	
			</div>
		</main>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      newOrders: 0,
      students: 0,
      companies: 0,
      offres: [] // Ajout de la liste des offres
    };
  },
  mounted() {
    this.fetchDashboardData();
    this.getAllOffresAdmin();
  },
  methods: {
    fetchDashboardData() {
      axios.get('http://localhost:8000/api/states') // Supposant que vous avez une route pour les données du tableau de bord
        .then(response => {
          console.log(response);
          this.newOrders = response.data.newOrders;
          this.students = response.data.students;
          this.companies = response.data.companies;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des données du tableau de bord :', error);
        });
    },
    async getAllOffresAdmin() {
      try {
        const response = await axios.get(
          `http://localhost:8000/api/getAllOffreAdmin`, 
          { 
            headers: { 
              'Cache-Control': 'no-cache' // Assurer qu'il n'y a pas de mise en cache
            } 
          }
        );
        if (response.data.check === true) {
          this.offres = response.data.offres;
          console.table(this.offres);
        } else {
          toast.error("Le serveur a retourné une réponse invalide", {
            autoClose: 2000,
          });
        }
      } catch (error) {
        console.error("Erreur lors de la récupération des données :", error);
        
      }
    },
  }
};
</script>

<style scoped>
/* Vos styles spécifiques ici */
</style>
