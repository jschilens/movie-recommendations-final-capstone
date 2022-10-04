<template>
  <div id="app">
    <div id="sidebar">
      <burger-menu id="menu" />
      <h1 id="site-title">ReelDB</h1>
    </div>
    <router-view />
  </div>
</template>

<script>
import BurgerMenu from "../src/components/burgermenu.vue";

export default {
  components: {
    BurgerMenu,
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

body {
  width: 100%;
  background-image: url("/movie-poster-background.jpg");
  background-repeat: repeat-y;
}

body {
  background-image: url("/movie-poster-background.jpg");
  background-repeat: repeat-x;
  background-size: 100% !important;
}

#sidebar {
  font-family: "Bungee Spice";
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
  padding-bottom: 15px;
  padding-top: 10px;
  margin-inline: auto;
}

#app {
  height: 100vh;
  width: 200vh;
}
</style>