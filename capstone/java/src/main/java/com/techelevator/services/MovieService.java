package com.techelevator.services;


import com.techelevator.dao.MovieDao;
import com.techelevator.model.Genre;
import com.techelevator.model.Movie;
import com.techelevator.model.MovieGeneral;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieService {

    private final String API_BASE_URL = "https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&with_watch_monetization_types=flatrate";
    private final RestTemplate restTemplate = new RestTemplate();

    public Movie getMovie(int movieId) {
        Movie movie = new Movie();
        movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US/", Movie.class);
        assert movie != null;
        movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
        int[] genreIds = new int[movie.getGenres().length];
        Genre[] genres = movie.getGenres();
        String genreNames = "";
        for (int i = 0; i < movie.getGenres().length; i++) {

            genreIds[i] = genres[i].getGenreId();
            genreNames += genres[i].getGenreName() + ", ";
        }
        if (genreNames.length() > 2) {
            genreNames = genreNames.substring(0, genreNames.length() - 2);
        }
        movie.setGenre_ids(genreIds);
        movie.setGenre_name(genreNames);
        return movie;
    }

    public List<Movie> getTitleFilteredMovies(String original_title) {
        Movie[] movies = null;
//        System.out.println("list movies");
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&query=" + original_title , MovieGeneral.class);
//        System.out.println(movieGeneral);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
            System.out.println(movie);
        }
        return Arrays.asList(movies);
    }

    public List<Movie> getMinYearFilteredMovies(LocalDate min_release_date) {
        Movie[] movies = null;
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&sort_by=popularity.desc&release_date.gte=" + min_release_date.toString(), MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
            System.out.println(movie);
        }
        return Arrays.asList(movies);
    }
    public List<Movie> getMaxYearFilteredMovies(LocalDate max_release_date) {
        Movie[] movies = null;
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&sort_by=popularity.desc&release_date.lte=" + max_release_date.toString(), MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
            System.out.println(movie);
        }
        return Arrays.asList(movies);
    }
    public List<Movie> getGenreFilteredMovies(int[] genre_ids) {
        System.out.println("hello");
        Movie[] movies = null;
        String genres = "";
        genres = Arrays.toString(genre_ids);
        genres = genres.substring(1, genres.length() -1);

        System.out.println(genres);
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&with_genres=" + genres, MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
            System.out.println(movie);
        }
        return Arrays.asList(movies);
    }
    public List<Movie> getGenreAndDateFilteredMovies(int[] genre_ids, LocalDate min_release_date, LocalDate max_release_date) {
        System.out.println("hello");
        Movie[] movies = null;
        String genres = "";
        if(genre_ids.length > 1) {
            genres = String.join(",", Arrays.toString(genre_ids));
        } else {
            genres = Arrays.toString(genre_ids);
        }
        System.out.println(genres);
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&sort_by=popularity.desc&with_genres=" + genres + "&release_date.gte=" + min_release_date + "&release_date.lte=" + max_release_date, MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
            System.out.println(movie);
        }
        return Arrays.asList(movies);
    }






    private HttpEntity<Movie> makeMovieEntity(Movie movie) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Movie> movieHttpEntity = new HttpEntity<>(movie, headers);
        return movieHttpEntity;
    }

    public List<Movie> getAllMovies() {
        Movie[] movies = null;
        MovieGeneral movieGeneral = restTemplate.getForObject(API_BASE_URL, MovieGeneral.class);
        movieGeneral = restTemplate.getForObject(API_BASE_URL + "&page=2", MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();

        for (Movie movie : movies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());

        }
        return Arrays.asList(movies);
    }

    public List<Movie> getNowPlaying() {
        Movie[] movies = null;
        Movie[] currentFour = new Movie[4];
        MovieGeneral movieGeneral = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=1860d7aac96c2d5d65b5d6760a855c9b&language=en-US&page=1", MovieGeneral.class);
        assert movieGeneral != null;
        movies = movieGeneral.getResults();
        for (int i =0; i < 4; i++) {
            movies[i].setPoster("https://image.tmdb.org/t/p/w200" + movies[i].getPoster());
            currentFour[i] = movies[i];
        }
        return Arrays.asList(currentFour);
    }
}