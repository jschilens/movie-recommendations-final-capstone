package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MovieDao {


    public List<Movie> getAllMovies();

    List<Integer> getAcceptableGenreIds();

    public void addMovie(Movie movie);
    public boolean isFavorited(int movieId, int userId);
    public boolean isSaved(int movieId, int userId);
    public void favoriteMovie(int id, int userId);
    public void saveMovie(int id, int userId);
    public List<Movie> getFavoritedMovies(int userId);
    public List<Movie> getSavedMovies(int userId);
    public void unFavoriteMovie(int id, int userId);
    public void unSaveMovie(int id, int userId);




}
