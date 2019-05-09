package com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies;

import android.content.Intent;
import android.os.Bundle;

import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.MoviesModel;

import java.util.ArrayList;

public class ContractDetail {

    interface IDview {
        void goToTrailer();
        void goToReview();
        void getDetail_films(String title, String vote, String overview, String poster ,String date,String favourite_color);
        Bundle recieveIntent();
    }

    interface IDmodel {
        ArrayList<MoviesModel> getData();

    }

    interface IDmainPresenter {

        void loadData();
    }

}
