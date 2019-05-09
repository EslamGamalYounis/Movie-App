package com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase;

/**
 * Created by Google       Company on 25/11/2016.
 */

public class MovieInfo {
    private String poster_path;
    private String overview;
    private String release_date;
    private int id;
    private String original_title;
    private String title;
    private String backdrop_path;
    private double popularity;
    private int vote_count;
    private String vote_average;

    MovieInfo(){
        this.poster_path="";
        this.overview = "";
        this.release_date = "";
        this.id=0;
        this.original_title="";
        this.title="";
        this.backdrop_path="";
        this.popularity=0.0;
        this.vote_count=0;
        this.vote_average="";
    }

    MovieInfo(String poster_path, String overview, String release_date, int id, String original_title, String title
            , String backdrop_path, double popularity, int vote_count , String vote_average){
        this.poster_path=poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.id=id;
        this.original_title=original_title;
        this.title=title;
        this.backdrop_path=backdrop_path;
        this.popularity=popularity;
        this.vote_count=vote_count;
        this.vote_average=vote_average;
    }





    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }




    @Override
    public String toString() {
        return "MovieInfo{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", id=" + id +
                ", original_title='" + original_title + '\'' +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", vote_count=" + vote_count +
                ", vote_average='" + vote_average + '\'' +
                '}';
    }
}
