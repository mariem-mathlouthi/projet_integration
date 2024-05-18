<!-- Navbar.vue -->
<template>
  <nav>
			<i class='bx bx-menu'></i>
			<a href="#" class="nav-link">Catégorie</a>
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Rechercher...">
					<button type="submit" class="search-btn"><i class='bx bx-search'></i></button>
				</div>
			</form>
			<input type="checkbox" id="switch-mode" hidden>
			<label for="switch-mode" class="switch-mode"></label>
			<a href="#" class="notification">
				<i class='bx bxs-bell'></i>
				<span class="num">0</span>
			</a>
			
		</nav>
</template>

<script>
export default {
name: 'NavbarOne',

}
</script>

<style scoped>
</style>


 
