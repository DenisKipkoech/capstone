package com.example.denis.podcatch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.denis.podcatch.Adapters.SubscriptionsAdapter;
import com.example.denis.podcatch.Database.MainViewModel;
import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.Models.Podcast;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView noSubcriptions;
    private SubscriptionsAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);
        noSubcriptions = findViewById(R.id.tv_no_subscriptions);
        recyclerView = findViewById(R.id.rv_subscriptions);
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SubscriptionsAdapter(this);
        recyclerView.setAdapter(adapter);

        getSubscriptions();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (layoutManager != null){
            listState = layoutManager.onSaveInstanceState();
            outState.putParcelable(Constants.LIST_STATE_KEY, listState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            listState = savedInstanceState.getParcelable(Constants.LIST_STATE_KEY);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listState != null){
            layoutManager.onRestoreInstanceState(listState);
        }
    }

    private void getSubscriptions(){
        MainViewModel viewModel  = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getPodcasts().observe(this, new Observer<List<Podcast>>() {
            @Override
            public void onChanged(@Nullable List<Podcast> podcasts) {
                if (podcasts!= null){
                    adapter.setPodcasts((ArrayList<Podcast>) podcasts);
                }else {
                    noSubcriptions.setText(R.string.no_subscriptions);
                }
            }
        });
    }


}
