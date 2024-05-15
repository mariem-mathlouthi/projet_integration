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
          <p>New Request</p>
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
						<h3>Recent Requests</h3>
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
									 <img :src="logoURL" >
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
      offres: [] ,
      logoURL:"https://i.postimg.cc/mDWkzGDv/istockphoto-1200064810-170667a.jpg",
    };
  },
  mounted() {
    this.fetchDashboardData();
    this.getAllOffresAdmin();
    this.getLogoUrl();
  },
  methods: {  getLogoUrl(){
        let storedLogoUrl= localStorage.getItem("EntrepriseLogo");
        if (storedLogoUrl) {
          this.logoURL = JSON.parse(storedLogoUrl).logo;
        }
      },
    fetchDashboardData() {
      axios.get('http://localhost:8087/admin/states') // Supposant que vous avez une route pour les données du tableau de bord
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
          `http://localhost:8087/admin/offres`, 
          { 
            headers: { 
              'Cache-Control': 'no-cache' // Assurer qu'il n'y a pas de mise en cache
            } 
          }
        );
        
          this.offres = response.data;
          console.table(this.offres);
       
        
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
