<template>
  <div class="movie-container">
  <movie-card v-bind:movie="movie" v-for="movie in favoritedMovies" v-bind:key="movie.id" />
  </div>
</template>

<script>
import MovieCard from "../components/MovieCard.vue";
import MovieService from "../services/MovieService";
import UserService from "../services/UserService";

export default {
name: "favorite-movies",
components: {
  MovieCard
},
data() {
  return {
    user: {
      id: "",
      username: ""
    },
    favoritedMovies: []
  }
},
methods: {
  getFavoritedMovies() {
  MovieService.getFavoritedMovies().then(response => {
      this.favoritedMovies = response.data
})
  }
  },
created() {
  UserService.getCurrentUser().then(response => {
    this.user = response.data;
  })
  
}
}

</script>

<style>


</style>