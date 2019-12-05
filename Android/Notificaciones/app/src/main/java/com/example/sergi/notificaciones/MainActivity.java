package com.example.sergi.notificaciones;

import android.os.Build;
import android.os.Bundle; import android.app.*; import android.content.*; import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat; import android.view.*; import android.view.View.OnClickListener; import android.widget.Button; import android.widget.TextView;
import android.view.Menu;
public class MainActivity extends Activity {
    int t=200, i=0;
    boolean c=true;
    TextView jtv;
    Button jbnN;
    private static final int NOTIF_ALERTA_ID = 1;
    public static final String CHANNEL_ID = "default_channel_id";
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        jtv = (TextView) findViewById(R.id.xtv);
        jbnN = (Button)findViewById(R.id.xbnN);
        jbnN.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,in,0);
                //ncb.setContentIntent(pi);
                NotificationManager nm = (NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE);

                Notification ncb = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        /*.setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setLargeIcon((((BitmapDrawable) getResources()
                                .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                        */.setContentIntent(pi)
                        .setContentTitle("Alerta de Notificación")
                        .setContentText("Uso de la Notificación" + ", i = " + ++i)
                        .setContentInfo("Un valor")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setVibrate(new long[] {100, 250, 100, 500})
                        .build();

                /*NotificationCompat.Builder ncb = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setLargeIcon((((BitmapDrawable) getResources()
                                .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                        .setContentTitle("Alerta de Notificación")
                        .setContentText("Uso de la notificación." + "i=" + ++i)
                        .setContentInfo("Un valor")
                        .setTicker("Mensaje de Alerta!");
                */
                /*Intent in = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,in,0);
                ncb.setContentIntent(pi);
                NotificationManager nm = (NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE);
                */
                //nm.notify(NOTIF_ALERTA_ID, ncb.build());
                nm.notify(NOTIF_ALERTA_ID, ncb);
                jtv.setText("Cuenta: i=" + i);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }

}
