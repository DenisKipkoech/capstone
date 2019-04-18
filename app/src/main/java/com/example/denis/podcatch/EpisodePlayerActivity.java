package com.example.denis.podcatch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.denis.podcatch.Models.Constants;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class EpisodePlayerActivity extends AppCompatActivity {
    private PlayerControlView playerControlView;
    private SimpleExoPlayer player;
    boolean playWhenReady;
    int currentWindow = 0;
    long playBackPosition = 0;
    private String URL;

    private static final String TAG = EpisodePlayerActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_player);

        playerControlView = findViewById(R.id.player_control_view);

        Intent intent = getIntent();
        if (intent != null){
            URL = intent.getStringExtra(Constants.AUDIO_URL_KEY);
            Log.d(TAG, "onCreate: Audio Url = "+URL);
        }
    }

    private void initializePlayer(){
        player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this),
                new DefaultTrackSelector(), new DefaultLoadControl());
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playBackPosition);
        playerControlView.setPlayer(player);

        if (URL != null){
            MediaSource mediaSource  = buildMediaSource(Uri.parse(URL));
            player.prepare(mediaSource, true, false);
        }
    }

    private MediaSource buildMediaSource(Uri uri){
        return new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("PC")
        ).createMediaSource(uri);
    }

    private void releasePlayer(){
        if (player != null){
            playBackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Util.SDK_INT > 23 || player == null) {
            initializePlayer();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }
}
