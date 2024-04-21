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
					<router-link to="/Admin"><span class="text">Dashboard</span></router-link>
				</a>
			</li>
			<li>
				<a href="#">
					<i class='bx bxs-shopping-bag-alt'></i>
					<router-link to="/OffresList"><span class="text">Offres</span></router-link>
				</a>
			</li>

			<li>
				<a href="#">
					<i class='bx bxs-message-dots'></i>
					<router-link to="/MessagesList"><span class="text">Messages</span></router-link>
				</a>
			</li>
			<li>
				<a href="#">
					<i class='bx bxs-group'></i>
					<router-link to="/UsersList"><span class="text">Users</span></router-link>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			<li>
				<a href="#">
					<i class='bx bxs-cog'></i>
					<router-link to="/AccountSetting"><span class="text">Settings</span></router-link>
				</a>
			</li>
			<li>
				<a href="#" class="logout">
					<i class='bx bxs-log-out-circle'></i>
					<span class="text">Logout</span>
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
