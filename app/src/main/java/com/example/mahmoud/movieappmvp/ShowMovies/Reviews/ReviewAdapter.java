package com.example.mahmoud.movieappmvp.ShowMovies.Reviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud.movieappmvp.R;


import java.util.ArrayList;

class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.FilmItemRowHolder> {
    ArrayList<ModelReviews> reviewsModels;
    Context mcontext;

    public ReviewAdapter(Context mcontext, ArrayList<ModelReviews> reviewsModels) {
        this.mcontext = mcontext;
        this.reviewsModels = reviewsModels;
    }

    @Override
    public ReviewAdapter.FilmItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_info, null);
        ReviewAdapter.FilmItemRowHolder ALRH = new ReviewAdapter.FilmItemRowHolder(v);
        return ALRH;

    }

    @Override
    public void onBindViewHolder(ReviewAdapter.FilmItemRowHolder holder, int position) {
        holder.reviewAuthor.setText(reviewsModels.get(position).getAuthor());
        holder.reviewContent.setText(reviewsModels.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        Log.i("size", reviewsModels.size() + "");
        return reviewsModels.size();
    }

    public class FilmItemRowHolder extends RecyclerView.ViewHolder {
        TextView reviewAuthor;
        TextView reviewContent;

        public FilmItemRowHolder(View itemView) {
            super(itemView);
            reviewAuthor = (TextView) itemView.findViewById(R.id.author);
            reviewContent = (TextView) itemView.findViewById(R.id.content);


        }
    }


}

