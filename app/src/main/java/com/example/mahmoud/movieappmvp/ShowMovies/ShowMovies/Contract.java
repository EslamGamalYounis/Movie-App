package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import java.util.ArrayList;

public class Contract {


    interface Iview {
        void recieveData(ArrayList<MoviesModel> arr, String paramity);
    }

    interface Imodel {
        ArrayList<MoviesModel> getData();

    }

    interface ImainPresenter {

        void loadData(String FilmsType);

        void checkFilms();

    }


}
