package com.example.sergi.sensores1;

import android.app.Activity;
import android.os.Bundle;
import java.util.*;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.hardware.*;
public class MainActivity extends Activity {
    TextView        jtv;
    Sensor          s;
    SensorManager   sm;
    List <Sensor>   l;
    String          c, v;
    int             n, t;
    float           p, r, d;
    int[] imagenes = {
            R.drawable.acelerometro,
            R.drawable.giroscopio,
            R.drawable.sensor_magnetico,
            R.drawable.sensor_orientacion,
            R.drawable.sensor_temperatura,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad,
            R.drawable.sensor_proximidad
    };
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jtv = (TextView) findViewById(R.id.xtv);
        sm  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        n   = l.size();
        final ListView lv = (ListView) findViewById(R.id.xlv1);
        final NuevaEntradaAdapter nea = new NuevaEntradaAdapter(this, R.layout.nueva_entrada_lista);
        lv.setAdapter(nea);
        for(final NuevaEntrada i : getEntradas()) {
            nea.add(i);
        }
    }
    private List<NuevaEntrada> getEntradas() {
        final List<NuevaEntrada> datos = new ArrayList<NuevaEntrada>();
        jtv.append("\n\tSensores detectados: " + n + "\n");
        for(int i = 1; i <= 5; i++) {
            s = l.get(i);
            t = s.getType();
            c = s.getName();
            v = s.getVendor();
            p = s.getPower();
            r = s.getResolution();
            d = s.getMaximumRange();
            datos.add(new NuevaEntrada("\nTipo de sensor: " + t + "," + c, "\nProveedor: " + v,
                "Potencia (ma): " + p + "\n\n\nMáxima resolución: " + r + ", rango: " + d, imagenes[i - 1]));
        }
        return datos;
    }
}








/*
import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.hardware.*;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends Activity{
    TextView        jtv;
    Sensor          s;
    SensorManager   sm;
    List <Sensor>   l;
    String          c, v;
    int             n, t;
    float           p, r, d;
    int[] imagenes = {
            R.drawable.acelerometro,
            R.drawable.giroscopio,
            R.drawable.sensor_magnetico,
            R.drawable.sensor_orientacion,
            R.drawable.sensor_temperatura,
            R.drawable.sensor_proximidad,
            R.drawable.acelerometro,
            R.drawable.giroscopio,
            R.drawable.sensor_magnetico,
            R.drawable.sensor_orientacion,
            R.drawable.sensor_temperatura,
            R.drawable.sensor_proximidad,
            R.drawable.acelerometro,
            R.drawable.giroscopio,
            R.drawable.sensor_magnetico,
            R.drawable.sensor_orientacion,
            R.drawable.sensor_temperatura
    };
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jtv = (TextView) findViewById(R.id.xtv);
        sm  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        n   = l.size();
        jtv.append("\nSensores detectados: " + n + "\n");
        for(int i=0; i<n; i++){
            s = l.get(i);
            t = s.getType();
            c = s.getName();
            v = s.getVendor();
            p = s.getPower();
            r = s.getResolution();
            d = s.getMaximumRange();
            jtv.append("\nTipo de sensor: " + t + ", " + c);
            jtv.append("\nProveedor: " + v);
            jtv.append("\nPotencia (ma): " + p);
            jtv.append("\nMáxima resolución: " + r);
            jtv.append(", rango: " + d + "\n");
        }
    }
}*/
