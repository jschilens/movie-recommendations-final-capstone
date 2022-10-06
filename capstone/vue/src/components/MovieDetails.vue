<template>
  <div class="movie-card">
    <div class="gradient">
      <img class="poster" v-bind:src="movie.poster_path" />
    </div>

    <div class="information-section">
      <h1 class="title">{{ movie.original_title }}</h1>
      <div class="info-additional">
        <div class="voting-average">
          <font-awesome-icon icon="fa-solid fa-star" class="star" />
          <p class="vote-number">{{ movie.vote_average.toFixed(2) }}</p>
        </div>
        <br />
        <p class="date">Release Date: {{ movie.release_date }}</p>
        <p class="runtime">Runtime: {{ movie.runtime }} minutes</p>
        <p class="genre">Genre: {{ movie.genre_name }}</p>
      </div>

      <p class="text">{{ movie.overview }}</p>

      <div class="links">
        <p v-on:click="browseMovies()" class="browse-link">Browse Movies</p>
        <p v-on:click="homePage()" class="home-page">Home Page</p>
      </div>
    </div>
  </div>
</template>

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
        runtime: "",
        genre_name: "",
      },
    };
  },
  methods: {
    retrieveMovie() {
      MovieService.getMovie(this.$route.params.id).then((response) => {
        if (response.status == 200) {
          this.movie = response.data;
          const poster = this.movie.poster_path;
          this.movie.poster_path = poster.replace(/w200/g, "w500");
        }
      });
    },
    browseMovies() {
      this.$router.push({ name: "movies" });
    },

    homePage() {
      this.$router.push({ name: "home" });
    },
  },
  created() {
    this.retrieveMovie();
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  display: block;
}

.star {
  color: gold;
  height: 25px;
  background: #1b1b1b;
}

.vote-number {
  font-size: 25px;
  margin-top: 2px;
}

.movie-card {
  display: flex;
  background: #1b1b1b;
  margin-top: 5%;
  border-radius: 10px;
  width: 100vh;
  margin-inline: auto;
  border: 8px solid white;
}

.information-section {
  flex-direction: column;
  color: white;
}

.info-additional {
  flex-direction: column;
  align-items: center;
}

.poster {
  height: 450px;
}

.voting-average {
  display: flex;
}

.runtime {
  margin-bottom: 5px;
}

.title {
  text-align: center;
  align-content: center;
  margin-inline: auto;
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 40px;
}

.info-additional {
  display: flex;
  margin-inline: auto;
  margin-left: 40px;
  justify-content: center;
}
.date {
  margin-right: 10px;
  margin-bottom: 5px;
}

.text {
  border-radius: 10px;
  margin: 50px 40px 30px 40px;
  font-size: 20px;
}

.runtime {
  margin-right: 10px;
}

.links {
  display: flex;
  justify-content: center;
  margin-top: 50px;
  justify-content: space-evenly;
}
.browse-link:hover {
  cursor: pointer;
  color: red;
}

.home-page:hover {
  cursor: pointer;
  color: red;
}
</style>