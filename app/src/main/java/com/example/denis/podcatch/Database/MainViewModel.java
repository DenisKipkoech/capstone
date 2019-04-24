package com.example.denis.podcatch.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.denis.podcatch.Models.Podcast;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private LiveData<List<Podcast>> podcasts;
    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase appDatabase = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the Podcasts from the DataBase");
        podcasts = appDatabase.PodcastDao().loadAllPodcasts();

    }

    public LiveData<List<Podcast>> getPodcasts(){
        return podcasts;
    }
}
