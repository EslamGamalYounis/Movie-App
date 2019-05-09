package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.ContractReviews;

import java.util.ArrayList;

public class ModelTrailer implements ContractTrailers.IRmodel {

    private ArrayList<trailersModel> results;


    @Override
    public ArrayList<trailersModel> gettrailersList() {
        return results;
    }
}
