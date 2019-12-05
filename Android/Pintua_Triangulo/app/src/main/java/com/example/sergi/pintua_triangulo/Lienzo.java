package com.example.sergi.pintua_triangulo;

import android.content.*;
import android.graphics.*;
import android.view.View;
import android.graphics.Paint;

public class Lienzo extends View{
    Paint     p;
    Path      r;
    float[][] arreglo_vectores = new float[4][3];			//Arreglo que contiene los puntos de los vectores
    float[]   valores_vectores =  new float[1000001];		//Arreglo que contiene los puntos de las iteraciones recursivas
    int       contador = 1;								//Contador auxiliar que cuenta el numero de iteraciones
    String    color;
    float     x;
    float     y;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c) {
        super.onDraw(c);  // Canvas pinta atributos
        p = new Paint();  // Paint asigna atributos
        r = new Path();
        float x0; // También: getMeasuredWidth(), o getRight(), x=480
        float y0; // También: getMeasuredHeight(), o getBottom(), y=762
        float x2;
        float posicion_vector;//Se obtiene de forma aleatoria cualquier vector
        x = c.getWidth();
        x0 = x / 2; // También: getMeasuredWidth(), o getRight(), x=480
        y = c.getHeight();
        y0 = y / 2; // También: getMeasuredHeight(), o getBottom(), y=762
        x2 = x0 - x0 / 8;
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro
        p.setTypeface(Typeface.SANS_SERIF);
        p.setColor(Color.rgb(0, 0, 0)); // Ejes azules
        c.drawLine(x0, 0, x0 / 8, y0, p);
        c.drawLine(x0, 0, x0 + x2, y0, p);
        c.drawLine(x0 / 8, y0, x0 + x2, y/2, p);

        //Vector 1
        arreglo_vectores[1][1] = x0;
        arreglo_vectores[1][2] = 0;
        //Vector 2
        arreglo_vectores[2][1] = x0 / 8;
        arreglo_vectores[2][2] = y0;
        //Vector 3
        arreglo_vectores[3][1] = x0 + x2;
        arreglo_vectores[3][2] = y0;

        x = punto_aleatoriox();
        y = punto_aleatorioy();
        c.drawText("Punto P", x, y, p);
        c.drawPoint(x, y, p);
        p.setStrokeWidth(10);
        p.setColor(Color.BLACK); // Texto negro
        c.drawPath(r, p);

        valores_vectores[contador] = x;
        valores_vectores[contador + 1] = y;

        //solo faltan los puntos.
        for(int i = 1; i <= 50000; i++) {
            p = new Paint();                    // Paint asigna atributos
            posicion_vector = vector_aleatorio();//Se obtiene de forma aleatoria cualquier vector
            float nuevo_x = ((valores_vectores[contador] + arreglo_vectores[(int)posicion_vector][1]) / 2); //Punto medio entre puntos x
            float nuevo_y = ((valores_vectores[contador + 1] + arreglo_vectores[(int) posicion_vector][2]) / 2); //Punto medio entre puntos x
            color = colores((int) posicion_vector);
            p.setColor(Color.parseColor(color));
            c.drawPoint(nuevo_x, nuevo_y, p);
            contador += 2;
            valores_vectores[contador] = nuevo_x;
            valores_vectores[contador + 1] = nuevo_y;

        }
    }

    protected float vector_aleatorio(){
        return (float) Math.floor ( 1 + Math.random() * 3);
    }
    protected float punto_aleatorioy(){ return (float)Math.floor ( 1 + Math.random() * (getHeight() / 4)); }

    protected String colores(int aleatorio){
        String aux = "";
        if(aleatorio == 1){ aux = "black"; }
        else if(aleatorio == 2){ aux = "green"; }
        else if(aleatorio == 3){ aux = "red"; }
        return aux;
    }

    protected float punto_aleatoriox(){
        float rango = (float)Math.floor ( 1 + Math.random() * 2);
        float limite = 0;
        if(rango == 1){ limite = (float)Math.floor ((Math.random() * 100) + 1); }
        else if(rango == 2){ limite = (float)Math.floor ((Math.random() * 101) + 200); }
        return limite;
    }
}
