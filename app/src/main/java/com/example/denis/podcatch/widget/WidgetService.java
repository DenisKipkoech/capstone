package com.example.denis.podcatch.widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.denis.podcatch.Models.Constants;
import com.example.denis.podcatch.R;

public class WidgetService extends IntentService {

    private static final String ACTION_APPWIDGET_UPDATE =
            "com.example.denis.android.podcatch.action.APPWIDGET_UPDATE";

    public WidgetService() {
        super(WidgetService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            if (ACTION_APPWIDGET_UPDATE.equals(intent.getAction())) {
                handleActionUpdateWidget();
            }
        }
    }

    public static void startActionUpdateWidget(Context context) {
        Intent intent = new Intent(context, WidgetService.class);
        intent.setAction(ACTION_APPWIDGET_UPDATE);
        context.startService(intent);
    }

    private void handleActionUpdateWidget() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                PodcastWidgetProvider.class));

        PodcastWidgetProvider.updateAllAppWidgets(this, appWidgetManager,
                appWidgetIds, String.valueOf(R.string.subscribed_podcasts));
    }
}
