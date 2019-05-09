package com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.movieappmvp.R;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieDb;
import com.example.mahmoud.movieappmvp.ShowMovies.Reviews.ReviewsActivity;
import com.example.mahmoud.movieappmvp.ShowMovies.Trailers.TrailerActivity;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMoviesFragment extends Fragment implements ContractDetail.IDview {
    TextView title, releaseDate, voteAverage, dsccription, trailerAct;
    ImageView imageView;
    Button review, trailer, favorite, favouriteColor;
    Toolbar toolbar;
    AppCompatActivity mActivity;
    String titl, vote, overview, poster, date;

    public DetailMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_movies, container, false);
        title = (TextView) view.findViewById(R.id.movieMame);
        imageView = (ImageView) view.findViewById(R.id.imag);
        voteAverage = (TextView) view.findViewById(R.id.vote);
        dsccription = (TextView) view.findViewById(R.id.description);
        releaseDate = (TextView) view.findViewById(R.id.date);
        review = (Button) view.findViewById(R.id.revew_btn);
        trailer = (Button) view.findViewById(R.id.trailer_btn);
        favorite = (Button) view.findViewById(R.id.color_favourite);
        trailerAct = (TextView) view.findViewById(R.id.color_favourite);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        favouriteColor = (Button) view.findViewById(R.id.color_favourite);
        toolbar.setTitle("Movie Detail");
        mActivity = (AppCompatActivity) getActivity();
        mActivity.setSupportActionBar(toolbar);
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setHomeButtonEnabled(true);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DmainPresenter dmainPresenter = new DmainPresenter(this, getActivity());
        dmainPresenter.loadData();
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToReview();
            }
        });
        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTrailer();
            }
        });

        MovieDb dp = new MovieDb(getActivity());
        if (dp.isfavourite_movie(titl)) {
            favouriteColor.setTextColor(getResources().getColor(R.color.red));
        }
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MovieDb dp = new MovieDb(getActivity());
                if (dp.isfavourite_movie(titl)) {
                    Toast.makeText(getActivity(), "has added before ", Toast.LENGTH_LONG).show();

                } else {
                    favouriteColor.setTextColor(getResources().getColor(R.color.red));
                    dp.addMovie(Integer.parseInt(getActivity().getIntent().getStringExtra("id")), poster, date, vote, overview, titl);
                    Toast.makeText(getActivity(), "Added to favourite", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    @Override
    public void goToTrailer() {
        Intent intent = new Intent(getActivity(), TrailerActivity.class);

        intent.putExtra("id", getActivity().getIntent().getStringExtra("id"));
        startActivity(intent);
    }

    @Override
    public void goToReview() {
        Intent intent = new Intent(getActivity(), ReviewsActivity.class);
        intent.putExtra("id", getActivity().getIntent().getStringExtra("id"));
        startActivity(intent);

    }

    @Override
    public void getDetail_films(String title, String vote, String overview, String poster, String date, String favourite_color) {
        this.title.setText(title);
        voteAverage.setText(vote);
        dsccription.setText(overview);
        releaseDate.setText(date);
        Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w342/" + poster).into(imageView);

        this.titl = title;
        this.vote = vote;
        this.overview = overview;
        this.poster = poster;
        this.date = date;
        if (favourite_color.equals("red")) {
            favouriteColor.setTextColor(getResources().getColor(R.color.red));
        } else {
            favouriteColor.setTextColor(getResources().getColor(R.color.black));

        }
    }

    @Override
    public Bundle recieveIntent() {
        return getArguments();
    }
}
