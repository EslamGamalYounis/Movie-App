package com.example.mahmoud.movieappmvp.ShowMovies.Reviews;

import java.util.ArrayList;

public class ModelR implements ContractReviews.IRmodel {

    private ArrayList<ModelReviews> results;

    @Override
    public ArrayList<ModelReviews> ReviewsList() {
        return results;
    }
}
