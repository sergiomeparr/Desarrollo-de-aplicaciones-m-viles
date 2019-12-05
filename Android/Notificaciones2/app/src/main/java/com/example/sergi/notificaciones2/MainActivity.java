package com.example.sergi.notificaciones2;

import android.app.*;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.NotificationCompat;
public class MainActivity extends Activity {
    int id = 1;
    public static final String CHANNEL_ID = "default_channel_id";
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        displayNotification();
    }
    protected void displayNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", id);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        CharSequence ticker = "Nueva entrada en ESCOM";
        CharSequence contentTitle = "Notificaciones";
        CharSequence contentText = "Curso de Android";
        Notification noti = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                //.setChannelId(NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                //.addAction(R.mipmap.ic_launcher, ticker, pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(id, noti);
    }
}