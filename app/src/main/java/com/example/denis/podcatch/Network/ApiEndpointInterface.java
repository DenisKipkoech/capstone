package com.example.denis.podcatch.Network;


import com.example.denis.podcatch.Models.PodcastResults;
import com.example.denis.podcatch.Models.Results;
import com.example.denis.podcatch.Models.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpointInterface {
    @GET("curated_podcasts")
    Call<Results> get_curated_podcasts(
            @Query("page") int page
    );

    @GET("podcasts/{id}")
    Call<PodcastResults> get_podcast_data(
            @Path("id") String id
    );

    @GET("search")
    Call<SearchResult> getSearch(
            @Query("q") String search
    );

}
