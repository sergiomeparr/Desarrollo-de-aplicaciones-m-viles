
package Figuras;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public class Cono extends Canvas implements CommandListener{
    Ejercicio pantalla;
    public Cono(Ejercicio anterior){
        this.pantalla = anterior;
        try{
            setCommandListener(this);
            addCommand(new Command("Salir", Command.EXIT, 1));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void paint(Graphics g) {
        g.setColor(255, 0, 0);
        g.drawString("Cono", (getWidth() / 2) - 30, 0, Graphics.TOP|Graphics.LEFT);
        g.drawArc(75, 175, 90, 30, 0, 180);
        g.drawArc(75, 175, 90, 30, 180, 360);
        g.drawLine(75, 190, 120, 100);
        g.drawLine(120, 100, 165, 190);
    }

    public void commandAction(Command c, Displayable d) {
        if(c.getLabel().equals("Salir")){
            Display.getDisplay(pantalla).setCurrent(pantalla.getList()); 
        }
    }
}
