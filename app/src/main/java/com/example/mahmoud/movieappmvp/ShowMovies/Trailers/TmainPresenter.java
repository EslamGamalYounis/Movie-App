package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import android.util.Log;

import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.ModelR;
import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.RmainPresenter;
import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.ClientRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class TmainPresenter implements ContractTrailers.IRmainPresenter {
    TrailerRetrofit retrofitrailer;
    ContractTrailers.IRview mIView;
    String id;


    public TmainPresenter(ContractTrailers.IRview mIView) {
        this.mIView = mIView;

    }

    @Override
    public void loadData() {
        TrailerRetrofit mTrailerRetrofit = ClientRetrofit.getInstance(mIView.recieveInent().getStringExtra("id"))
                .create(TrailerRetrofit.class);
        Call<ModelTrailer> connection = mTrailerRetrofit.getKeys();
        connection.enqueue(new Callback<ModelTrailer>() {
            @Override
            public void onResponse(Call<ModelTrailer> call, Response<ModelTrailer> response) {

                ModelTrailer model = response.body();
                mIView.recievedata(model.gettrailersList());


            }

            @Override
            public void onFailure(Call<ModelTrailer> call, Throwable t) {

            }
        });
    }


    interface TrailerRetrofit {

        @GET("videos?api_key=7826714bce33155200adb2a059306594")
        Call<ModelTrailer> getKeys();
    }

}
