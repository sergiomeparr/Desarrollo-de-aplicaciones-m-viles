package com.example.sergi.canvas2;

import android.content.*;
import android.graphics.*;
import android.view.View;
import android.graphics.Paint;


public class Lienzo extends View{
    Paint   p;
    Path    r;
    int     x, y, x0, y0;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c) {
        super.onDraw(c);  // Canvas pinta atributos
        p = new Paint();  // Paint asigna atributos
        r = new Path();
        x = c.getWidth();
        x0 = x / 2; // También: getMeasuredWidth(), o getRight(), x=480
        y = c.getHeight();
        y0 = y / 2; // También: getMeasuredHeight(), o getBottom(), y=762
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro
        p.setTypeface(Typeface.SANS_SERIF);
        c.drawText("0,0", x0 + 5, y0 + 20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x0, 0, x0, y, p);
        c.drawLine(0, y0, x, y0, p);
        p.setTypeface(Typeface.SANS_SERIF);
        p.setColor(Color.BLUE);
        c.drawText("cosA", 20, 20, p);
        p.setTypeface(Typeface.SANS_SERIF);
        p.setColor(Color.RED);
        c.drawText("senA", 20, 50, p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
        p.setAntiAlias(true);
        r = new Path();
        x = getMeasuredWidth();
        r.moveTo(0, 0);
        p.setColor(Color.BLUE);
        for (int i = 0; i < x+15; i++){
            r.lineTo(i, (float) Math.sin(i / 20f) * (-80f));
        }
        r.offset(-15, y0);
        c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        for(int i=0; i<x+15; i++)
            r.lineTo(i, (float) Math.cos(i / 20f) * (-100f));
        r.offset(-15, y0);
        c.drawPath(r, p);
    }
}