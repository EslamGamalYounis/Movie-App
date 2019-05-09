package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.Contract;
import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.MoviesModel;

import java.util.ArrayList;

public class Model implements Contract.Imodel {

    ArrayList<MoviesModel> results;


    public void setMoviesModels(ArrayList<MoviesModel> moviesModels) {
    }

    @Override
    public ArrayList<MoviesModel> getData() {
        return results;

    }
}
