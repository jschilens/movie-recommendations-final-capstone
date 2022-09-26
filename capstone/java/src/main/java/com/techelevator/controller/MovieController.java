package com.techelevator.controller;


import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class MovieController {

    MovieService movieService;
    private MovieDao movieDao;
    private UserDao userDao;


    public MovieController(MovieDao movieDao, UserDao userDao) {
        this.movieDao = movieDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
       List<Movie> movies = new ArrayList<>();
       movies = Arrays.asList(movieService.listMovies());
       return movies;

    }


}
