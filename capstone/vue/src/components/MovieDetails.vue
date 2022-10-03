<template>
  <div class="movie-card">
    <img class="poster" v-bind:src="movie.poster_path" />
  <div class="information-section">
    <h1 class="title">{{ movie.original_title }}</h1>
    <div class="info-additional">
      <p class="date"> {{movie.release_date}}</p>
    <span class="runtime">ADD MINUTES HERE</span>
    <p class="genre">ADD GENRE HERE</p>
    </div>
    <p class="text">{{ movie.overview }}</p>
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
      },
    };
  },
  methods: {
    retrieveMovie() {
      MovieService.getMovie(this.$route.params.id).then((response) => {
        if (response.status == 200) {
          this.movie = response.data;
        }
      });
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
  color: white;
}

#app {
    height: 100vh !Important;
}

.movie-card {
  display: flex;
  background: black;
  margin-top: 5%;
  border-radius:10px;
  width: 100vh;
  /* max-width: 90vh; */
  margin-inline: auto;
  border: 3px solid hotpink;
}

.information-section{
  flex-direction: column;
  /* border: 3px solid hotpink; */
}

.poster{
  height: 450px;
}



.title{
  text-align: center;
  align-content: center;
  margin-inline: auto;
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 40px;
}

.info-additional{
  display: flex;
  margin-inline: auto;
  /* border: 3px solid hotpink; */
  margin-left: 40px;
  justify-content: center;
  
}
.date{
  margin-right: 10px;
}

.text {
  border-radius: 10px;
  /* max-width: 400px; */
  margin: 50px 40px 30px 40px;
  border: 3px solid hotpink;
}

.runtime {
  margin-right: 10px;
}


</style>