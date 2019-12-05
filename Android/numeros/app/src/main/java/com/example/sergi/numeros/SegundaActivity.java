package com.example.sergi.numeros;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;
public class SegundaActivity extends Activity{
    EditText    jet;
    TextView    jet1;
    Button      jbn;
    Bundle      bdl;
    String      cadena = "";
    int         numero;
    int[]       arreglo_primos;
    boolean     resultado = false;
    Intent      itn;
    Bundle      bld1;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText)  findViewById(R.id.textView);
        jet1 = (TextView) findViewById(R.id.textView1);
        jbn = (Button) findViewById(R.id.boton);
        bdl = getIntent().getExtras();
        numero = Integer.parseInt(bdl.getString("NUMERO"));
        Primo();
        Verificar();
        jet.append(Integer.toString(numero));
        if (resultado){
            jet1.append("Es primo \n");
            jet1.append(cadena);
        }
        else{
            jet1.append("No es primo \n");
            jet1.append(cadena);
        }
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(SegundaActivity.this, TerceraActivity.class);
                bld1 = new Bundle();
                bld1.putString("NUMERO2", jet.getText().toString());
                itn.putExtras(bld1);
                startActivity(itn);
            }
        });
    }

    public void Primo(){
        arreglo_primos = new int[numero + 1];
        boolean bandera;
        int contador = 2;
        arreglo_primos[0] = 2;
        arreglo_primos[1] = 3;
        for(int i = 4; i <= numero; i++){
            bandera = true;
            for(int j = 0; j < contador; j++){
                if(i % arreglo_primos[j] == 0) {
                    bandera = false;
                    break;
                }
            }
            if(bandera) {
                arreglo_primos[contador] = i;
                System.out.println(arreglo_primos[contador]);
                contador++;
            }
        }
    }

    public void Verificar(){
        for(int i = 0; i <= arreglo_primos.length; i++){
            cadena = cadena + arreglo_primos[i] + "\n";
            if(arreglo_primos[i] == numero || arreglo_primos[i] > numero){
                resultado = true;
                break;
            }
        }
    }
}
