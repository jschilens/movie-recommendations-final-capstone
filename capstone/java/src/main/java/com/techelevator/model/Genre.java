package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {

    @JsonProperty("id")
    private int genreId;

    @JsonProperty("name")
    private String genreName;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}
