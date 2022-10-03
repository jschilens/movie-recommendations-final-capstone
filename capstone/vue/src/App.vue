<template>
  <div id="app" style="background-image: url('/movie-poster-background.jpg')">
    <div id="sidebar">
      <burger-menu id="menu"/>
      <h1 id="site-title">ReelDB</h1>
    </div>
    <router-view />
  </div>
</template>

<script>
import BurgerMenu from '../src/components/burgermenu.vue';

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
  font-family: 'Bungee Spice';
  background: #484848;
  
}

#menu {
  display: flex;
  justify-content: flex-start;
  background-color: #484848;
  
}
#site-title {
  display: flex;
  justify-content: center;
  margin-top: -50px;
  padding-bottom: 20px;
  padding-top: 10px;
}

#app {
  height: 100%;
}

</style>