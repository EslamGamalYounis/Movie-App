package com.example.mahmoud.movieappmvp.ShowMovies.MoviesDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieDb extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DBName = "favorites";

    public MovieDb(Context context) {

        super(context, DBName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS favorites (id TEXT primary key,url TEXT,date TEXT,rate TEXT,description TEXT,title TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addMovie(int id, String url, String date, String rate, String description, String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("url", url);
        contentValues.put("date", date);
        contentValues.put("rate", rate);
        contentValues.put("description", description);
        contentValues.put("title", title);

        db.insert("favorites", null, contentValues);
        db.close();
    }

    public ArrayList<MovieInfo> getAllMovies() {

        int i = 0;
        int res_id;
        String res_url, res_date, res_rate, res_description, res_title;
        MovieInfo movieInfo[] = new MovieInfo[getMoviesCount()];
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from favorites", null);
        res.moveToFirst();
        //Log.d("Size l array kollo " , String.valueOf(movieInfo.length));

        while (!res.isAfterLast()) {
            res_id = res.getInt(res.getColumnIndex("id"));
            res_url = res.getString(res.getColumnIndex("url"));
            res_date = res.getString(res.getColumnIndex("date"));
            res_rate = res.getString(res.getColumnIndex("rate"));
            res_description = res.getString(res.getColumnIndex("description"));
            res_title = res.getString(res.getColumnIndex("title"));
            if (i == movieInfo.length)
                break;


            movieInfo[i] = new MovieInfo(res_url, res_description, res_date, res_id, "", res_title, "", 0.0, 0, res_rate);

            res.moveToNext();

            i++;


        }

        return new ArrayList<MovieInfo>(Arrays.asList(movieInfo));

    }

    public int getMoviesCount() {

        String countQuery = "SELECT * FROM favorites";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        db.close();
        return cnt;
    }


    public boolean isfavourite_movie(String movie_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from favorites where title = \"" + movie_name + "\" ;", null);
        res.moveToFirst();

        if (!res.isAfterLast()) {
            res.moveToNext();

            return true;


        }


        return false;

    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from favorites");

    }

    public MovieInfo getMovies(String url) {

        MovieInfo mvInfo = new MovieInfo();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from favorites where url = \"" + url + "\" ;", null);
        res.moveToFirst();

        if (!res.isAfterLast()) {
            mvInfo.setId(res.getInt(res.getColumnIndex("id")));
            mvInfo.setPoster_path(res.getString(res.getColumnIndex("url")));
            mvInfo.setRelease_date(res.getString(res.getColumnIndex("date")));
            mvInfo.setVote_average(res.getString(res.getColumnIndex("rate")));
            mvInfo.setOverview(res.getString(res.getColumnIndex("description")));
            mvInfo.setTitle(res.getString(res.getColumnIndex("title")));


            res.moveToNext();


        }

        return mvInfo;

    }


}

