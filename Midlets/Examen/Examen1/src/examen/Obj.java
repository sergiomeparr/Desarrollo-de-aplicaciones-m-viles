package examen;
class Obj{	
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr;    // coordenadas de la pantalla
    Obj(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D[4];
	vScr	= new Point2D[4];
        
        w[0]	= new Point3D(0, 0, 0); // desde la base
	w[1]	= new Point3D(x1, y1, z1);
	w[2]	= new Point3D(x2, y2, z2);
	w[3]	= new Point3D(x3, y3, z3);
        
	objSize = (float) Math.sqrt(12F); 
        rho	= 5 * objSize;
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
	v11 = -sinth; v12 = -cosph * costh; v13 = sinph * costh;
	v21 = costh; v22 = -cosph * sinth; v23 = sinph * sinth;
	v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
	for(int i=0; i<4; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
	}
    }
}