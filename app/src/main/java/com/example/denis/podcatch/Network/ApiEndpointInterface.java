package com.example.denis.podcatch.Network;

import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.Models.Results;

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
    Call<Podcast> get_podcast_data(
            @Path("id") String id
    );

}
