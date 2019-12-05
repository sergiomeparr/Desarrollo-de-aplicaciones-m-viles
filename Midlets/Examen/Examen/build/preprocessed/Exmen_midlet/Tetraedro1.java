/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exmen_midlet;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

public class Tetraedro1 extends Canvas implements CommandListener{
    examen1 pantalla;
    Perspectiva f;
    Display d;
    public Tetraedro1(examen1 anterior){
        this.pantalla = anterior;
        d = Display.getDisplay(pantalla);
        f = new Perspectiva();
    }
    public void startApp() {
        d.setCurrent(f);
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }

    public void commandAction(Command c, Displayable d) {
    
    }

    protected void paint(Graphics g) {
    
    }
}
