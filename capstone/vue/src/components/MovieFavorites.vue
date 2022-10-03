<template>
  <div class="movie-container">

    <h1 class="saved-title"> Saved Movies </h1>
    <agile>
      <div class="slide">
      <movie-card
        v-bind:movie="movie"
        v-for="movie in savedMovies"
        v-bind:key="movie.id"
      />
      </div>
    </agile>
    <h1 class="favorited-title"> Favorited Movies </h1>
    <div class="slide">
      <movie-card
        v-bind:movie="movie"
        v-for="movie in favoritedMovies"
        v-bind:key="movie.id"
      />
    </div>
  </div>
</template>

<script>
import DbService from "../services/DbService";
import MovieCard from "../components/MovieCard.vue";
import { VueAgile } from 'vue-agile';

export default {
  name: "favorite-movies",
  components: {
    agile: VueAgile,
    MovieCard,
    
    
  },
  data() {
    return {
      savedMovies: [],
      favoritedMovies: [],
    };
  },
  methods: {

    
  },
    
  created() {
    DbService.getSavedMovies().then((response) => {
      this.savedMovies = response.data;
    }),
      DbService.getFavoritedMovies().then((response) => {
        this.favoritedMovies = response.data;
      });
  }
  
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  margin-inline: auto;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

#saved-movies {
display: flex;
flex-wrap: wrap;
}

#favorited-movies {
display: flex;
flex-wrap: wrap;
}



</style>