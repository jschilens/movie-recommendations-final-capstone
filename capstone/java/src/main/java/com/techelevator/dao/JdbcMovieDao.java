package com.techelevator.dao;


import com.techelevator.controller.UserController;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.management.remote.JMXPrincipal;
import javax.sql.DataSource;
import java.security.Principal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    private UserController userController;
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
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, movie.getMovie_id(), movie.getOriginal_title(), movie.getOverview(), movie.getRelease_date(), movie.getRating(), movie.getPoster());

    }

    @Override
    public void favoriteMovie(int id) {

    }

    @Override
    public void saveMovie(int id) {

    }

    @Override
    public List<Movie> getFavoritedMovies(int userId) {
        List<Movie> favoriteMovies = new ArrayList<>();
        String sql = "SELECT movies.id, movies.original_title, movies.overview, movies.release_date, movies.vote_average, movies.poster_path\n"
                + "FROM movies JOIN movie_lists ON movies.id = movie_lists.favorite_movie_id\n" +
                "JOIN users ON movie_lists.user_id = users.user_id WHERE movie_lists.user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()) {
            favoriteMovies.add(mapRowToMovie(rowSet));
        }
        return favoriteMovies;
    }

    @Override
    public List<Movie> getSavedMovies(int userId) {
        return null;
    }

    @Override
    public void unFavoriteMovie(int id) {

    }

    @Override
    public void unSaveMovie(int id) {

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
