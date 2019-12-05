package examen;
import javax.microedition.lcdui.*;
class Perspectiva extends Canvas implements CommandListener{
    
    Form f;
    int centerX=0, centerY=0, maxX=0, maxY=0, minMaxXY=0;
    double resultado;
    int x,y;
    Obj obj;
    Examen_ver2 pantallaAnterior;
    
    public Perspectiva(Examen_ver2 anterior, double volumen, double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3){
        this.pantallaAnterior = anterior;
        this.resultado = volumen;
        obj = new Obj(x1, y1, z1, x2, y2, z2, x3, y3, z3);
        x=100;
        y=100;
        centerX = maxX/2;
	centerY = maxY/2;
        setCommandListener(this);
        addCommand(new Command("Anterior", Command.EXIT, 1));
    }
    
    int iX(float x){
	return centerX +(int) x;
    }
    
    int iY(float y){
    	return centerY - (int)y;
    }
    
    void line(Graphics g, int i, int j){
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    
    void ejeX(Graphics g, int i, int j){
        Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    
    void ejeY(Graphics g, int i, int j){
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    void CoordenadasVertices(Graphics g, int i){
    	Point2D p = obj.vScr[i];
        g.setColor(0);
        g.setStrokeStyle(Graphics.SOLID);
        g.setColor(75,155,200);
        g.drawString("(" + obj.w[i].x + ", " + obj.w[i].y + ", " + obj.w[i].z + ")", iX(p.x),  iY(p.y), Graphics.TOP | Graphics.LEFT);
        g.setColor(75,155,200);
        g.drawString("Volúmen = " + resultado + " u^3", 0, 280, Graphics.TOP | Graphics.LEFT);
    }
    
    public void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getWidth(),getHeight());
        g.setColor(255, 0, 0);
        maxX=getWidth()-1; maxY=getHeight()-1; minMaxXY=Math.min(maxX,maxY);
	centerX = maxX/2;
	centerY = maxY/2;
	obj.d = obj.rho*minMaxXY/obj.objSize;
	obj.eyeAndScreen();
        
        line(g, 0, 1); line(g, 0, 2); line(g, 0, 3);
        line(g, 1, 2); line(g, 2, 3); line(g, 3, 1);
        
        CoordenadasVertices(g,0); 
        CoordenadasVertices(g,1); 
        CoordenadasVertices(g,2);
        CoordenadasVertices(g,3); 
    }
    
    public void keyPressed(int keyCode){
        if(keyCode == getKeyCode(DOWN)){
            y-=2;
        }
        if(keyCode == getKeyCode(RIGHT)){
            x-=2;
        }
        if(keyCode == getKeyCode(LEFT)){
            x+=2;
        }
        if(keyCode == getKeyCode(UP)){
            y+=2;
        }
        obj.theta   = (float) getWidth()/x;
	obj.phi     = (float) getHeight()/y;
	obj.rho     = (obj.phi/obj.theta)*getHeight();
	centerX     = x;
	centerY     = y;
	repaint();
    }
    public void commandAction(Command command, Displayable displayable) {
        if(command.getLabel().equals("Anterior")){
            Display.getDisplay(pantallaAnterior).setCurrent(pantallaAnterior.getForm());
        }
    }
}