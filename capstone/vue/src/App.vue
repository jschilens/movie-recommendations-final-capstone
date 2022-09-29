<template>
  <div id="app" style="background-image: url('/movie-poster-background.jpg')">
    <div id="nav">
      <burger-menu id="menu"/>
      
    </div>
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

#nav {
  /* display: flex; */
  background: #484848;
  /* height: 60px; */
}



</style>