package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mahmoud.movieappmvp.R;
import com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies.DetailMoviesActvity;
import com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies.DetailMoviesFragment;

public class ShowMoviesActivity extends AppCompatActivity implements Listener {

    Boolean checkTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowMoviesFragment mainFragment = new ShowMoviesFragment();
        mainFragment.setListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.movies, mainFragment, "").commit();
        }
        if (findViewById(R.id.fldetail) != null) {
            checkTwoPane = true;
        }
    }

    @Override
    public void setData(String original_title, String overview, String release_date, String vote_average, String poster_path, String id) {
        if (!checkTwoPane) {
            Intent detail = new Intent(this, DetailMoviesActvity.class);
            detail.putExtra("original_title", original_title);
            detail.putExtra("overview", overview);
            detail.putExtra("release_date", release_date);
            detail.putExtra("vote_average", vote_average);
            detail.putExtra("poster_path", poster_path);
            detail.putExtra("favourite_color", "black");
            detail.putExtra("id", id);
            startActivity(detail);

        } else {
            DetailMoviesFragment movieDetailFragment = new DetailMoviesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("original_title", original_title);
            bundle.putString("overview", overview);
            bundle.putString("release_date", release_date);
            bundle.putString("vote_average", vote_average);
            bundle.putString("poster_path", poster_path);
            bundle.putString("id", id);
            bundle.putString("favourite_color", "black");
            movieDetailFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fldetail, movieDetailFragment).commit();


        }
    }

    @Override
    public void setFavouriteData(String posterpath, String title, String description, String vote, String date, int filmid) {

        if (!checkTwoPane) {
            Intent detail = new Intent(this, DetailMoviesActvity.class);
            detail.putExtra("original_title", title);
            detail.putExtra("overview", description);
            detail.putExtra("release_date", date);
            detail.putExtra("vote_average", vote);
            detail.putExtra("poster_path", posterpath);
            detail.putExtra("id", filmid + "");
            detail.putExtra("favourite_color", "red");
            startActivity(detail);

        } else {
            DetailMoviesFragment movieDetailFragment = new DetailMoviesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("original_title", title);
            bundle.putString("overview", description);
            bundle.putString("release_date", date);
            bundle.putString("vote_average", vote);
            bundle.putString("poster_path", posterpath);
            bundle.putString("id", filmid + "");
            bundle.putString("favourite_color", "red");
            movieDetailFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fldetail, movieDetailFragment).commit();
        }
    }
}
