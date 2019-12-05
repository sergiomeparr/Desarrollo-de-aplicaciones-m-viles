package com.example.sergi.preferencias1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText          jetapm, jetapp, jetn;
    String            s, apm, app;
    Button            jbn;
    Bundle            bdl;
    Intent            itn;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jetn    = (EditText) findViewById(R.id.xetn);
        jetapm  = (EditText) findViewById(R.id.xetapm);
        jetapp  = (EditText) findViewById(R.id.xetapp);
        sp      = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        s       = sp.getString("Nombre", "Jose");
        apm     = sp.getString("Apellido Materno", "Villegas");
        app     = sp.getString("Apellido Paterno", "Pérez");
        jetn.setText(s);
        jetapm.setText(apm);
        jetapp.setText(app);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                s = jetn.getText().toString();
                apm = jetapm.getText().toString();
                app = jetapp.getText().toString();
                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putString("Nombre", s);
                miEditor.putString("Apellido Materno", apm);
                miEditor.putString("Apellido Paterno", app);
                miEditor.commit();
                Toast.makeText( getActivity(),"Preferencias guardadas", Toast.LENGTH_LONG).show();

                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("Nombre", jetn.getText().toString());
                bdl.putString("ApellidoM", jetapm.getText().toString());
                bdl.putString("ApellidoP", jetapp.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
    public Context getActivity() {
        return this;
    }
}
