<template>
  <div class="movie-container">
    <filter-movies />
    <movie-card v-bind:movie="movie" v-for="movie in $store.state.movies" v-bind:key="movie.id"/>
  </div>
</template>


<script>
import MovieCard from "../components/MovieCard.vue";
import MovieService from "../services/MovieService";
import FilterMovies from './FilterForm.vue'


export default {
  name: "movie-list",
  components: {
    MovieCard,
    FilterMovies
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