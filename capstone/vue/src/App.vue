<template>
  <div id="app" style="background-image: url('/movie-poster-background.jpg')">
  <header class="title"> 
    <div id="sidebar">
      <burger-menu id="menu"/>
    </div>
    <h1 class="name">Movie Site</h1> -->
     </header>
    <router-view />
  </div>
</template>

<script>
import BurgerMenu from './components/BurgerMenu.vue';

  export default { 
    components: { 
        BurgerMenu
    }
  }

</script>

<style>

*{
  margin: 0;
  padding: 0;
}

#sidebar {
  display: flex;
  background: #484848;
}

#menu {
  display: flex;
  justify-content: flex-start;
  background-color: #484848;
}
.name {
  font-family: 'Bungee Spice';
  text-align: center;
  /* background-color: #878787;
     opacity: 75%; */
}

</style>