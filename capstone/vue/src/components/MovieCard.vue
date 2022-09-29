<template>
  <div class="card">
    <div class="container">
      <h1 class="title" id="title">{{ movie.original_title }}</h1>
      <h2 class="date" id="date">{{ movie.release_date }}</h2>
      <img v-bind:src="movie.poster_path" class="poster" />
      <p class="overview">{{ movie.overview }}</p>
    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
  props: {
    movie: Object,
  },
  // data
  //   // return
  //   //   movie:
  //   //     original_title: "",
  //   //     overview: "",
  //   //     release_date: "",
  //   //     id: this.id,
  //   //     poster_path: "",
  //   //     genre_ids: "",
  //   //     vote_average: "",
  //   //   ,
  //   //   movies: ,
  //   // ;
  // ,

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
  
}

div.card {
  font-size: 12px;
  display: flex;
  flex-direction: column;
  background-color: lavender;
  border: 2px solid black;
  border-radius: 10px;
  width: 350px;
  height: 550px;
  margin: 20px;
  justify-content: center;
  align-items: center;
  
  
  
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
  
  
  /* display: block;
  width: 475px;
  line-break: auto;
  padding-bottom: 1rem;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  -webkit-line-clamp: 2;
 */

  
}

h1#title.title {
  text-align: center;
  width: 200px;
margin-top: -50px;

}

h2#date.date {
  text-align: center;
  width: 150px;

}
</style>
