
package Agenda;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import java.util.Vector;
import javax.microedition.rms.*;

public class Agenda extends MIDlet implements CommandListener{
    private Display d;
    private List lstNombres;
    
    private Form frmNuevo;
    private TextField tfNombre, tfTelefono;
    
    private Command cmAyuda, cmNuevo, cmSalir, cmInformacion, cmRegresaInfo,
            cmRegresar, cmGuardar, cmEliminar, cmActualizar;
    
    private Alert alAviso;
    
    private TextBox txbAyuda, txbInformacion;
    private RecordStore rsNombres;
    private RecordEnumeration reNombres;
    private Vector vetIds = new Vector();
    
    public void startApp() {
        d = Display.getDisplay(this);
        cmAyuda =  new Command("Ayuda", Command.ITEM, 1);
        cmNuevo = new Command("Nuevo", Command.ITEM, 2);
        cmSalir = new Command("Salir", Command.EXIT, 1);
        cmRegresar =  new Command("Regresar", Command.BACK, 1);
        cmGuardar = new Command("Guardar", Command.ITEM, 4);
        cmEliminar = new Command("Eliminar", Command.EXIT, 1);
        cmActualizar = new Command("Actualizar", Command.ITEM, 2);
        cmInformacion =  new Command("Informacion", Command.SCREEN, 1);
        cmRegresaInfo =  new Command("Regresar", Command.BACK, 1);
        
        lstNombres =  new List("Agenda", List.EXCLUSIVE);
        lstNombres.addCommand(cmAyuda);
        lstNombres.addCommand(cmNuevo);
        lstNombres.addCommand(cmSalir);
        lstNombres.addCommand(cmEliminar);
        lstNombres.addCommand(cmActualizar);
        lstNombres.addCommand(cmInformacion);
        lstNombres.setCommandListener((CommandListener) this);
        
        frmNuevo = new Form("Nuevo Contacto");
        frmNuevo.addCommand(cmRegresar);
        frmNuevo.addCommand(cmGuardar);
        frmNuevo.setCommandListener((CommandListener) this);
        
        tfNombre = new TextField("Nombre: ", "", 60, TextField.ANY);
        tfTelefono = new TextField("Tel: ", "", 10, TextField.PHONENUMBER);
        frmNuevo.append(tfNombre);
        frmNuevo.append(tfTelefono);
        
        alAviso =  new Alert("Aviso", "Porfavor ingresa todos los datos", null, AlertType.INFO);
        alAviso.setTimeout(Alert.FOREVER);
        
        txbAyuda =  new TextBox("Ayuda", "Sergio Mendoza Parra Application Development for Mobile Devices", 200, TextField.ANY);
        txbAyuda.addCommand(cmRegresar);
        txbAyuda.setCommandListener((CommandListener) this);
        
        txbInformacion =  new TextBox("Informaciones", "", 300, TextField.ANY);
        txbInformacion.addCommand(cmRegresaInfo);
        txbInformacion.setCommandListener(this);
        d.setCurrent(lstNombres);
        criarBD();
        leerBD();
    }
    
    public void criarBD(){
        try{
            rsNombres = RecordStore.openRecordStore("bdNombres", true);
            System.out.println("Banco de Datos cargado correctamente");
            System.out.println("Nombre" + rsNombres.getName());
            System.out.println("Numero de Registros" + rsNombres.getNumRecords());
            System.out.println("Espacio Ocupado" + rsNombres.getSize());
            System.out.println("Espacio Disponible" + rsNombres.getSizeAvailable());
        }catch(Exception e){
            System.out.println("Error al crear Banco de Datos");
        }
    }
    
    public void alterarDatos(){
        try{
            ByteArrayOutputStream bStream =  new ByteArrayOutputStream();
            DataOutputStream dStream =  new DataOutputStream(bStream);
            dStream.writeUTF(tfNombre.getString());
            dStream.writeUTF(tfTelefono.getString());
            dStream.flush();
            byte[] datos = bStream.toByteArray();
            rsNombres.setRecord(Integer.parseInt(vetIds.elementAt(lstNombres.getSelectedIndex()).toString()), datos, 0, datos.length);
            bStream.close();
            dStream.close();
        }catch(Exception err){
            System.out.println("Error al insertar datos"+ err);
        }
    }
    
