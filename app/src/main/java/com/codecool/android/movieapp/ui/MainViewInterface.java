package com.codecool.android.movieapp.ui;

import com.codecool.android.movieapp.models.MovieResponse;

public interface MainViewInterface {

    void showToast(String s);
    void displayMovies(MovieResponse movieResponse);
    void displayError(String s);
}