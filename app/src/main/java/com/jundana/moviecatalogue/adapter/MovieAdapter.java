package com.jundana.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jundana.moviecatalogue.model.Movie;
import com.jundana.moviecatalogue.MovieDetailActivity;
import com.jundana.moviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {
    private Context mCtx;
    private ArrayList<Movie> listMovie;

    public MovieAdapter(Context context, ArrayList<Movie> list){
        this.mCtx = context;
        this.listMovie = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int position) {
        Movie movies = listMovie.get(position);
        Glide.with(listViewHolder.itemView.getContext())
                .load(movies.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(listViewHolder.imgPhoto);
        listViewHolder.tvItemName.setText(movies.getMovieName());
        listViewHolder.tvItemDetail.setText(movies.getMovieDetail());
    }
    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvItemName, tvItemDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
            tvItemDetail = itemView.findViewById(R.id.tv_item_detail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movies = listMovie.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, MovieDetailActivity.class);
            intent.putExtra("MOVIE", movies);
            mCtx.startActivity(intent);
        }
    }
}
