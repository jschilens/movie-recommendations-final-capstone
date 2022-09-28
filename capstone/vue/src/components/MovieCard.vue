<template>
  <div
    class="card"
    v-on:click="retrieveMovie"
    v-bind:to="{ name: 'movie-details' }"
  >
    <div class="movie-details" v-for="movie in movies" v-bind:key="movie.id">
      <h1 class="title">{{ movie.original_title }}</h1>
      <h2 class="date">{{ movie.release_date }}</h2>
      <img v-bind:src="movie.poster_path" class="poster" />
      <font-awesome-icon icon="fa-solid fa-film" />
      <font-awesome-icon icon="fa-solid fa-heart" />
      <p class="overview">{{ movie.overview }}</p>
    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
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
      movies: [],
    };
  },

  methods: {
    getMovies() {
      MovieService.getAllMovies().then((response) => {
        if (response.status == 200) {
          this.movies = response.data;
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
.card {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-content: space-evenly;
  justify-content: center;
}

.date {
  text-align: center;
}

.movie-details {
  display: flex;
  flex-direction: column;
  width: 22%;
  margin: 2% 2% 0px 0%;
  align-content: space-evenly;
  background-color: #484848;
  border: 2px solid black;
  color: white;
  border-radius: 10px;
}

.title {
  text-align: center;
  margin: 5px;
}

.poster {
  display: flex;
  flex: 0 1 auto;
  object-fit: cover;
  display: block;
  margin: 0 auto;
  margin-bottom: 5%;
}

.overview {
  font-display: ;
  text-align: center;
  margin: 5% 5% 20px 5%;
  text-overflow: ellipsis;
  font-size: larger;
}
</style>
