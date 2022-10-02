<template>
  <div class="movie-container">

    
    <h1 class="saved-title"> Saved Movies </h1>
    <div class="gallery js-flickity" data-flickity-options='{ "wrapAround": true }'>
    <div id="saved-movies" class="saved-movies">
      <movie-card class="gallery-cell"
        v-bind:movie="movie"
        v-for="movie in savedMovies"
        v-bind:key="movie.id"
      />

    </div>
    </div>
    <h1 class="favorited-title"> Favorited Movies </h1>
    <div id="favorited-movies" class="favorited-movies">
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

export default {
  name: "favorite-movies",
  components: {
    MovieCard,
  },
  data() {
    return {
      savedMovies: [],
      favoritedMovies: [],
    };
  },
  created() {
    DbService.getSavedMovies().then((response) => {
      this.savedMovies = response.data;
    }),
      DbService.getFavoritedMovies().then((response) => {
        this.favoritedMovies = response.data;
      });
  },
};
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

.gallery-cell {
  width: 66%;
  height: 100px;
  margin-right: 10px;
  background: #8C8;
  counter-increment: gallery-cell;
}

/* cell number */
.gallery-cell:before {
  display: block;
  text-align: center;
  content: counter(gallery-cell);
  line-height: 100px;
  font-size: 80px;
  color: white;
}

</style>