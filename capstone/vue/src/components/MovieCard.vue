<template>
  <div class="card">
    <div class="container">
      <h1 class="title" id="title" v-on:click.prevent="openDetails()" >{{ movie.original_title }}</h1>
      <h2 class="date" id="date">{{ movie.release_date }}</h2>
          <img v-bind:src="movie.poster_path" class="poster" />
          
      <div class="vote-average">
      <font-awesome-icon  icon="fa-solid fa-star" class="star"/>
      <p class="vote-number">{{movie.vote_average}}</p>
      </div>
     


      <p class="overview">{{ movie.overview }}</p>
      
    <div class="icon">
      <button v-on:click="saveFunction()" class="watch-button">
        <font-awesome-icon v-if="watch" icon="fa-solid fa-eye" />
        <font-awesome-icon v-else icon="fa-solid fa-eye-slash" />
      </button>
    
      <button v-on:click="favoriteFunction()" class="heart-button">
        <font-awesome-icon v-if="heart" icon="fa-solid fa-heart" class="heart-filled" />
        <font-awesome-icon v-else icon="fa-regular fa-heart" />
      </button>
    </div>

    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";
import DbService from "../services/DbService"

export default {
  name: "movie-card",
  props: {
    movie: Object,
  },
  data() {
      return {
        heart: this.movie.favorited,
        watch: this.movie.saved,
      }
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
    reloadPage() {
      window.location.reload();
    },
    favoriteFunction() {
      if (this.heart === true) {
        DbService.unFavorite(this.movie.id);
        this.heart = false;
      } else {
        DbService.favorite(this.movie.id);
        this.heart = true;
      }
    },
    saveFunction() {
      if (this.watch === true) {
        DbService.unsave(this.movie.id);
        this.watch = false;
      } else {
        DbService.save(this.movie.id);
        this.watch = true;
      }
    },

    // may not be passing in the correct parameters to Movie Details
    openDetails() {
      {this.$router.push(`/movies/${this.movie.id}`)}
    }


  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: 'Allerta Stencil';
}

div.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  /* might not need this */
  margin-inline: auto;
  
}

div.card {
  font-size: 12px;
  display: flex;
  flex-direction: column;
  background-color: #1B1B1B;
  /* background-color: white; */
  border: 2px solid black;
  border-radius: 10px;
  width: 350px;
  height: 550px;
  margin: 20px;
  justify-content: center;
  align-items: center;
  margin-inline: auto;
  /* color: #484848; */
  color: white;
}

.vote-average {
    display: flex;
   /* border: 3px solid hotpink; */
   margin-top: 5px;
   margin-bottom: 5px;
   justify-content: center;
}

.star{
  color: gold;
  height: 25px;
  background: #1B1B1B;
  /* border: 3px solid pink; */
  margin: 5% 20% 5% 10%;
}

.vote-number{
  font-size: 20px;
  margin-top: 2px;
}

p.overview {
  display: flex;
  display: -webkit-box;
  width: 300px;
  height: 74px;
  font-size: 14px;
  line-height: 1;
  -webkit-line-clamp: 5;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
  font-size: 15px;
  margin-bottom: 5px;
  
}

h1#title{
  text-align: center;
  width: 200px;
  margin-top: -50px;
}

.title{
  cursor: pointer;
}

.title:hover {
  color: blue;
}

h2#date.date {
  text-align: center;
  width: 150px;
}

.icon {
  display: flex;
  height: 5%;
  /* margin-top: 8px; */
  margin-bottom: -10px;
  width: 90px;
  justify-content: space-around;
}

.watch-button {
  cursor: pointer;
}

.heart-button {
  cursor: pointer;
}

.heart-filled{
  color: red;
}


</style>