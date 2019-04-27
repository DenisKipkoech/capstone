package com.example.denis.podcatch.Service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.denis.podcatch.MainActivity;
import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.R;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;

import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import okhttp3.internal.Util;

public class AudioPlayerService extends Service {
    private SimpleExoPlayer player;
    private Uri url;
    private String title;
    private PlayerNotificationManager playerNotificationManager;
    private Episode episode;
    private final IBinder iBinder = new LocalBinder();

    private static final String TAG = AudioPlayerService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        episode = intent.getParcelableExtra(Constants.EPISODE_KEY);
        if (player == null) {
            initialisePlayer(this, episode);
        }else{
            releasePlayer();
            initialisePlayer(this, episode);
        }

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    private void initialisePlayer(Context context, Episode episode){
        title = episode.getTitle();
        url = Uri.parse(episode.getAudio());

        player = ExoPlayerFactory.newSimpleInstance(context, new DefaultTrackSelector());
        DefaultHttpDataSourceFactory dataSourceFactory =
                new DefaultHttpDataSourceFactory("podcast");
        MediaSource mediaSource = buildMediaSource(url);
        player.prepare(mediaSource, true, false);
        player.setPlayWhenReady(true);

        playerNotificationManager = PlayerNotificationManager.createWithNotificationChannel(
                this, Constants.PLAYBACK_CHANNEL_ID, R.string.playback_channel_name,
                Constants.PLAYBACK_NOTIFICATION_ID,
                new PlayerNotificationManager.MediaDescriptionAdapter() {
                    @Override
                    public String getCurrentContentTitle(Player player) {
                        return title;
                    }

                    @Nullable
                    @Override
                    public PendingIntent createCurrentContentIntent(Player player) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        return PendingIntent.getActivity(getApplicationContext(), 0,
                                intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    }

                    @Nullable
                    @Override
                    public String getCurrentContentText(Player player) {
                        return null;
                    }

                    @Nullable
                    @Override
                    public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback callback) {
                        return null;
                    }
                }
        );

        playerNotificationManager.setNotificationListener(new PlayerNotificationManager.NotificationListener() {
            @Override
            public void onNotificationStarted(int notificationId, Notification notification) {
                startForeground(notificationId, notification);
            }

            @Override
            public void onNotificationCancelled(int notificationId) {
                stopSelf();
            }
        });
        playerNotificationManager.setPlayer(player);
    }

    private MediaSource buildMediaSource(Uri uri){
        return new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("PC")
        ).createMediaSource(uri);
    }

    @Override
    public void onDestroy() {
        releasePlayer();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public SimpleExoPlayer getPlayer() {
        if (player == null){
            initialisePlayer(this, episode);
        }
        return player;
    }

    public class LocalBinder extends Binder{
        public AudioPlayerService getService(){
            return AudioPlayerService.this;
        }
    }

    private void releasePlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }


}
