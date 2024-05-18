<template>
  <main>
    <div class="head-title">
      <div class="left">
        <h1>Dashboard</h1>
        <ul class="breadcrumb">
          <li>
            <a href="#">Tableau de bord</a>
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
          <p>Les nouvelles demandes</p>
        </span>
      </li>
      <li>
        <i class='bx bxs-group'></i>
        <span class="text">
          <h3>{{ students }}</h3>
          <p>Les étudiants</p>
        </span>
      </li>
      <li>
        <i class='bx bxs-briefcase'></i>
        <span class="text">
          <h3>{{ companies }}</h3>
          <p>Les entreprises</p>
        </span>
      </li>
    </ul>

   <div class="table-data">
				<div class="order">
					<div class="head">
						<h3>Les demandes récentes</h3>
						<i class='bx bx-search'></i>
						<i class='bx bx-filter'></i>
					</div>
					<table>
						<thead>
							<tr>
								<th>Entreprise</th>
                <th>Offre</th>
								<th>Domaine </th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="(offre, index) in offres" :key="index">
                <td>
									<img :src="'http://localhost:8000' + offre.logo" alt="">
								</td>
								<td>
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
          console.log(response.data.offres);
          for(let i=0; i < response.data.offres.length; i++){
            const response2 = await axios.get(
            `http://localhost:8000/api/getEntreprise/${response.data.offres[i].idEntreprise}`);
            if (response2.data.check==true) {
              console.log(response.data);
              let logoURL = response2.data.entreprise.logo;
            let myObject= {
              logo:logoURL,
              titre:response.data.offres[i].titre,
              domaine:response.data.offres[i].domaine,
              status:response.data.offres[i].status,
            }
            this.offres.push(myObject);
          }
          console.table(this.offres);
        } }
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
