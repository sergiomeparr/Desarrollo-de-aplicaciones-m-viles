package com.example.sergi.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

public class NewAppWidget extends AppWidgetProvider {
    public void onUpdate(Context c, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int i=0; i<appWidgetIds.length; i++){
            int id = appWidgetIds[i];
            String url = "ESCOM";
            Intent in = new Intent(Intent.ACTION_VIEW);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setData(Uri.parse(url));
            PendingIntent pi = PendingIntent.getActivity(c, 0, in, 0);
            RemoteViews rv = new RemoteViews(c.getPackageName(),R.layout.activity_main);
            rv.setOnClickPendingIntent(R.id.xbn, pi);
            appWidgetManager.updateAppWidget(id, rv);
            Toast.makeText(c, "Widget agregado", Toast.LENGTH_SHORT).show();
        }
    }
}