package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class Movie {

    @JsonProperty("original_title")
    private String title;

    @JsonProperty("poster_path")
    private String poster;

    private String overview;

    private Date release_date;

    @JsonProperty("vote_average")
    private double rating;

    public Movie(String title, String poster, String overview, Date release_date, double rating) {
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.release_date = release_date;
        this.rating = rating;
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
        return title;
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
        this.title = title;
    }
}
