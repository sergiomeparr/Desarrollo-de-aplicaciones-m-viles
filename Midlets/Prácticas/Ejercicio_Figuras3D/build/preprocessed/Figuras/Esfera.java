package Figuras;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public class Esfera extends Canvas implements CommandListener{
    Ejercicio pantalla;
    public Esfera(Ejercicio anterior){
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
        g.drawString("Esfera", (getWidth() / 2) - 30, 0, Graphics.TOP|Graphics.LEFT);
        
        //Aristas
        g.drawArc(45, 100, 30, 90, 90, 180);
        g.drawArc(75, 86, 30, 90, 90, 180);
        g.drawArc(108, 86, 30, 90, 270, 180);
        g.drawArc(135, 100, 30, 90, 270, 180);
        
        //Tapa de Arriba
        g.drawArc(60, 85, 90, 30, 0, 180);
        g.drawArc(60, 85, 90, 30, 180, 360);
        
        //TapaInferior
        g.drawArc(60, 175, 90, 30, 0, 180);
        g.drawArc(60, 175, 90, 30, 180, 360);
        
        
    }

    public void commandAction(Command c, Displayable d) {
        if(c.getLabel().equals("Salir")){
            Display.getDisplay(pantalla).setCurrent(pantalla.getList()); 
        }
    }
    
}
