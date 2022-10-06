<template>
  <div>
    <movie-card
      v-bind:movie="movie"
      v-for="movie in $store.state.movies"
      v-bind:key="movie.id"
    />
  </div>
</template>

<script>
import MovieService from "../services/MovieService";
import MovieCard from "../components/MovieCard.vue";

export default {
  components: {
    MovieCard,
  },

  data() {
    return {
      movie: {
        original_title: "",
        overview: "",
        release_date: "",
        id: this.id,
        poster_path: "",
        genre_ids: "",
        vote_average: "",
      },
    };
  },

  methods: {
    getMovies() {
      MovieService.getNowPlaying().then((response) => {
        if (response.status === 200) {
          this.$store.commit("SET_MOVIES", response.data);
        }
      });
    },
  },

  created() {
    MovieService.getMovie(this.movie.id).then((response) => {
      if (response.status == 200) {
        this.movie = response.data;
      }
    }),
      this.getMovies();
  },
};
</script>

<style>
</style>