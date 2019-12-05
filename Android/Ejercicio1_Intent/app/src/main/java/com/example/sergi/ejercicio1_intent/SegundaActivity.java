package com.example.sergi.ejercicio1_intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    Bundle      bdl;
    EditText    jet;
    EditText    jet1;
    EditText    jet2;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.xet1);
        jet1 = (EditText) findViewById(R.id.xet2);
        bdl = getIntent().getExtras();
        jet.append(bdl.getString("NOMBRE"));
        jet1.append(bdl.getString("APELLIDO"));
    }
}
