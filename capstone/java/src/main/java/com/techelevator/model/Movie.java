package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class Movie {


    private String original_title;

    @JsonProperty("poster_path")
    private String poster;

    private String overview;

    private Date release_date;

    @JsonProperty("vote_average")
    private double rating;

    public Movie(String original_title, String poster, String overview, Date release_date, double rating) {
        this.original_title = original_title;
        this.poster = poster;
        this.overview = overview;
        this.release_date = release_date;
        this.rating = rating;
    }

    public Movie() {

    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return original_title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setTitle(String Title) {
        this.original_title = original_title;
    }
}
