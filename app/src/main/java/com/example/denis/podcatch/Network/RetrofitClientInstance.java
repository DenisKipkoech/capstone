package com.example.denis.podcatch.Network;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://listen-api.listennotes.com/api/v2/";
    private static final String auth_token = "1f46e215466b4f128a49f43bacc5d237";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//            httpClient.addInterceptor(logging);

            Interceptor headerAuthorisationInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Headers headers = request.headers().newBuilder()
                            .add("X-ListenApi-Key", auth_token)
                            .build();
                    request = request.newBuilder().headers(headers).build();

                    return chain.proceed(request);
                }
            };

            httpClient.addInterceptor(headerAuthorisationInterceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
