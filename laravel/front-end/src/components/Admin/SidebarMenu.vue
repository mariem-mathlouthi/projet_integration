<!-- SidebarMenu.vue -->
<template>
  <aside id="sidebar">
    <!-- Sidebar content goes here -->
  <section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile'></i>
			<span class="text">Admin</span>
		</a>
		<ul class="side-menu top">
			<li class="active">
				<a href="#">
					<i class='bx bxs-dashboard'></i>
					<router-link to="/Admin"><span class="text">Tableau de bord</span></router-link>
				</a>
			</li>
			<li>
				<a href="#">
					<i class='bx bxs-shopping-bag-alt'></i>
					<router-link to="/OffresListAdmin"><span class="text">Les offres</span></router-link>
				</a>
			</li>

			
			<li>
    <a href="#">
        <i class='bx bxs-building'></i> <!-- Changer la classe d'icône pour une icône d'entreprise -->
        <router-link to="/UsersList"><span class="text">Les entreprises</span></router-link>
    </a>
</li>
			<li>
				<a href="#">
					<i class='bx bxs-group'></i>
					<router-link to="/UsersListEtudiants"><span class="text">Les etudiants</span></router-link>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			
			<li>
				<a href="#" class="logout">
					<i class='bx bxs-log-out-circle'></i>
					<router-link to="/signin"><span class="text">Déconnexion</span></router-link>
				</a>
			</li>
		</ul>
	</section>
  </aside>
</template>

<script>
export default {
  // SidebarMenu component logic
}
</script>

<style scoped>
</style>
