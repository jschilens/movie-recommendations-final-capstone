<template>
  <div>
    <movie-card />
  </div>
</template>


<script>
import MovieCard from "@/components/MovieCard";
import MovieService from "../services/MovieService";


export default {
  name: "movie-list",

  components: {
    MovieCard,
  },

  methods: {
    getMovies() {
      MovieService.getAllMovies().then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_MOVIES", response.data);
        }
      });
    },
  },
  created() {
    this.getMovies;
  },
};
</script>

<style>

</style>