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
  display: flex;
  width: 100% !important;
  background-image: url("https://cutewallpaper.org/21/movie-collage-wallpapers/Collage,-Poster,-Human,-People,-Person-resized-by-Ze-Robot.jpg");
  background-repeat: repeat-y;
  background-size: 100%;
}

site-title {
  width: 100%;
}

#sidebar {
  font-family: "Bungee Spice";
  background: #1b1b1b;
}

#menu {
  display: flex;
  justify-content: flex-start;
  background-color: #1b1b1b;
  width: 100%;
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