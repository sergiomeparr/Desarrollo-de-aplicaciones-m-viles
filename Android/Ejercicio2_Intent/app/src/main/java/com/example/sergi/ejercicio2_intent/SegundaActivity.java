package com.example.sergi.ejercicio2_intent;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    Bundle      bdl;
    EditText    jet;
    EditText    jet1;
    String      aux, aux1, aux2;
    double      A, B, C, dis, x1, x2;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.xet1);
        jet1 = (EditText) findViewById(R.id.xet2);
        bdl = getIntent().getExtras();
        aux = bdl.getString("a");
        aux1 = bdl.getString("b");
        aux2 = bdl.getString("c");
        A = Double.valueOf(aux).doubleValue();
        B = Double.valueOf(aux1).doubleValue();
        C = Double.valueOf(aux2).doubleValue();
        dis = (B * B) - (4 * A * C);
        if(dis < 0) {
            dis = Math.sqrt(-1 * dis);
            x1 = -1 * ((B + dis) / (2 * A));
            x2 = -1 * ((B - dis) / (2 * A));
            jet.append(Double.toString(x2) + "i");
            jet1.append(Double.toString(x1) + "i");
        }
        else{
            x1 = -1 * ((B + Math.sqrt(dis)) / (2 * A));
            x2 = -1 * ((B - Math.sqrt(dis)) / (2 * A));
            jet.append(Double.toString(x2));
            jet1.append(Double.toString(x1));
        }
    }
}
