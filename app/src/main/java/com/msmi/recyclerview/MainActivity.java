package com.msmi.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.msmi.recyclerview.adapter.MovieAdapter;
import com.msmi.recyclerview.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieAdapter adapter;
    RecyclerView rv;
    List<MovieModel> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    public void initRecyclerView() {
        adapter = new MovieAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();

        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(MainActivity.this, DetailMovieActivity.class);
                i.putExtra("name", listMovie.get(position).getName());
                i.putExtra("rating", listMovie.get(position).getRating());
                i.putExtra("jadwal", listMovie.get(position).getJadwal());
                i.putExtra("deskripsi", listMovie.get(position).getDesCription());
            }
        });
        loadItem();
    }

    public void loadItem() {
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Avatar", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Batman", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Boboiboy", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Superman", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : One Piece", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Thor", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Danur", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Pocong", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Kuntilanak", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Tuyul", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        listMovie.add(new MovieModel("Nama : Kuyang", "Rating : 4.5", "Jadwal tayang : 17:00 - 20:00", "DEscription"));
        adapter.addAll(listMovie);
    }
}
