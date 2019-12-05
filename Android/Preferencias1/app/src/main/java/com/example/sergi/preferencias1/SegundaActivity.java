package com.example.sergi.preferencias1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    Bundle      bdl;
    EditText    jet;
    EditText    jet1;
    EditText    jet2;
    String      aux, aux1, aux2;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.xet1);
        jet1 = (EditText) findViewById(R.id.xet2);
        jet2 = (EditText) findViewById(R.id.xet3);
        bdl = getIntent().getExtras();
        aux = bdl.getString("Nombre");
        aux1 = bdl.getString("ApellidoM");
        aux2 = bdl.getString("ApellidoP");
        jet.append(aux);
        jet1.append(aux1);
        jet2.append(aux2);
    }
}

