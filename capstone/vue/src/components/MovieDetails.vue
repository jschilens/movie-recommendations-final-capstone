<template>
  <div class="selected-movie">
    <div class="selected-movie-details">
      <h1 class="title">{{ movie.original_title }}</h1>
      <img v-bind:src="movie.poster_path" class="poster" />
      <p class="overview">{{ movie.overview }}</p>
    </div>
  </div>
</template>

<script>

import MovieService from '../services/MovieService'

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
  created() {
      MovieService.getMovie(this.movie.id).then(response => {
          if(response.status == 200) {
              this.movie = response.data;
          }
      })
  }
};
</script>

<style>
</style>