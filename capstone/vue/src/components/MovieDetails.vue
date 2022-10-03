<template>
  <div>
    <h1 class="title" id="title">{{ movie.original_title }}</h1>
      <h2 class="date" id="date">{{ movie.release_date }}</h2>
      <img v-bind:src="movie.poster_path" class="poster" />
      <p class="overview">{{ movie.overview }}</p>
  </div>
</template>

// not displaying, loadMovie undefined

<script>

import MovieService from "../services/MovieService";


export default {

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
    retrieveMovie() {
      MovieService.getMovie(this.$route.params.id).then(response => {
        if(response.status == 200) {
          this.movie = response.data
        }
      })
    },
  },
  created() {
    this.retrieveMovie();
  },
};
</script>

<style>

* {
  
}
</style>