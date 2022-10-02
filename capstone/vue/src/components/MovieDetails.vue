<template>
  <div>
    <movie-card v-bind:movie="loadMovie()"/>
  </div>
</template>

// not displaying, loadMovie undefined

<script>
import MovieCard from "../components/MovieCard.vue"
import MovieService from "../services/MovieService";

export default {
    components: {
        MovieCard
    },
    methods: {
    retrieveMovie() {
      MovieService.getMovie(this.$route.params.id);
    }
  },
  computed: {
      loadMovie() {
          return this.retrieveMovie();
      }
  },

  created() {
    this.loadMovie()
  }

}
</script>

<style>

</style>