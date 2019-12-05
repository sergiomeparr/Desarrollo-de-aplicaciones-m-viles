package com.example.sergi.palindrome;

import android.os.Bundle; import android.app.Activity; import android.view.View; import android.view.View.*; import android.content.Intent; import android.widget.*;
public class MainActivity extends Activity{
    EditText    jet;
    Button      jbn;
    TextView    txt;
    String      palindromo;
    String      auxiliar;
    boolean     resultado = true;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.TxtNombre);
        txt = (TextView) findViewById(R.id.textView);
        jbn = (Button) findViewById(R.id.button);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                resultado = true;
                palindromo = jet.getText().toString();
                auxiliar = palindromo.replace(" ", "");
                Palindrome(auxiliar);
                if(resultado)
                    txt.setText("La palabra: " + palindromo + " es palindroma");
                else
                    txt.setText("La palabra: " + palindromo + " no es palindroma");
            }
        });
    }

    public void Palindrome(String cadena) {
        char[] stringArray;
        int tamaño = 0;
        stringArray = cadena.toCharArray();
        tamaño = stringArray.length - 1;
        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i] != stringArray[tamaño]){
                resultado = false;
                break;
            }
            tamaño--;
        }
    }
}