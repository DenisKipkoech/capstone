package com.example.denis.podcatch;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Service.AudioPlayerService;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class EpisodePlayerActivity extends AppCompatActivity {
    private PlayerControlView playerControlView;
    private SimpleExoPlayer player;
    private ImageView posterView;
    private TextView titleView;

    private Episode episode;
    private boolean mBound;
    private AudioPlayerService playerService;
    private AdView adView;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AudioPlayerService.LocalBinder localBinder = (AudioPlayerService.LocalBinder) service;
            playerService = localBinder.getService();
            mBound = true;
            initializePlayer();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_player);
        Intent intent = getIntent();
        if (intent != null) {
            episode = intent.getParcelableExtra(Constants.EPISODE_KEY);
            setUI(episode);
        }
        adView = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
    }

    private void initializePlayer(){
        if (mBound){
            player = playerService.getPlayer();
            playerControlView.setPlayer(player);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent serviceintent = new Intent(EpisodePlayerActivity.this,
                AudioPlayerService.class);
        serviceintent.putExtra(Constants.EPISODE_KEY, episode);
        startService(serviceintent);
        bindService(serviceintent, connection, Context.BIND_AUTO_CREATE);
        initializePlayer();
        setUI(episode);
    }

    @Override
    protected void onStop() {
        unbindService(connection);
        mBound = false;
        super.onStop();
    }

    private void setUI(Episode episode){
        posterView = findViewById(R.id.podcast_poster);
        playerControlView = findViewById(R.id.player_control_view);
        titleView = findViewById(R.id.tv_episode_title);
        if (episode.getImage() != null) {
            Picasso.with(this)
                    .load(episode.getImage())
                    .into(posterView);
        }
        titleView.setText(episode.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share){
            startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setText("Episode listennotes Url: "+episode.getListennotesUrl())
                    .getIntent(), getString(R.string.share)));
        }
        return super.onOptionsItemSelected(item);
    }
}
