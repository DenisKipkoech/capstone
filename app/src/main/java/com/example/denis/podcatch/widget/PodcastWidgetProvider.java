package com.example.denis.podcatch.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.example.denis.podcatch.R;
import com.example.denis.podcatch.SubscriptionsActivity;

/**
 * Implementation of App Widget functionality.
 */
public class PodcastWidgetProvider extends AppWidgetProvider {

    static void updateAllAppWidgets(Context context, AppWidgetManager appWidgetManager,
                                    int[] appWidgetIds, String podcastName){
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, podcastName);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, String podcastName) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.podcast_widget_provider);

        Intent clickIntent = new Intent(context, SubscriptionsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, clickIntent,0);

        Intent intent = new Intent(context, ListWidgetService.class);

        views.setTextViewText(R.id.tv_widget_saved, podcastName);

        views.setRemoteAdapter(R.id.widget_listview, intent);

        views.setOnClickPendingIntent(R.id.tv_widget_saved, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        WidgetService.startActionUpdateWidget(context);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        WidgetService.startActionUpdateWidget(context);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

