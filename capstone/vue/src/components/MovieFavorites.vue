<template>
  <div class="movie-container">
  <movie-card v-bind:movie="movie" v-for="movie in savedMovies" v-bind:key="movie.id" />
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
    savedMovies: []
  }
},
created() {
  DbService.getSavedMovies().then(response => {
    
      this.savedMovies = response.data
    
  })
}

}


</script>

<style>


</style>