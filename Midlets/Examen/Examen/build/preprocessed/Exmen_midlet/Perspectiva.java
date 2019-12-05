package Exmen_midlet;
import javax.microedition.lcdui.*;
class Perspectiva extends Canvas implements CommandListener{
    
    Form f;
    int centerX=0, centerY=0, maxX=0, maxY=0, minMaxXY=0;
    
    int x,y;
    Obj obj = new Obj();
    
    examen1 pantallaAnt;
    
    public Perspectiva(examen1 anterior){
        try{
            this.pantallaAnt = anterior;
            setCommandListener(this);
            addCommand(new Command("Regresar", Command.EXIT, 1));
            x=100;
            y=100;
            centerX = maxX/2;
            centerY = maxY/2;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void writeVertexCoordinates(Graphics g, int i){
    	//System.out.println(obj.w[i]);
        Point2D p = obj.vScr[i];
        //g.drawString("Hola", iX(p.x), iY(p.y),100 );
        g.setColor(0);
        g.setStrokeStyle(Graphics.SOLID);
        g.drawString("(" + (int) obj.w[i].x + ", " + (int) obj.w[i].y + ", " + (int)obj.w[i].z + ")", iX(p.x),  iY(p.y), Graphics.TOP | Graphics.LEFT);
    	//g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        
    }
    
    public void paint(Graphics g) {
        g.setColor(200,200,200);
        g.fillRect(0, 0, getWidth(),getHeight());
        g.setColor(75,155,200);
        maxX=getWidth()-1; maxY=getHeight()-1; minMaxXY=Math.min(maxX,maxY);
	centerX = maxX/2;
	centerY = maxY/2;
	obj.d = obj.rho*minMaxXY/obj.objSize;
	obj.eyeAndScreen();
        
        line(g, 4, 6); line(g, 1, 3);
        line(g, 4, 1); line(g, 4, 3);
        line(g, 1, 6); line(g, 1, 4); line(g, 3, 6);
        
//        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
//	line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores  
//	line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
        writeVertexCoordinates(g,1); writeVertexCoordinates(g,3); writeVertexCoordinates(g,4);
        writeVertexCoordinates(g,6); 
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
        if(command.getLabel().equals("Regresar")){
            Display.getDisplay(pantallaAnt).setCurrent(pantallaAnt.main);
        }
    }

}
//Autor: Johan Gamaliel Lopez Perez