    public void insertarDatos(){
        try{
            ByteArrayOutputStream bStream =  new ByteArrayOutputStream();
            DataOutputStream dStream =  new DataOutputStream(bStream);
            dStream.writeUTF(tfNombre.getString());
            dStream.writeUTF(tfTelefono.getString());
            dStream.flush();
            byte[] datos = bStream.toByteArray();
            rsNombres.addRecord(datos, 0, datos.length);   //Insertando datos
            bStream.close();
            dStream.close();
        }catch(Exception err){
            System.out.println("Error al insertar datos"+ err);
        }
    }
    
    public void leerBD(){
        try{
            while(lstNombres.size() > 0)
                lstNombres.delete(0);   //Limpiar lista
            ByteArrayInputStream inputStream =  null;
            DataInputStream dataStream =  null;
            reNombres =  rsNombres.enumerateRecords(null, null, false);
            int id = 0;
            byte[] datos =  null;
            vetIds.removeAllElements();
            while(reNombres.hasNextElement()){
                id = reNombres.nextRecordId();
                vetIds.addElement(""+id);
                datos = rsNombres.getRecord(id);
                inputStream = new ByteArrayInputStream(datos);
                dataStream =  new DataInputStream(inputStream);
                lstNombres.append(dataStream.readUTF() + " - " + dataStream.readUTF(), null);
                //lstNombres.append(dataStream.readUTF(), null);
            
            }
            inputStream.close();
            dataStream.close();
        }catch(Exception err){
            System.out.println("Error al leer el Banco de Datos");
        }
    }
    
    public void Eliminar(){
        try{
            int indice =  lstNombres.getSelectedIndex();
            rsNombres.deleteRecord(Integer.parseInt(vetIds.elementAt(indice).toString()));
            leerBD();
        }catch(Exception err){
            System.out.println("No se pudo eliminar dato");
        }
    }
    
    public void commandAction(Command c, Displayable dis) {
        if(c ==  cmSalir){
            destroyApp(true);
            notifyDestroyed();
        }
        else if(c == cmNuevo){
            tfNombre.setString("");
            tfTelefono.setString("");
            d.setCurrent(frmNuevo);
        
        }
        else if(c == cmActualizar){
            String nombre_tel = lstNombres.getString(lstNombres.getSelectedIndex());
            tfNombre.setString(nombre_tel.substring(0, nombre_tel.indexOf("-") - 1));
            tfTelefono.setString(nombre_tel.substring(nombre_tel.indexOf("-") + 2));
            Eliminar();
            d.setCurrent(frmNuevo);
        }
        else if(c == cmEliminar)
            Eliminar();
        else if(c == cmInformacion){
            try {                                   
                txbInformacion.setString("Nombre:" + rsNombres.getName() +                
                                        "Numero de Registros" + rsNombres.getNumRecords() +
                                        "Espacio Ocupado" + rsNombres.getSize() + 
                                        "Espacio Disponible" + rsNombres.getSizeAvailable());
                d.setCurrent(txbInformacion);
            } catch (RecordStoreNotOpenException ex) {
                ex.printStackTrace();
            }
        }
        else if(c == cmRegresar || c == cmRegresaInfo) 
            d.setCurrent(lstNombres);
        else if(c == cmGuardar){
            if(tfNombre.getString().length() > 0 &&
               tfTelefono.getString().length() > 0){
                
                    lstNombres.append(tfNombre.getString(), null);
                    
                    insertarDatos();
                    
                    tfNombre.setString("");
                    tfTelefono.setString("");
                    
                    d.setCurrent(lstNombres);
            }
            else
                d.setCurrent(alAviso);
        }
        else if(c == cmAyuda)
            d.setCurrent(txbAyuda);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

}
