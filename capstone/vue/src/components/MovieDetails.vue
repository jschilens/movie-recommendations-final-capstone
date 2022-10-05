<template>
  <div class="movie-card">
    <div class="gradient">
      <img class="poster" v-bind:src="movie.poster_path" />
    </div>
    
  <div class="information-section">

    <h1 class="title">{{ movie.original_title }}</h1>
    <div class="info-additional">
      <div class="voting-average">
        <font-awesome-icon  icon="fa-solid fa-star" class="star"/>
        <p class="vote-number">{{movie.vote_average.toFixed(2)}}</p>
        </div> <br>
    <p class="date"> Release Date: {{movie.release_date}}</p>
    <p class="runtime">Runtime: {{movie.runtime}} minutes</p >
    <p class="genre">Genre: {{movie.genre_name}}</p>
    
    </div>
    
    <p class="text">{{ movie.overview }}</p>
  
  
    <div class="icon">
      <button v-on:click="saveFunction()" class="watch-button">
        <font-awesome-icon v-if="watch" icon="fa-solid fa-eye" />
        <font-awesome-icon v-else icon="fa-solid fa-eye-slash" />
      </button>
    
      <button v-on:click="favoriteFunction()" class="heart-button">
        <font-awesome-icon v-if="heart" icon="fa-solid fa-heart" />
        <font-awesome-icon v-else icon="fa-regular fa-heart" />
      </button>
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
  /* color: white; */

}

.star{
  color: gold;
  height: 25px;
  background: #1B1B1B;
  /* margin: 5% 20% 10% 10%; */
  
}

.vote-number{
  font-size: 25px;
  margin-top: 2px;
}

.movie-card {
  display: flex;
  background: #1B1B1B;
  margin-top: 5%;
  border-radius:10px;
  width: 100vh;
  /* max-width: 90vh; */
  margin-inline: auto;
  border: 8px solid #1B1B1B
}

.information-section{
  /* display: flex; */
  flex-direction: column;
  color: white;
  
}

.info-additional{
  flex-direction: column;
  align-items: center;
  /* border: 3px solid rgb(3, 39, 243); */
}

.poster{
  height: 450px;
}

.voting-average {
  display: flex;
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
  font-size: 20px;
  /* border: 3px solid hotpink; */
}

.runtime {
  margin-right: 10px;
}

.icon {
  display: flex;
  height: 7%;
  /* border: 3px solid hotpink; */
  margin-bottom: -10px;
  /* width: 90px; */
  justify-content: center
}

.watch-button{
  width: 20px;
  margin-right: 5px;
  background: #1B1B1B;
  color: white;
}

.heart-button{
  width: 20px;
  margin-left: 5px;
  background: #1B1B1B;
  color: white;
}


</style>