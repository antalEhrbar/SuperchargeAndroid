package com.codecool.android.movieapp.network;

import android.database.Observable;

import com.codecool.android.movieapp.models.MovieResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("discover/movie")
    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);
}