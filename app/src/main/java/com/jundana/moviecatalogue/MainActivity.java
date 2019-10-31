package com.jundana.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jundana.moviecatalogue.adapter.MovieAdapter;
import com.jundana.moviecatalogue.helper.MoviesData;
import com.jundana.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        MovieAdapter listMovieAdapter = new MovieAdapter(this, list);
        rvMovies.setAdapter(listMovieAdapter);
    }
}
