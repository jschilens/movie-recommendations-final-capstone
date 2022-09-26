package com.techelevator.services;


import com.techelevator.model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    private String API_BASE_URL = "https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate";
    private final RestTemplate restTemplate = new RestTemplate();

    public Movie[] listMovies() {
        Movie[] movies = null;
        try {
            movies = restTemplate.getForObject(API_BASE_URL, Movie[].class);

        } catch(RestClientResponseException e) {
            throw e;
        }
        return movies;
    }

    private HttpEntity<Movie> makeMovieEntity(Movie movie) {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Movie> movieHttpEntity = new HttpEntity<>(movie, headers);
        return movieHttpEntity;
    }
}
