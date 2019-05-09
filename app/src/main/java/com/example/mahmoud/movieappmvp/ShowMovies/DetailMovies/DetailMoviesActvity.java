package com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mahmoud.movieappmvp.R;


public class DetailMoviesActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies_actvity);
        DetailMoviesFragment moviesFragment=new DetailMoviesFragment();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        moviesFragment.setArguments(bundle);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, moviesFragment, "").commit();
        }


    }
}
