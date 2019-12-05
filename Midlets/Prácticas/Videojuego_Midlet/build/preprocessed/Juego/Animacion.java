package Juego;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Animacion extends MIDlet{
    private Display     d;
    private AnimaImagen ai;
    public Animacion(  ) {
        d = Display.getDisplay(this);
        ai = new AnimaImagen();
    }
    public void startApp() {
        d.setCurrent(ai);
    }
    public void pauseApp() {    }
    public void destroyApp(boolean b) {    }
    public void salir() {
        destroyApp(false);
        notifyDestroyed();
    }
}

