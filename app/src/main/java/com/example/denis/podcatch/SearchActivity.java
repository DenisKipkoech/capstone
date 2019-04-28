package com.example.denis.podcatch;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.denis.podcatch.Adapters.SearchAdapter;
import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.Models.Search;
import com.example.denis.podcatch.Models.SearchResult;
import com.example.denis.podcatch.Network.ApiEndpointInterface;
import com.example.denis.podcatch.Network.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private TextView noResult;
    private SearchAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        noResult = findViewById(R.id.tv_no_search);
        recyclerView = findViewById(R.id.rv_search);
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        if (intent != null) {
            String query = intent.getStringExtra(Constants.QUERY_KEY);
            makeSearch(query);

        }


    }

    private void makeSearch(String searchQuery){
        ApiEndpointInterface endpointInterface = RetrofitClientInstance.getRetrofitInstance()
                .create(ApiEndpointInterface.class);
        Call<SearchResult> searchCall = endpointInterface.getSearch(searchQuery);
        searchCall.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(@NonNull Call<SearchResult> call, @NonNull Response<SearchResult> response) {
                final SearchResult searchResult = response.body();

                ArrayList<Search> episodes = (ArrayList<Search>) searchResult.getEpisodes();
                if (episodes == null){
                    setNoResult();
                }else {
                    getSearchResults(episodes);

                }

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getSearchResults(ArrayList<Search> results){
        adapter = new SearchAdapter(this, results,this);
        recyclerView.setAdapter(adapter);
    }

    private void setNoResult(){
        noResult.setText(R.string.no_search_results);
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

    @Override
    public void onItemClickListener(Episode episode) {
        Intent intent = new Intent(SearchActivity.this, EpisodePlayerActivity.class);
        intent.putExtra(Constants.EPISODE_KEY, episode);
        startActivity(intent);
    }
}
