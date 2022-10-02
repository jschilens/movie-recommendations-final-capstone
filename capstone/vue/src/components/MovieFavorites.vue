<template>
  <div class="movie-container">
  <movie-card v-bind:movie="movie" v-for="movie in favoritedMovies" v-bind:key="movie.id" />
  </div>
</template>

<script>

import DbService from '../services/DbService'
import MovieCard from '../components/MovieCard.vue'

export default {
name: "favorite-movies",
components: {
  MovieCard
},
data() {
  return {
    favoritedMovies: []
  }
},
created() {
  DbService.getFavoritedMovies().then(response => {
    
      this.favoritedMovies = response.data
    
  })
}

}


</script>

<style>


</style>