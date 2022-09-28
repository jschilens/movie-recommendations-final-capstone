package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MovieDao {


    public List<Movie> getAllMovies();
    public void addMovie(Movie movie);

}
