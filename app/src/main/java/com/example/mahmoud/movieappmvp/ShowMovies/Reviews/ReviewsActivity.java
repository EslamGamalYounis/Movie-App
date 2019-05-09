package com.example.mahmoud.movieappmvp.ShowMovies.Reviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mahmoud.movieappmvp.R;

import java.util.ArrayList;

public class ReviewsActivity extends AppCompatActivity implements ContractReviews.IRview {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        RmainPresenter mRmainPresenter = new RmainPresenter(this);
        mRmainPresenter.loadData();

    }

    @Override
    public void recievedata(ArrayList<ModelReviews> reviewsModels) {

        ReviewAdapter mReviewAdapter = new ReviewAdapter(this, reviewsModels);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mReviewAdapter);
        mReviewAdapter.notifyDataSetChanged();

    }

    @Override
    public Intent recieveInent() {
        return getIntent();
    }
}
