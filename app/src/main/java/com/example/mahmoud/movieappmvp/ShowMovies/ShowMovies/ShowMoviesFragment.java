package com.example.mahmoud.movieappmvp.ShowMovies.ShowMovies;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahmoud.movieappmvp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowMoviesFragment extends Fragment implements Contract.Iview {

    RecyclerView mRecyclerView;
    MainPresenter mainPresenter;
    Listener listener;
    Toolbar toolbar;
    AppCompatActivity mActivity;

    public ShowMoviesFragment() {
        // Required empty public constructor
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.show_movies_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleMovieList);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Show Movies");
        mActivity = (AppCompatActivity) getActivity();
        mActivity.setSupportActionBar(toolbar);
        Log.i("bbbbb", "yyyyy");

        mainPresenter = new MainPresenter(this, getActivity());
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        mainPresenter.checkFilms();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(getActivity(), Setting.class));
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void recieveData(ArrayList<MoviesModel> arr, String paramity) {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        CustomAdapterMovies mCustomAdapter = new CustomAdapterMovies(getActivity(), arr, listener, paramity);
        mRecyclerView.setAdapter(mCustomAdapter);

    }
}
