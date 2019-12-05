package com.example.sergi.fragmentos;

import com.example.sergi.fragmentos.MiFragmento.FragmentoListener;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
public class MainActivity extends Activity implements FragmentoListener {
    TextView    xtv;
    Button      jbn;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        xtv = (TextView) findViewById(R.id.xtv);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                Fragment f = fm.findFragmentByTag("editor");
                if (null == f) {
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.xfl, new MiFragmento(), "editor");
                    ft.commit();
                }
                xtv.setText("");
                Toast.makeText(MainActivity.this, "Utilizando Fragment", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void digitado(int r, String s) {
        TextView jtv = (TextView) findViewById(R.id.xtv);
        if (r == MiFragmento.OK) {
            jtv.setText(s);
        }
        FragmentManager     fm = getFragmentManager();
        Fragment            fe = fm.findFragmentByTag("editor");
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fe);
        ft.commit();
    }
}