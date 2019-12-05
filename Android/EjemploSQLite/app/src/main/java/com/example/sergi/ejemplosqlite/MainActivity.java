package com.example.sergi.ejemplosqlite;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MainActivity extends Activity {
    EditText        jetI, jetN;
    Button          jbnA, jbnB, jbnU, jbnL;
    TextView        jtvL;
    SQLiteDatabase  sqld;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText)   findViewById(R.id.xetI);
        jetN = (EditText)   findViewById(R.id.xetN);
        jbnA = (Button)     findViewById(R.id.xbnA);
        jbnB = (Button)     findViewById(R.id.xbnB);
        jbnU = (Button)     findViewById(R.id.xbnU);
        jbnL = (Button)     findViewById(R.id.xbnL);
        jtvL = (TextView)   findViewById(R.id.xtvL);
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(new OnClickListener() {                     //Insertar_datos
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                if(id.length() == 0  || nombre.length() == 0 || (id.length() == 0 && nombre.length() == 0))
                    Mostrar_mensaje("Porfavor ingresa todos los datos");
                else {
                    if (Existe_dato(id, nombre)) {
                        Mostrar_mensaje("Dato Existente");
                    } else {
                        Insertar_dato(id, nombre);
                    }
                }
            }
        });
        jbnB.setOnClickListener(new OnClickListener() {                     //Eliminar_datos
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                if(id.length() == 0  || nombre.length() == 0 || (id.length() == 0 && nombre.length() == 0))
                    Mostrar_mensaje("Porfavor ingresa todos los datos");
                else {
                    if (!Existe_dato(id, nombre)) {
                        Mostrar_mensaje("Dato No Existente");
                    } else {
                        Eliminar_dato(id);
                    }
                }
            }
        });
        jbnU.setOnClickListener(new OnClickListener() {                     //Actualizar_datos
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                if(id.length() == 0  || nombre.length() == 0 || (id.length() == 0 && nombre.length() == 0))
                    Mostrar_mensaje("Porfavor ingresa todos los datos");
                else {
                    if (Existe_dato(id, nombre)) {
                        Actualizar_dato(id, nombre);
                    } else {
                        Mostrar_mensaje("Dato No Existente");
                    }
                }
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {                     //Cargar_lista_de_contactos
            public void onClick(View v) {
                String          id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos ORDER BY id", null);
                jtvL.setText("");
                if (c.moveToFirst()){
                    do {
                        id = c.getString(0);
                        nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });
    }

    private void Actualizar_dato(String id, String nombre) {
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("nombre", nombre);
        sqld.update("Contactos", cv, "id = " + id, null);
        jetI.setText(""); jetN.setText("");
    }

    private void Eliminar_dato(String id) {
        sqld.delete("Contactos", "id = " + id, null);
        jetI.setText(""); jetN.setText("");
    }

    private void Insertar_dato(String id, String nombre) {
        ContentValues   cv = new ContentValues();
        cv.put("id", id);
        cv.put("nombre", nombre);
        sqld.insert("Contactos", null, cv);
        jetI.setText(""); jetN.setText("");
    }

    private void Mostrar_mensaje(String cadena) {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity.this);
        mensaje.setMessage(cadena)
                .setPositiveButton("Ok", null);
        AlertDialog alerta = mensaje.create();
        alerta.show();
    }

    private boolean Existe_dato(String id, String nombre) {
        ContentValues   cv = new ContentValues();
        cv.put("id", id);
        cv.put("nombre", nombre);
        Cursor c= sqld.rawQuery("SELECT * FROM Contactos WHERE id ='" + id + "'", null);
        if(c.moveToFirst())
            return true;
        else
            return false;
    }
}
