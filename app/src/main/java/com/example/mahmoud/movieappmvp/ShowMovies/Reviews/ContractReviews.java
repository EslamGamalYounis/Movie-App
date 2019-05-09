package com.example.mahmoud.movieappmvp.ShowMovies.Reviews;

import android.content.Intent;

import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.Model;
import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.MoviesModel;

import java.util.ArrayList;

public class ContractReviews {


    interface IRview {
        void recievedata(ArrayList<ModelReviews> reviewsModels);
        Intent recieveInent();

    }

    interface IRmodel {
        ArrayList<ModelReviews> ReviewsList();
    }

    interface IRmainPresenter {
     void loadData();

    }


}
