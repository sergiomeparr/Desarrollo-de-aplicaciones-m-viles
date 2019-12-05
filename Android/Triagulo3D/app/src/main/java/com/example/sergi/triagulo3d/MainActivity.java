package com.example.sergi.triagulo3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Triangulo l = new Triangulo(this);
        setContentView(l);
    }
}
