package com.techelevator.controller;


import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
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
    private UserDao userDao;


    public MovieController(MovieDao movieDao, UserDao userDao) {
        this.movieDao = movieDao;
        this.userDao = userDao;
        movieService = new MovieService();
    }

    @RequestMapping(path ="/filter/{filters}", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMoviesWithFilters(@PathVariable String filters) {
        System.out.println(filters);
        List<Movie> movies = new ArrayList<>();
        movies = movieService.getFilteredMovies(filters);
        return movies;
    }



    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
       System.out.println("in controller");
       List<Movie> movies = new ArrayList<>();
       movies = movieService.getAllMovies();
       return movies;

    }

    @RequestMapping(path = "/movie/{id}", method = RequestMethod.GET)
    public Movie getMovie(@Valid @RequestParam int movieId) {
        Movie movie = movieService.getMovie(movieId);
        return movie;
    }


}
