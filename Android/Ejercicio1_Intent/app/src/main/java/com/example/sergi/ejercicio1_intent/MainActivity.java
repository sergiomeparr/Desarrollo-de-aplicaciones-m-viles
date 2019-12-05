package com.example.sergi.ejercicio1_intent;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;
public class MainActivity extends Activity{
    EditText    jet;
    EditText    jet1;
    Button      jbn;
    Bundle      bdl;
    Intent      itn;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.xet);
        jet1 = (EditText) findViewById(R.id.xet1);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("NOMBRE", jet.getText().toString());
                bdl.putString("APELLIDO", jet1.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}
