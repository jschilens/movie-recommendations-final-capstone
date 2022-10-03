package com.techelevator.controller;


import com.techelevator.dao.JdbcMovieDao;
import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class MovieController {


    MovieService movieService;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private JdbcMovieDao jdbcMovieDao;


    public MovieController(MovieDao movieDao, UserDao userDao) {
        this.movieDao = movieDao;
        this.userDao = userDao;
        movieService = new MovieService();
    }

    @RequestMapping(path ="/movies/filter", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMoviesWithFilters(@RequestParam String original_title, @RequestParam(required = false) String genre_name, @RequestParam(required = false) LocalDate min_release_date, @RequestParam(required = false) LocalDate max_release_date) {

        List<Movie> movies = new ArrayList<>();
        movies = movieService.getAllMovies();
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie: movies){
            if(genre_name != null) {
                if(movie.getGenre_name().equalsIgnoreCase(genre_name)) {
                    filteredMovies.add(movie);
                }
            }
            else if(min_release_date != null) {
                if(movie.getRelease_date().equals(min_release_date)) {
                    filteredMovies.add(movie);
                }
            }
            else if(max_release_date != null) {
                if(movie.getRelease_date().equals(max_release_date)) {
                    filteredMovies.add(movie);
                }
            } else {
                if(movie.getOriginal_title().equalsIgnoreCase(original_title)) {
                   filteredMovies.add(movie);
                }
            }
//            if(jdbcMovieDao.isSaved(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
//                movie.setSaved(true);
//            } else {
//                movie.setSaved(false);
//            }
//            if(jdbcMovieDao.isFavorited(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
//                movie.setFavorited(true);
//            } else {
//                movie.setFavorited(false);
//            }
        }
        return filteredMovies;
    }

    @RequestMapping(path="/now-playing", method = RequestMethod.GET)
    public List<Movie> getCurrentMovies(Principal principal) {
        List<Movie> movies = movieService.getNowPlaying();
        for (Movie movie: movies){
            if(jdbcMovieDao.isSaved(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setSaved(true);
            } else {
                movie.setSaved(false);
            }
            if(jdbcMovieDao.isFavorited(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setFavorited(true);
            } else {
                movie.setFavorited(false);
            }
        }
        return movies;
    }

    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies(Principal principal) {
        List<Movie> movies = new ArrayList<>();
        movies = movieService.getAllMovies();
        for (Movie movie: movies){
            if(jdbcMovieDao.isSaved(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setSaved(true);
            } else {
                movie.setSaved(false);
            }
            if(jdbcMovieDao.isFavorited(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setFavorited(true);
            } else {
                movie.setFavorited(false);
            }

        }

        return movies;
    }

    @RequestMapping(path = "/movie/{id}", method = RequestMethod.GET)
    public Movie getMovie(Principal principal, @PathVariable("id") int movieId) {
        Movie movie = movieService.getMovie(movieId);
        if(jdbcMovieDao.isSaved(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
            movie.setSaved(true);
        } else {
            movie.setSaved(false);
        }
        if(jdbcMovieDao.isFavorited(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
            movie.setFavorited(true);
        } else {
            movie.setFavorited(false);
        }
        return movie;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/movies/favorited/{id}", method = RequestMethod.PUT)
    public void favoriteMovie(Principal principal, @Valid @PathVariable int id) {
        jdbcMovieDao.favoriteMovie(id, userDao.findIdByUsername(principal.getName()));
    }


    @RequestMapping(path = "/movies/unfavorited/{id}", method = RequestMethod.DELETE)
    public void unfavoriteMovie(Principal principal, @Valid @PathVariable int id) {
        jdbcMovieDao.unFavoriteMovie(id, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/favorited", method = RequestMethod.GET)
    public List<Movie> getFavoritedMovies(Principal principal) {
        List<Movie> favoritedMovies = new ArrayList<>();
        favoritedMovies = jdbcMovieDao.getFavoritedMovies(userDao.findIdByUsername(principal.getName()));
        for (Movie movie: favoritedMovies){
            movie.setFavorited(true);
            if(jdbcMovieDao.isSaved(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setSaved(true);
            } else {
                movie.setSaved(false);
            }
        }
        return favoritedMovies;
    }

    @RequestMapping(path = "/movies/saved/{id}", method = RequestMethod.PUT)
    public void saveMovie(Principal principal, @Valid @PathVariable int id) {
        jdbcMovieDao.saveMovie(id, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/movies/unsaved/{id}", method = RequestMethod.DELETE)
    public void unSaveMovie(Principal principal, @Valid @PathVariable int id) {
        jdbcMovieDao.unSaveMovie(id, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/saved", method = RequestMethod.GET)
    public List<Movie> getSavedMovies(Principal principal) {
        List<Movie> savedMovies = new ArrayList<>();
        savedMovies = jdbcMovieDao.getSavedMovies(userDao.findIdByUsername(principal.getName()));
        for (Movie movie: savedMovies){
            movie.setSaved(true);
            if(jdbcMovieDao.isFavorited(movie.getMovie_id(), userDao.findIdByUsername(principal.getName()))){
                movie.setFavorited(true);
            } else {
                movie.setFavorited(false);
            }
        }

        return savedMovies;

    }
//
//    @RequestMapping(path = "/movies/{userId}/favorites", method = RequestMethod.GET)
//    public List<Movie> getSavedMovies(@Valid @PathVariable int userId, Principal principal) {
//        List<Movie> savedMovies = new ArrayList<>();
//        if(userId == userDao.findIdByUsername(principal.getName())) {
//
//        }
//        return savedMovies;
//    }



}