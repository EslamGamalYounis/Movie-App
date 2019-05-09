package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import android.content.Intent;

import com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies.DetailMoviesActvity;

/**
 * Created by Google       Company on 29/11/2016.
 */

public interface Listener {

    void setData(String original_title, String overview, String release_date, String vote_average, String poster_path, String id);

    void setFavouriteData(String posterpath, String title, String description, String vote, String date, int filmid);

}

