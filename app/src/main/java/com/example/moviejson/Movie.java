package com.example.moviejson;

public class Movie {
    private String imageMovieUrl;
    private String nameMovie;
    private String yearMovie;
    private double voteMovie;
    private String overview;

    public Movie(String imageMovieUrl, String nameMovie, String yearMovie, double voteMovie, String overview){
        this.imageMovieUrl = imageMovieUrl;
        this.nameMovie = nameMovie;
        this.yearMovie = yearMovie;
        this.voteMovie = voteMovie;
        this.overview = overview;

    }

    public double getVoteMovie() {
        return voteMovie;
    }

    public String getOverview() {
        return overview;
    }

    public String getImageMovieUrl() {
        return imageMovieUrl;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public String getYearMovie() {
        return yearMovie;
    }
}
