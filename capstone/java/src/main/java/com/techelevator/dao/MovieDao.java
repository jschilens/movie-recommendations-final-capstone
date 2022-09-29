package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MovieDao {


    public List<Movie> getAllMovies();
    public void addMovie(Movie movie);
    public void favoriteMovie(int id);
    public void saveMovie(int id);
    public List<Movie> getFavoritedMovies(int userId);
    public List<Movie> getSavedMovies(int userId);
    public void unFavoriteMovie(int id);
    public void unSaveMovie(int id);



}
