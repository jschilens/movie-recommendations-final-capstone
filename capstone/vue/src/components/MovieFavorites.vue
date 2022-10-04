<template>
  <div>
    <div>
      <v-app id="main">
        <v-carousel
          height="auto"
          class="container"
           v-model="model"
          hide-delimiters
        >
          <v-carousel-item
            v-for="movie in savedMovies"
            :key="movie.id"
            reverse-transition="fade-transition"
            transition="fade-transition"
            hide-delimiter
          >
            <movie-card :movie="movie" class="cell" />
          </v-carousel-item>
        </v-carousel>
      </v-app>
    </div>

    <div>
      <v-app id="main">
        <v-carousel
          height="auto"
          class="container"
          v-model="anotherModel"
          hide-delimiters
        >
          <v-carousel-item
            v-for="movie in favoritedMovies"
            :key="movie.id"
            reverse-transition="fade-transition"
            transition="fade-transition"
            hide-delimiter
          >
            <movie-card :movie="movie" class="cell" />
          </v-carousel-item>
        </v-carousel>
      </v-app>
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
      model: [],
      anotherModel: []
      
    };
  },
  methods: {},

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
  /* -webkit-box-sizing: border-box; */
  /* box-sizing: border-box; */
}

.container {
  width: 700px;
  /* background: white; */
  /* border: 3px solid hotpink; */
  /* height: 100px; */
}

#main {
  width: 500px;
  background: white;
  /* height: 600px */
}

::v-deep .v-application--wrap {
  min-height: fit-content;
}

.theme--light.v-application {
  background: none;
}
</style>