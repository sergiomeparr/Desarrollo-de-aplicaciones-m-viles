package Juego;

import javax.microedition.lcdui.*;
public class Imagen extends Canvas implements CommandListener {
    private Animacion mi;
    private Image im;
    private Command c;
    private int x, y;
    public Imagen(Animacion mid) {
        c = new Command("Salir", Command.EXIT, 1);
        this.mi = mid;
        this.addCommand(c);
        this.setCommandListener(this);
        try {						// Carpeta para la imagen, por ejemplo:
            im = Image.createImage("/barra.png");	//...\NetBeansProjects\MiProyecto\build\compiled\foto.png
        } catch (Exception e) {     }
        x = y = 0;
    }
    public void paint(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(im, x, y, Graphics.TOP|Graphics.LEFT);
    }
    protected void keyPressed(int keyCode) {
        switch (getGameAction(keyCode)) {
            case Canvas.DOWN: {
                if ((y + 20) < getHeight()) { y += 10; } break;
            }
            case Canvas.LEFT: {
                if (x > 0) { x -= 10; }  break;
            }
            case Canvas.UP: {
                if (y > 0) { y -= 10; }  break;
            }
            case Canvas.RIGHT: {
                if ((x + 20) < 190) {  x += 10; } break;
            }
        }
        this.repaint();
    }
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            mi.salir();
        }
    }
}