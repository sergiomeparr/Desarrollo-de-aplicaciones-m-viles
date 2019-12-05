package com.example.sergi.servicios;

import java.util.*;
import android.app.Service;
import android.content.Intent;
import android.os.*;
public class MiCrono extends Service {
    private Timer t = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 60; // En milisegundos
    public static MainActivity UPDATE_LISTENER;
    private double n = 0;
    private Handler h;
    public static void setUpdateListener(MainActivity sta) {
        UPDATE_LISTENER = sta;
    }
    public void onCreate() {
        super.onCreate();
        iniciarCrono();
        h = new Handler() {
            public void handleMessage(Message msg) {
                UPDATE_LISTENER.refreshCrono(n);
            }
        };
    }
    public void onDestroy() {
        pararCrono();
        super.onDestroy();
    }
    public IBinder onBind(Intent arg0) {
        return null;
    }
    private void iniciarCrono() {
            t.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    SystemClock.sleep(1000);
                    n += 0.01;
                    h.sendEmptyMessage(0);
                }
            }, 0, INTERVALO_ACTUALIZACION);
    }
    private void pararCrono() {
        if (t != null) {
            t.cancel();
        }
    }
}
