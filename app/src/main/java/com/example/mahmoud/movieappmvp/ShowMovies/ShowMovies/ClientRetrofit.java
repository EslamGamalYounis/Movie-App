package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRetrofit {
    private static Retrofit ourInstance;

    private ClientRetrofit() {
    }

    public static Retrofit getInstance(String FilmsType) {
        ourInstance = new Retrofit.Builder().baseUrl(" http://api.themoviedb.org/3/movie/" + FilmsType + "/").
                addConverterFactory(GsonConverterFactory.create(new Gson())).build();


        return ourInstance;
    }


}
