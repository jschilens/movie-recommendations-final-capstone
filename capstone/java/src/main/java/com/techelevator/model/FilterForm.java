package com.techelevator.model;

import java.time.LocalDate;
import java.util.Arrays;

public class FilterForm {

    private String original_title;
    private LocalDate min_release_date;
    private LocalDate max_release_date;
    private int[] genre_ids;

    public FilterForm(String original_title, int[] genre_ids, LocalDate min_release_date, LocalDate max_release_date) {
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.min_release_date = min_release_date;
        this.max_release_date = max_release_date;
    }

    public FilterForm() {
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

    @Override
    public String toString() {
        return "FilterForm{" +
                "original_title='" + original_title + '\'' +
                ", min_release_date=" + min_release_date +
                ", max_release_date=" + max_release_date +
                ", genre_ids=" + Arrays.toString(genre_ids) +
                '}';
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

}
