<template>
  <div class="home">
    <div id="flex">
      <h1 class="header">Welcome, {{ $store.state.user.username }}!</h1>
      <h2 class="now-playing">Now Playing</h2>
      <now-playing class="movieDetails" />
    </div>
  </div>
</template>



<script>
import NowPlaying from "../components/NowPlaying.vue";

export default {
  components: {
    NowPlaying,
  },

  name: "home",
};
</script>

<style scoped>
* {
  font-family: "Allerta Stencil";
  margin: 0;
  padding: 0;
}

#flex {
  display: flex;
  flex-direction: column;
  align-content: stretch;
  height: 96vh;
}

.header {
  color: white;
  justify-content: center;
  margin: 1%;
  background: #1b1b1b;
  margin-top: -56px;
  margin-left: 250px;
  width: 400px;
}

.movieDetails {
  display: flex;
}

.now-playing {
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  text-align: center;
  border: 5px solid white;
}
</style>