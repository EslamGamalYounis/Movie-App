package com.example.mahmoud.movieappmvp.ShowMovies.Trailers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mahmoud.movieappmvp.R;

import java.util.ArrayList;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.FilmItemRowHolder> {
    ArrayList<trailersModel> trialers;
    Context mcontext;

    public TrailerAdapter(Context mcontext, ArrayList<trailersModel> moviesItem) {
        this.mcontext = mcontext;
        this.trialers = moviesItem;
    }

    @Override
    public TrailerAdapter.FilmItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_row, null);
        TrailerAdapter.FilmItemRowHolder ALRH = new TrailerAdapter.FilmItemRowHolder(v);
        return ALRH;

    }

    @Override
    public void onBindViewHolder(TrailerAdapter.FilmItemRowHolder holder, int position) {
        int number = position + 1;
        holder.trailerNum.setText("Trailer" + number);
    }

    @Override
    public int getItemCount() {
        Log.i("size", trialers.size() + "");
        return trialers.size();
    }

    public class FilmItemRowHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView trailerNum;

        public FilmItemRowHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.trailerNum = (TextView) itemView.findViewById(R.id.txtTrailer);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(BuildTrailerUrl(trialers.get(getAdapterPosition()).getKey()));
                    intent.setData(uri);

                    mcontext.startActivity(intent);


                }
            });

        }
    }

    public static String BuildTrailerUrl(String trailerKey) {
        Uri uri = Uri.parse("https://www.youtube.com/watch").buildUpon().appendQueryParameter("v", trailerKey).build();
        Log.i("uri", uri.toString());
        return uri.toString();
    }

}

