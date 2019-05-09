package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mahmoud.movieappmvp.R;
import com.example.mahmoud.movieappmvp.ShowMovies.DetailMovies.DetailMoviesActvity;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieDb;
import com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase.MovieInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class CustomAdapterMovies extends RecyclerView.Adapter<CustomAdapterMovies.FilmItemRowHolder> {
    ArrayList<MoviesModel> moviesItem;
    Context mcontext;
    Listener listener;
    String paramity;

    public CustomAdapterMovies(Context mcontext, ArrayList<MoviesModel> moviesItem, Listener listener, String paramity) {
        this.mcontext = mcontext;
        this.moviesItem = moviesItem;
        this.listener = listener;
        this.paramity = paramity;
    }


    @NonNull
    @Override
    public FilmItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_movie, null);
        FilmItemRowHolder filmItemRowHolder = new FilmItemRowHolder(v);
        return filmItemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmItemRowHolder holder, int position) {
        Log.i("kkkkkk", moviesItem.get(position).getPosterPath());
        Picasso.with(mcontext).load("http://image.tmdb.org/t/p/w342/" + moviesItem.get(position).getPosterPath()
        ).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return moviesItem.size();
    }

    public class FilmItemRowHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public FilmItemRowHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            if (paramity.equals("favourite")) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MovieDb mvDb = new MovieDb(mcontext);
                        MovieInfo movieData = mvDb.getMovies(moviesItem.get(getAdapterPosition()).getPosterPath());
                        listener.setFavouriteData(movieData.getPoster_path(), movieData.getTitle(), movieData.getOverview(),
                                movieData.getVote_average(), movieData.getRelease_date(), movieData.getId());

                    }
                });

            } else {

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.setData(moviesItem.get(getAdapterPosition()).getTitle(), moviesItem.get(getAdapterPosition()).getOverview(),
                                moviesItem.get(getAdapterPosition()).getReleaseDate(), moviesItem.get(getAdapterPosition()).getVoteAverage()
                                , moviesItem.get(getAdapterPosition()).getPosterPath(), moviesItem.get(getAdapterPosition()).getId());


                    }
                });
            }

        }
    }
}
