package com.techelevator.model;

public class MovieGeneral {

    Movie[] results;
    Movie movie;



    public Movie[] getResults() {
        return results;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }
}
