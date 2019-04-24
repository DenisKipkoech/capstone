package com.example.denis.podcatch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.denis.podcatch.Adapters.SubscriptionsAdapter;
import com.example.denis.podcatch.Database.MainViewModel;
import com.example.denis.podcatch.Models.Podcast;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SubscriptionsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);
        recyclerView = findViewById(R.id.rv_subscriptions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        adapter = new SubscriptionsAdapter(this);
        recyclerView.setAdapter(adapter);

        getSubscriptions();
    }

    private void getSubscriptions(){
        MainViewModel viewModel  = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getPodcasts().observe(this, new Observer<List<Podcast>>() {
            @Override
            public void onChanged(@Nullable List<Podcast> podcasts) {
                if (podcasts!= null){
                    adapter.setPodcasts((ArrayList<Podcast>) podcasts);
                }
            }
        });


    }
}
