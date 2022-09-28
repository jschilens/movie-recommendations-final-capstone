<template>
  <div id="app" style="background-image: url('/movie-poster-background.jpg')">
    <div id="nav">
      <burgermenu id="menu"/>
      
    </div>
    <router-view />
  </div>
</template>

<script>
import Burgermenu from './components/burgermenu.vue';

  export default { 
    components: { 
        Burgermenu
    }
  }

</script>

<style>

*{
  margin: 0;
  padding: 0;
}

#nav {
  display: flex;
  background: #484848;
  height: 60px;
}

</style>