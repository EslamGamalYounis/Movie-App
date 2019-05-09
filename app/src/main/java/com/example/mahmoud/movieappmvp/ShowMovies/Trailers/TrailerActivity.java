package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mahmoud.movieappmvp.R;
import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.ModelReviews;

import java.util.ArrayList;

public class TrailerActivity extends AppCompatActivity implements ContractTrailers.IRview {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        recyclerView = (RecyclerView) findViewById(R.id.list);

        TmainPresenter mTmainPresenter = new TmainPresenter(this);
        mTmainPresenter.loadData();

    }


    @Override
    public void recievedata(ArrayList<trailersModel> trailersModels) {
        TrailerAdapter moviesAdapter = new TrailerAdapter(this, trailersModels);
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        moviesAdapter.notifyDataSetChanged();

    }

    @Override
    public Intent recieveInent() {
        return getIntent();
    }
}
