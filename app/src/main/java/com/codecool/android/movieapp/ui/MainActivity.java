package com.codecool.android.movieapp.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.codecool.android.movieapp.R;
import com.codecool.android.movieapp.adapters.MoviesAdapter;
import com.codecool.android.movieapp.models.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    //RecyclerView rvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

        setupMVP();
        setupViews();
        getMovieList();
    }



    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList() {

        mainPresenter.getMovies();

    }



    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this,str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayMovies(MovieResponse movieResponse) {
        if(movieResponse!=null) {
            Log.d(TAG,movieResponse.getResults().get(1).getTitle());
            adapter = new MoviesAdapter(movieResponse.getResults(), MainActivity.this);
            rvMovies.setAdapter(adapter);
        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);

    }


}