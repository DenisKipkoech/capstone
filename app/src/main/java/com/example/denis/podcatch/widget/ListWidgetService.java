package com.example.denis.podcatch.widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.denis.podcatch.Database.AppDatabase;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.R;

import java.util.List;

public class ListWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return null;
    }

    class ListRemoteViewsFactory implements RemoteViewsFactory{
        private Context context;
        private AppDatabase database;
        private List<Podcast> podcastList;

        public ListRemoteViewsFactory(Context context) {
            this.context = context;
        }

        @Override
        public void onCreate() {
            database = AppDatabase.getInstance(context);
        }

        @Override
        public void onDataSetChanged() {
            podcastList = database.PodcastDao().getPodcasts();
        }

        @Override
        public void onDestroy() {
            if (podcastList != null){
                podcastList.clear();
            }
        }

        @Override
        public int getCount() {
            if (podcastList == null){
                return 0;
            }
            return podcastList.size();

        }

        @Override
        public RemoteViews getViewAt(int position) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.widget_list_item);
            Podcast podcast = podcastList.get(position);
            remoteViews.setTextViewText(R.id.tv_widget_podcast, podcast.getTitle());
            return remoteViews;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }
    }
}
