package com.example.denis.podcatch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.podcatch.Adapters.PodcastDetailAdapter;
import com.example.denis.podcatch.Database.AppDatabase;
import com.example.denis.podcatch.Database.AppExecutors;
import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.Models.PodcastResults;
import com.example.denis.podcatch.Network.ApiEndpointInterface;
import com.example.denis.podcatch.Network.RetrofitClientInstance;
import com.example.denis.podcatch.Service.AudioPlayerService;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastDetailActivity extends AppCompatActivity implements PodcastDetailAdapter.ItemClickListener{
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;
    private PodcastDetailAdapter adapter;
    private List<Episode> episodes = null;
    private Button subButton;
    private ImageView posterView;
    private TextView titleView;
    private AppDatabase database;
    private SharedPreferences preferences;
    private boolean issubscribed;
    private String podcastUrl;


    private static final String TAG = PodcastDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_detail);
        subButton = findViewById(R.id.bt_subscribe);
        posterView = findViewById(R.id.imageView);
        titleView = findViewById(R.id.tv_podcast_title);
        preferences = this.getSharedPreferences(Constants.MY_PREFERENCE, MODE_PRIVATE);
        database = AppDatabase.getInstance(this);

        recyclerView = findViewById(R.id.rv_episode);
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        if (intent != null){
            Podcast podcast = intent.getParcelableExtra(Constants.PODCAST_KEY);
            Picasso.with(this)
                    .load(podcast.getImage())
                    .into(posterView);
            titleView.setText(podcast.getTitle());
            issubscribed = preferences.getBoolean(podcast.getId(), false);
            if (issubscribed){subButton.setText(R.string.unsubscribe);}
            makeApiCall(podcast.getId());
            Log.d(TAG, "onCreate: Api call made");

            subButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!issubscribed){
                        addPodcastToSubscription(podcast);
                        subButton.setText(R.string.unsubscribe);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean(podcast.getId(), true);
                        editor.commit();
                    }else {
                        removePodcastFromSubscription(podcast);
                        subButton.setText(R.string.subscribe);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean(podcast.getId(), false);
                        editor.commit();
                    }

                }
            });

        }


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

    private void makeApiCall(String id){
        ApiEndpointInterface endpointInterface = RetrofitClientInstance.getRetrofitInstance()
                .create(ApiEndpointInterface.class);
        Call<PodcastResults>  call = endpointInterface.get_podcast_data(id);
        call.enqueue(new Callback<PodcastResults>() {
            @Override
            public void onResponse(@NonNull Call<PodcastResults> call, @NonNull Response<PodcastResults> response) {
                final PodcastResults results = response.body();
                podcastUrl = "Podcast listennotes url: "+
                        String.valueOf(results.getListennotesUrl());
                episodes = results.getEpisodes();
                getPodcastEpisodes(episodes);
                Log.d(TAG, "onResponse: episodes = "+ results.getEpisodes());

            }

            @Override
            public void onFailure(Call<PodcastResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getPodcastEpisodes(List<Episode> episodes){
        adapter = new PodcastDetailAdapter(this, (ArrayList<Episode>) episodes, this);
        recyclerView.setAdapter(adapter);
    }

    private void addPodcastToSubscription(Podcast podcast){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                database.PodcastDao().insertPodcast(podcast);
            }
        });
    }

    private void removePodcastFromSubscription(Podcast podcast){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                database.PodcastDao().deletePodcast(podcast);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share){
            startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(getParent())
            .setType("text/plain")
            .setText(podcastUrl)
            .getIntent(), getString(R.string.share)));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClickListener(Episode episode) {
        Intent intent = new Intent(PodcastDetailActivity.this,
                EpisodePlayerActivity.class);
        intent.putExtra(Constants.EPISODE_KEY, episode);
        startActivity(intent);
    }

}
