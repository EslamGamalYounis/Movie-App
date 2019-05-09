package com.example.mahmoud.movieappmvp.ShowMovies.Reviews;

import android.util.Log;

import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.ClientRetrofit;
import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.MainPresenter;
import com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class RmainPresenter implements ContractReviews.IRmainPresenter {
    ContractReviews.IRview mIRview;


    public RmainPresenter(ContractReviews.IRview mIRview) {
        this.mIRview = mIRview;

    }


    @Override
    public void loadData() {
        ReviewRetrofit mReviewRetrofit = ClientRetrofit.getInstance(mIRview.recieveInent().getStringExtra("id"))
                .create(ReviewRetrofit.class);
        Call<ModelR> connection = mReviewRetrofit.getData();
        connection.enqueue(new Callback<ModelR>() {
            @Override
            public void onResponse(Call<ModelR> call, Response<ModelR> response) {

                ModelR model = response.body();
                mIRview.recievedata(model.ReviewsList());


            }

            @Override
            public void onFailure(Call<ModelR> call, Throwable t) {

            }
        });
    }


    interface ReviewRetrofit {
        @GET("reviews?api_key=7826714bce33155200adb2a059306594")
        Call<ModelR> getData();
    }
}
