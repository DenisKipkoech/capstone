package com.example.denis.podcatch.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.denis.podcatch.Models.Podcast;

import java.util.List;

@Dao
public interface PodcastDao {
    @Query("SELECT * FROM podcast")
    LiveData<List<Podcast>> loadAllPodcasts();

    @Insert
    void insertPodcast(Podcast podcast);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePodcast(Podcast podcast);

    @Delete
    void deletePodcast(Podcast podcast);

    @Query("SELECT * FROM podcast WHERE id = :id")
    Podcast loadPoadcastById(int id);
}
