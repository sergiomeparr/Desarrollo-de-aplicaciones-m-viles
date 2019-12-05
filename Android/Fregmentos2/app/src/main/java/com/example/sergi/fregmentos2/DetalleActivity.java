package com.example.sergi.fregmentos2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.example.escom.fragmentos.EXTRA_TEXTO";
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle fd = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        fd.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}