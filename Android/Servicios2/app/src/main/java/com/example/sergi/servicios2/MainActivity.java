package com.example.sergi.servicios2;
import android.app.Activity; import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.*;
import android.os.SystemClock;
import android.widget.Chronometer;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity { // ServiceTimerActivity
    private Chronometer cronometro;
    private Button      jbn;
    private Button      jbn1;
    private Button      jbn2;
    private Button      stop;
    long tiempo = 0;
    String texto = "";
    boolean continuar = false;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        cronometro = (Chronometer) findViewById(R.id.chronometer1);
        jbn = (Button) findViewById(R.id.xbnI);
        jbn1 = (Button) findViewById(R.id.xbnII);
        jbn2 = (Button) findViewById(R.id.xbnIII);
        stop = (Button) findViewById(R.id.xbnT);
        jbn1.setEnabled(false);
        jbn2.setEnabled(false);
        stop.setEnabled(false);
        jbn.setEnabled(true);
        //iniciar
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jbn.setEnabled(true);
                jbn2.setEnabled(false);
                stop.setEnabled(true);
                jbn1.setEnabled(true);
                if(!continuar) {
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                }
                else
                    cronometro.start();
            }
        });
        //Terminar
        jbn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jbn.setEnabled(true);
                jbn2.setEnabled(false);
                stop.setEnabled(false);
                jbn1.setEnabled(false);
                cronometro.stop();
                cronometro.setText("0:00 segs");
                continuar = false;
                jbn.setEnabled(true);
                cronometro.stop();
            }
        });
        //continuar
        jbn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stop.setEnabled(true);
                jbn2.setEnabled(false);
                jbn1.setEnabled(true);
                jbn.setEnabled(false);
                if(!continuar) {
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                }
                else
                    cronometro.start();
            }
        });
        //pausar
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                jbn2.setEnabled(true);
                jbn1.setEnabled(true);
                stop.setEnabled(false);
                jbn.setEnabled(false);
                cronometro.stop();
                cronometro.setText(texto + " segs");
                continuar = true;
            }
        });
        cronometro.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            public void onChronometerTick(Chronometer chronometer) {
                if(!continuar) {
                    long segundos = ((SystemClock.elapsedRealtime() - cronometro.getBase()) / 1000) / 60;
                    long milisegundos = (long) ((SystemClock.elapsedRealtime() - cronometro.getBase()) / 1000) %60;
                    if (milisegundos < 10)
                        texto = segundos + ":0" + milisegundos;
                    if (milisegundos >= 10)
                        texto = segundos + ":" + milisegundos;
                    chronometer.setText(texto + " segs");
                    tiempo = SystemClock.elapsedRealtime();
                }
                else{
                    long segundos = ((tiempo - cronometro.getBase()) / 1000) / 60;
                    long milisegundos = ((tiempo - cronometro.getBase()) / 1000) % 60;
                    if (milisegundos < 10)
                        texto = segundos + ":0" + milisegundos;
                    if (milisegundos >= 10)
                        texto = segundos + ":" + milisegundos;
                    chronometer.setText(texto + " segs");
                    tiempo = tiempo + 1000;
                }
            }
        });
    }
}