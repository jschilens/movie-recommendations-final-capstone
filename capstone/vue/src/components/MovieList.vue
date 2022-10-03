<template>
  <div class="movie-container">
    <movie-card v-bind:movie="movie" v-for="movie in $store.state.movies" v-bind:key="movie.id"/>
  </div>
</template>


<script>
import MovieCard from "../components/MovieCard.vue";
import MovieService from "../services/MovieService";


export default {
  name: "movie-list",
  components: {
    MovieCard
  },

  methods: {
    getMovies() {
      MovieService.getAllMovies().then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_MOVIES", response.data);
        }
      });
    },
    retrieveMovie() {
      MovieService.getMovie(this.$route.params.id);
    },
    getFilteredMovies() {
    
    } 
  },
  created() {
    this.getMovies();
  },
};
</script>

<style scoped>
div.movie-container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  

}

</style>