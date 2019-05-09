package com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies;

import android.content.Context;

import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieDb;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieInfo;
import com.squareup.picasso.Picasso;

public class DmainPresenter implements ContractDetail.IDmainPresenter {
    ContractDetail.IDview iDview;
    String title, vote, overview, poster, date, favourite_color;
    Context mContext;
    int filmid;

    public DmainPresenter(ContractDetail.IDview iDview, Context mContext) {
        this.iDview = iDview;
        this.mContext = mContext;
    }

    @Override
    public void loadData() {
        if (iDview.recieveIntent().getString("original_title") != null) {
            title = iDview.recieveIntent().getString("original_title");
            vote = iDview.recieveIntent().getString("vote_average");
            overview = iDview.recieveIntent().getString("overview");
            poster = iDview.recieveIntent().getString("poster_path");
            date = iDview.recieveIntent().getString("release_date");
            favourite_color=iDview.recieveIntent().getString("favourite_color");
            iDview.getDetail_films(title, vote, overview, poster, date,favourite_color);
        } else {
            MovieDb mvDb = new MovieDb(mContext);
            MovieInfo movieData = mvDb.getMovies(poster);
            title = movieData.getTitle();
            vote = movieData.getVote_average();

            overview = movieData.getOverview();
            date = movieData.getRelease_date();
            poster = movieData.getPoster_path();
            filmid = movieData.getId();


        }
    }
}
