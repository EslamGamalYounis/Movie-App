package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRetrofit {
    private static Retrofit ourInstance;

    private ClientRetrofit() {
    }

    public static Retrofit getInstance(String id) {
        ourInstance = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/" + id + "/").
                addConverterFactory(GsonConverterFactory.create(new Gson())).build();


        return ourInstance;
    }


}
