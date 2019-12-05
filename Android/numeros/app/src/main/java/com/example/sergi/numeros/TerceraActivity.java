package com.example.sergi.numeros;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class TerceraActivity extends Activity {
    EditText    jet;
    TextView    jet1;
    Bundle      bdl;
    int         numero;
    int         posiciones = 0;
    int[]       maravillosos;
    String      resultado_final = "";

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_tercera);
        jet = (EditText) findViewById(R.id.textView);
        jet1 = (TextView) findViewById(R.id.textView1);
        bdl = getIntent().getExtras();
        numero = Integer.parseInt(bdl.getString("NUMERO2"));
        jet.append(Integer.toString(numero));
        maravillosos = new int[1500];
        maravillosos = numeros_maravillosos(numero, maravillosos);
        jet1.append("Numero Maravilloso \n");
        Convertir_a_cadena();
        jet1.append(resultado_final);
    }

    private int[] numeros_maravillosos(int dato, int[] arreglo) {
        if (dato == 2) {
            arreglo[posiciones] = dato;
            posiciones++;
            arreglo[posiciones] = dato / 2;
            posiciones++;
            return arreglo;
        } else {
            arreglo[posiciones] = dato;
            if (dato % 2 == 0)
                dato = dato / 2;
            else
                dato = (dato * 3) + 1;
            posiciones++;
            return numeros_maravillosos(dato, arreglo);
        }
    }

    public void Convertir_a_cadena(){
        for(int i = 0; i < posiciones; i++){
            resultado_final = resultado_final + maravillosos[i] + "\n";
        }
    }
}