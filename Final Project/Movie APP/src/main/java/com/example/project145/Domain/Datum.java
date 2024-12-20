package com.example.project145.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("poster")
    @Expose
    private String poster;

    @SerializedName("year")
    @Expose
    private int year;

    @SerializedName("imdb_rating")
    @Expose
    private double imdbRating;

    @SerializedName("images")
    @Expose
    private List<String> images;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    // Additional helper methods
    public String getFirstImage() {
        return (images != null && !images.isEmpty()) ? images.get(0) : null;
    }

    public boolean hasPoster() {
        return poster != null && !poster.isEmpty();
    }
}
