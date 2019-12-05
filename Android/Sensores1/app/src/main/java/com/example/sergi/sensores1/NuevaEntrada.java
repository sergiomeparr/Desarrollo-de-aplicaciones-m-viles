package com.example.sergi.sensores1;

import java.util.Date;
public final class NuevaEntrada {
    private final String    titulo;
    private final String    autor;
    private final String    proveedor;
    private final int       icono;
    public NuevaEntrada(final String t, final String a, final String p,final int i) {
        this.titulo = t;
        this.autor  = a;
        this.proveedor = p;
        this.icono  = i;

    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getProveedor() { return proveedor; }
    public int getIcono() { return icono; }
}

