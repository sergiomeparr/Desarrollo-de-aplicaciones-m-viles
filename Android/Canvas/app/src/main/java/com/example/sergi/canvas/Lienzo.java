package com.example.sergi.canvas;

import android.content.*;
import android.graphics.*;
import android.view.View;
import android.graphics.Paint.*;
public class Lienzo extends View{
    Paint   p;
    int     x, y;
    int     left = x/2 + 195;
    int     right = left + 100;
    int     top = y/2 + 60;
    int     bottom = top + 100;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c){
        super.onDraw(c);  // Canvas pinta atributos
        p = new Paint();  // Paint asigna atributos
        x = c.getWidth();  // También: getMeasuredWidth() o getRight(), x=480
        y = c.getHeight();  // También: getMeasuredHeight() o getBottom(), y=762
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);

        /*c.drawOval(x/2-60, y/2+60, x/2, y, p);
        RectF rectangulo = new RectF(left, top, right, bottom);
        p.setColor(Color.argb(100, 200, 100, 100));
        c.drawRect(rectangulo, p);
        RectF rect = new RectF(10,10,20,20);
        p.setColor(Color.argb(100, 200, 100, 100));
        c.drawRoundRect(rect, 0, 0, p);
       /c.drawArc(rect, 0F, 90F, true, p);
        */

        p.setColor(Color.BLACK); // Texto negro
        c.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2-20, p);
        p.setColor(Color.rgb(0, 0, 255));   // Ejes azules
        c.drawLine(x/2, 0, x/2, y, p);
        c.drawLine(0, y/2, x, y/2, p);
        p.setTextAlign(Align.valueOf("LEFT"));
        //p.setTextAlign(Align.RIGHT);
        //p.setTypeface(Typeface.SANS_SERIF);
        p.setTypeface(Typeface.SERIF);
        c.drawText("Eje X", x-50, y/2-10, p);
        //p.setTextAlign(Align.valueOf("LEFT"));
        p.setTextAlign(Align.CENTER);
        //p.setTypeface(Typeface.MONOSPACE);
        p.setTypeface(Typeface.DEFAULT_BOLD);
        c.drawText("Eje Y", x/2+30, 20, p);

        p.setColor(Color.argb(100, 200, 100, 100));
        c.drawCircle(x/2-150, y/2+150, 100, p);

    }
}
