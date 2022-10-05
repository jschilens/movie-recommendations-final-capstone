package com.techelevator.model;

import java.time.LocalDate;

public class FilterForm {

    private String original_title;
    private String genre_name;
    private LocalDate min_release_date;
    private LocalDate max_release_date;
    private int[] genre_ids;
    public FilterForm(String original_title, String genre_name, LocalDate min_release_date, LocalDate max_release_date) {
        this.original_title = original_title;
        this.genre_name = genre_name;
        this.min_release_date = min_release_date;
        this.max_release_date = max_release_date;
    }

    public FilterForm() {
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public LocalDate getMin_release_date() {
        return min_release_date;
    }

    public void setMin_release_date(LocalDate min_release_date) {
        this.min_release_date = min_release_date;
    }

    public LocalDate getMax_release_date() {
        return max_release_date;
    }

    public void setMax_release_date(LocalDate max_release_date) {
        this.max_release_date = max_release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }
}
