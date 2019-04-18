package com.example.denis.podcatch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.denis.podcatch.Adapters.PodcastDetailAdapter;
import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.Models.PodcastResults;
import com.example.denis.podcatch.Network.ApiEndpointInterface;
import com.example.denis.podcatch.Network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PodcastDetailAdapter adapter;
    private String id;

    private static final String TAG = PodcastDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_detail);
        recyclerView = findViewById(R.id.rv_episode);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        Intent intent = getIntent();
        if (intent != null){
            id = intent.getStringExtra("podcast_id");
            makeApiCall(id);
            Log.d(TAG, "onCreate: Api call made");
        }
        Log.d(TAG, "onCreate: podcast id = "+id);

    }

    private void makeApiCall(String id){
        ApiEndpointInterface endpointInterface = RetrofitClientInstance.getRetrofitInstance()
                .create(ApiEndpointInterface.class);
        Call<PodcastResults>  call = endpointInterface.get_podcast_data(id);
        call.enqueue(new Callback<PodcastResults>() {
            @Override
            public void onResponse(@NonNull Call<PodcastResults> call, @NonNull Response<PodcastResults> response) {
                final PodcastResults results = response.body();
                getPodcastEpisodes(results.getEpisodes());
                Log.d(TAG, "onResponse: episodes = "+ results.getEpisodes());

            }

            @Override
            public void onFailure(Call<PodcastResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getPodcastEpisodes(List<Episode> episodes){
        adapter = new PodcastDetailAdapter(this, (ArrayList<Episode>) episodes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
