package com.example.denis.podcatch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.denis.podcatch.Adapters.MainAdapter;
import com.example.denis.podcatch.Models.Category;
import com.example.denis.podcatch.Models.Results;
import com.example.denis.podcatch.Network.ApiEndpointInterface;
import com.example.denis.podcatch.Network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_parent);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));


        makeApiCall();
        Log.d(TAG, "onCreate: api call made");
    }

    private void makeApiCall(){
        ApiEndpointInterface endpointInterface = RetrofitClientInstance.getRetrofitInstance()
                .create(ApiEndpointInterface.class);

        Call<Results> call = endpointInterface.get_curated_podcasts(1);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(@NonNull Call<Results> call, @NonNull Response<Results> response) {
                Log.d(TAG, "onResponse: method called");
                final Results results = response.body();
                getPodcastCategories(results.getCategories());
                Log.d(TAG, "onResponse: results = "+results);
                Log.d(TAG, "onResponse: response"+response.body());
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getPodcastCategories(List<Category> categories){
        Log.d(TAG, "getPodcastCategories: method called");
        adapter = new MainAdapter(this, (ArrayList<Category>) categories);
        recyclerView.setAdapter(adapter);
    }
}
