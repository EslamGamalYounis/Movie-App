package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.mahmoud.movieappmvp.R;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieDb;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainPresenter implements Contract.ImainPresenter {
    Contract.Iview mIview;
    Contract.Imodel imodel;
    Context mContext;
    String parmarity = "popular";
    ArrayList<String> data_poster = new ArrayList<String>();
    ArrayList<MoviesModel> modelData = new ArrayList<MoviesModel>();

    ArrayList<MovieInfo> favourits = new ArrayList<MovieInfo>();

    public MainPresenter(Contract.Iview mIview, Context mContext) {
        this.mIview = mIview;
        this.imodel = new Model();
        this.mContext = mContext;

    }


    @Override
    public void loadData(String FilmsType) {

        if (parmarity.equals("favourite")) {


            MovieDb dp = new MovieDb(mContext);
            favourits.clear();

            favourits = dp.getAllMovies();
            modelData.clear();

            for (int i = 0; i < favourits.size(); i++) {
                MoviesModel moviesModel = new MoviesModel();
                moviesModel.setId(favourits.get(i).getId() + "");
                moviesModel.setTitle(favourits.get(i).getTitle());
                moviesModel.setPosterPath(favourits.get(i).getPoster_path());
                moviesModel.setReleaseDate(favourits.get(i).getRelease_date());
                moviesModel.setOverview(favourits.get(i).getOverview());
                moviesModel.setVoteAverage(favourits.get(i).getVote_average());
                modelData.add(moviesModel);
            }

            mIview.recieveData(modelData, parmarity);

        } else {

            RMovies rMovies = ClientRetrofit.getInstance(FilmsType).create(RMovies.class);

            Call<Model> connection = rMovies.getposts();

            connection.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    Log.i("zzzzzzzzz", model.getData().get(1).getPosterPath());
                    mIview.recieveData(model.getData(), parmarity);


                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText(mContext, "please check your internet", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    @Override
    public void checkFilms() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        parmarity = sharedPreferences.getString(mContext.getString(R.string.sort_key), "popular");
        loadData(parmarity);

    }



    public interface RMovies {

        @GET("?api_key=774c9627467113733738773c9c96c8c8")
        Call<Model> getposts();


    }
}
