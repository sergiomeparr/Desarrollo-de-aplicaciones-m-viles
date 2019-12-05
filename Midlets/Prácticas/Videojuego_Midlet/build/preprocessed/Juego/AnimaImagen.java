package Juego;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
public class AnimaImagen extends Canvas implements Runnable{
    Graphics    g;
    Thread      t;
    Image       base, bola, barra;
    private int xi, yi;
    private int x = 0, y = 0;
    private int score = 0;
    public AnimaImagen(){
        try{
            base = Image.createImage("/base.jpg");
            bola = Image.createImage("/bola.png");
            barra = Image.createImage("/barra.png");
        }catch(Exception e){}
        t = new Thread(this);
        t.start();
        xi = 85;
        yi = 280;
    }
    
    public void paint(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(base, 0, 0, Graphics.TOP|Graphics.LEFT);
        g.drawImage(bola, x, y, Graphics.TOP|Graphics.LEFT);
        g.drawImage(barra, xi, yi, Graphics.TOP|Graphics.LEFT);
    }
    
    protected void keyPressed(int keyCode) {
        switch (getGameAction(keyCode)) {
            case Canvas.LEFT: { 
                if (xi > 0) {  xi -= 10; } break;
            }
            case Canvas.RIGHT: {
                if ((xi + 20) < 195) { xi += 10; } break;
            }
        }
        this.repaint();
    }
    public void run(){
        int vx = 5;
        int vy = 5;
        int alto = getHeight();
        int ancho = getWidth();
        while(y + bola.getHeight() < alto){
            try{
                t.sleep(50);
            }catch(InterruptedException ie){ 
                t.interrupt();
            }
            x = x + vx;
            y = y + vy;
            if((x + bola.getWidth()) > ancho || (x < 0))
                vx = -vx;
            if((y + bola.getHeight()) > alto || (y < 0))
                vy = -vy;
            if((y == (yi - 45) && x >= xi - 40) && (y == (yi - 45) && x <= xi + 20)){
                vy = -vy;
                score += 10;
            }
            repaint();    //son lo mismo solo pero en diferente subclase flushgraphics();
        }
    }

   
}
