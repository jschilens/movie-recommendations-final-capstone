<template>
    <div class="card"> 
        <!-- This needs to be changed so it is not always Orphan: First Kill. -->
    <div class="movie-details" v-for="movie in movies" v-bind:key="movie.id">
        <h1> {{ movie.original_title }} </h1>
        <p> {{ movie.overview }} </p>
        <img v-bind:src="movie.poster_path" />
    </div>
    
    </div>
</template>


<script>

import MovieService from "../services/MovieService";


export default {
    name: "movie-card",
    data() {
        return  {
            movie: {
            original_title: "",
            overview: "",
            release_date: "",
            id: this.id,
            poster_path: "",
            genre_ids: "",
            vote_average: ""
            },
            movies: []
        }
    },

    methods: {
        getMovies() {
            MovieService.getAllMovies().then((response) => {
            if(response.status == 200) {
                this.movies = response.data;
            
            }
        })
        },
        retrieveMovie() {
            MovieService.getMovie(this.$route.params.id)
        }
    },

    created() {
        this.getMovies();
    }

}

</script>


<style>

body {
    background: #fcde67;
}

.card{ 
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin: 20px;
    
    
}

.movie-details {
    /* Card box */
    display: block;
    background-color: #484848;
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    margin: 20 auto;
    padding: 20px; 
    justify-content: center;
    flex-grow: 1;
    
    
    
}

</style>
