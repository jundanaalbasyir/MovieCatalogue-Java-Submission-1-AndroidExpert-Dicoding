package com.jundana.moviecatalogue;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jundana.moviecatalogue.model.Movie;

import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView imgPhoto;
    TextView tvItemDetail;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("ResourceType")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        imgPhoto = findViewById(R.id.img_item_photo);
        tvItemDetail = findViewById(R.id.tv_item_detail);

        Intent intent = getIntent();
        Movie getMovie = intent.getParcelableExtra("MOVIE");

        int photo = Objects.requireNonNull(getMovie).getPhoto();
        String movieName = getMovie.getMovieName();
        String movieDetail = getMovie.getMovieDetail();

        Glide.with(this).load(photo).into(imgPhoto);
        collapsingToolbar.setTitle(movieName);
        collapsingToolbar.setExpandedTitleColor(Color.BLACK);
        tvItemDetail.setText(movieDetail);
    }
}
