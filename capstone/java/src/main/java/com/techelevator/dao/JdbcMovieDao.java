package com.techelevator.dao;


import com.techelevator.controller.UserController;
import com.techelevator.model.Movie;

import com.techelevator.services.MovieService;

import com.techelevator.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserController userController;
    @Autowired
    private MovieService movieService;
    @Autowired
    private JdbcUserDao jdbcUserDao;
    private User user;


    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movies (id, original_title, overview, release_date, vote_average, poster_path)\n" +
                "VALUES (?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING";
        jdbcTemplate.update(sql, movie.getMovie_id(), movie.getOriginal_title(), movie.getOverview(), movie.getRelease_date(), movie.getRating(), movie.getPoster());
        String genres = "INSERT INTO genres (genre_ids, movie_id)" +
                "VALUES (?, ?) ON CONFLICT DO NOTHING";
//        for (Integer genreId: movie.getGenre_id()) {
//            jdbcTemplate.update(genres, genreId, movie.getMovie_id());
//        }
    }

    @Override
    public boolean isFavorited(int movieId, int userId) {
        Boolean favorited = false;
        String sql = "SELECT EXISTS (SELECT user_id FROM movie_favorited WHERE favorite_movie_id = ? AND user_id = ?)";
        favorited = jdbcTemplate.queryForObject(sql, Boolean.class, movieId, userId);
        return favorited;
    }

    @Override
    public boolean isSaved(int movieId, int userId) {
        Boolean saved = false;
        String sql = "SELECT EXISTS (SELECT user_id FROM movie_saved WHERE saved_movie_id = ? AND user_id = ?)";
        saved = jdbcTemplate.queryForObject(sql, Boolean.class, movieId, userId);
        return saved;
    }

    @Override
    public void favoriteMovie(int id, int userId) {
        Movie movie = movieService.getMovie(id);
        addMovie(movie);
//        String sql = "INSERT INTO movies (id, original_title, overview, release_date, vote_average, poster_path)\n" +
//        "VALUES (?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING";
        String sql = "INSERT INTO movie_favorited (user_id, favorite_movie_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
//        jdbcTemplate.update(sql, movie.getMovie_id(), movie.getOriginal_title(), movie.getOverview(), movie.getRelease_date(), movie. getRating(), movie.getPoster());
        jdbcTemplate.update(sql, userId,movie.getMovie_id());
    }

    @Override
    public void unFavoriteMovie(int id, int userId) {
        String sql = "DELETE FROM movie_favorited WHERE user_id = ? AND favorite_movie_id = ?";
        jdbcTemplate.update(sql, userId, id);
    }

    @Override
    public void saveMovie(int id, int userId) {
        Movie movie = movieService.getMovie(id);
        addMovie(movie);
//        String sql = "INSERT INTO movies (id, original_title, overview, release_date, vote_average, poster_path)\n" +
//                "VALUES (?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING";
        String sql = "INSERT INTO movie_saved (user_id, saved_movie_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
//        jdbcTemplate.update(sql, movie.getMovie_id(), movie.getOriginal_title(), movie.getOverview(), movie.getRelease_date(), movie. getRating(), movie.getPoster());
        jdbcTemplate.update(sql, userId,movie.getMovie_id());
    }

    @Override
    public void unSaveMovie(int id, int userId) {
        String sql = "DELETE FROM movie_saved WHERE user_id = ? AND saved_movie_id = ?";
        jdbcTemplate.update(sql, userId, id);
    }

    @Override
    public List<Movie> getFavoritedMovies(int userId) {
        List<Movie> favoriteMovies = new ArrayList<>();
        String sql = "SELECT movies.id, movies.original_title, movies.overview, movies.release_date, movies.vote_average, movies.poster_path\n"
                + "FROM movies JOIN movie_favorited ON movies.id = movie_favorited.favorite_movie_id\n" +
                "JOIN users ON movie_favorited.user_id = users.user_id WHERE movie_favorited.user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()) {
            favoriteMovies.add(mapRowToMovie(rowSet));
        }
        for(Movie movie : favoriteMovies) {
            movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
        }
        return favoriteMovies;
    }

    @Override
    public List<Movie> getSavedMovies(int userId) {
        List<Movie> savedMovies = new ArrayList<>();
        String sql = "SELECT movies.id, movies.original_title, movies.overview, movies.release_date, movies.vote_average, movies.poster_path\n"
                + "FROM movies JOIN movie_saved ON movies.id = movie_saved.saved_movie_id\n" +
                "JOIN users ON movie_saved.user_id = users.user_id WHERE movie_saved.user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()) {
            savedMovies.add(mapRowToMovie(rowSet));
        }
        for(Movie movie : savedMovies) {
                movie.setPoster("https://image.tmdb.org/t/p/w200" + movie.getPoster());
        }
        return savedMovies;
    }





    public Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setMovie_id(rowSet.getInt("id"));
        movie.setTitle(rowSet.getString("original_title"));
        movie.setOverview(rowSet.getString("overview"));
        movie.setRelease_date(rowSet.getDate("release_date").toLocalDate());
        movie.setRating(rowSet.getDouble("vote_average"));
        movie.setPoster(rowSet.getString("poster_path"));
        return movie;
    }
}