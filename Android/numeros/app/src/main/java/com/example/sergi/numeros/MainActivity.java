package com.example.sergi.numeros;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends Activity {
    EditText    jet;
    Button      jbn;
    Button      jbn1;
    TextView    txt;
    String      cadena;
    int         numero;
    boolean     resultado;
    Intent      itn;
    Bundle      bdl;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.TxtNombre);
        txt = (TextView) findViewById(R.id.textView);
        jbn = (Button) findViewById(R.id.button);
        jbn1 = (Button) findViewById(R.id.button1);
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                resultado = false;
                int[] fibo;
                cadena = jet.getText().toString();
                numero = Integer.parseInt(cadena);
                fibo = Fibonacci(numero);
                if (resultado) {
                    mostrarlista(fibo, "Es fibonacci");
                } else {
                    mostrarlista(fibo, "No es fibonacci");
                }
            }
        });

        jbn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("NUMERO", jet.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }

    public int[] Fibonacci(int x) {
        int[] aux =  new int[x + 1];
        aux[0] = 0;
        aux[1] = 1;
        for(int i = 2; i <= x; i++){
            aux[i] = aux[i - 1] + aux[i - 2];
        }
        verificar(aux, x);
        return aux;
    }

    public void verificar(int[] x, int y){
        for(int i = 0; i < x.length; i++) {
            if (x[i] == y) {
                resultado = true;
                break;
            }
        }
    }

    public void mostrarlista(int[] x, String res){
        String cadena = res + "\n";
        for(int i = 0; i < x.length; i++) {
            cadena = cadena + x[i] + "\n";
        }
        txt.setText(cadena);
    }
}