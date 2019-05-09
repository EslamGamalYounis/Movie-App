package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import android.content.Intent;

import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.ModelReviews;

import java.util.ArrayList;

public class ContractTrailers {

    interface IRview {
        void recievedata(ArrayList<trailersModel> trailersModels);

        Intent recieveInent();

    }

    interface IRmodel {
        ArrayList<trailersModel> gettrailersList();
    }

    interface IRmainPresenter {
        void loadData();

    }
}
