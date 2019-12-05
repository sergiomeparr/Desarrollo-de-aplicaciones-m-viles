
package Figuras;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public class Cubo extends Canvas implements CommandListener{
   
    Ejercicio pantalla;
    public Cubo(Ejercicio anterior) {
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
        g.drawString("Cubo", (getWidth() / 2) - 30, 0, Graphics.TOP|Graphics.LEFT);
        //tapa superior
        g.drawLine(75, 75, 150, 75);
        g.drawLine(45, 100, 120, 100);
        g.drawLine(75, 75, 45, 100);
        g.drawLine(150, 75, 120, 100);
        //aristas
        g.drawLine(75, 75, 75, 150);
        g.drawLine(120, 100, 120, 175);
        g.drawLine(150, 75, 150, 150);
        g.drawLine(45, 100, 45, 175);
        //tapainferior
        g.drawLine(75, 150, 150, 150);
        g.drawLine(45, 175, 120, 175);
        g.drawLine(75, 150, 45, 175);
        g.drawLine(150, 150, 120, 175);
        
    }

    public void commandAction(Command c, Displayable d) {
        if(c.getLabel().equals("Salir")){
            Display.getDisplay(pantalla).setCurrent(pantalla.getList()); 
        }
    }
}
