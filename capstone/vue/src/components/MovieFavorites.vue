<template>
  <div class="movie-container">

    <h1 class="saved-title"> Saved Movies </h1>
    <div class="main-carousel" data-flickity='{ "contain": true }'>
    <flickity class="flickity" ref="flickity" :options="flickityOptions">
      <div class="carousel-cell">
      <movie-card
        v-bind:movie="movie"
        v-for="movie in savedMovies"
        v-bind:key="movie.id"
      />
      </div>
    </flickity>
    </div>
    <h1 class="favorited-title"> Favorited Movies </h1>
    <div class="carousel">
      <flickity v-if="favoritedMovies.length > 0" class="flickity" ref="flickity" :options="flickityOptions">
    <div class="carousel-cell">
      <movie-card
        v-bind:movie="movie"
        v-for="movie in favoritedMovies"
        v-bind:key="movie.id"
      />
    </div>
      </flickity>
    </div>
  </div>
</template>

<script>
import DbService from "../services/DbService";
import MovieCard from "../components/MovieCard.vue";
import Flickity from 'vue-flickity'

export default {
  name: "favorite-movies",
  components: {
    MovieCard,
    Flickity
  },
  data() {
    return {
      savedMovies: [],
      favoritedMovies: [],
      flickityOptions: {
        prevNextButtons: true,
        pageDots: false,
        wrapAround: true,
        
        
      }
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

.flickity-button {
  background: transparent;
}
/* big previous & next buttons */
.flickity-prev-next-button {
  width: 100px;
  height: 100px;
}
/* icon color */
.flickity-button-icon {
  fill: white;
}
/* hide disabled button */
.flickity-button:disabled {
  display: none;
}
.carousel-cell {
  width: 50%; /* half-width */
  height: 160px;
  margin-right: 10px;
  justify-content: center;
}

.carousel-cell.is-selected {
  background: #ED2;
}

.flickity-enabled:focus .flickity-viewport {
  outline: thin dotted;
  outline: 5px auto -webkit-focus-ring-color;
}


</style>