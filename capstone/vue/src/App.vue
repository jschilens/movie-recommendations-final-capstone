<template>
  <div id="app" style="background-image: url('/movie-poster-background.jpg')">
    <div id="nav">
      <burgermenu/>
      <router-link v-bind:to="{ name: 'home' }" class="home"> Home </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="logout"> Logout </router-link>
      <router-link v-bind:to="{ name: 'movies' }" class="movies"> Browse </router-link>
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
  font-size: 25px;
  text-align: center;
  height: 35px;
  justify-content: center;
  justify-content: space-evenly;
}

.home{
  color: white;
  text-decoration: none;
}

.movies {
  text-decoration: none;
  color: white;

}

.logout {
  text-decoration: none;
  color: white;
}

</style>