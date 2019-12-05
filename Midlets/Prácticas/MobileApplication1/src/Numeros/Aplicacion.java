/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numeros;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Sergi
 */
public class Aplicacion extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    private int posiciones = 0, posiciones1 = 0, posiciones2 = 0;
  
    int posiciones_fibo = 1;
    int posiciones_primos = 0;
    private int[] arreglo =  new int[1500];
    private int[] aux =  new int[1500];
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form Naturales;
    private TextField textField;
    private StringItem stringItem;
    private StringItem stringItem1;
    private List list;
    private Form Primos;
    private TextField textField1;
    private StringItem stringItem2;
    private StringItem stringItem6;
    private Form Fibonacci;
    private TextField textField2;
    private StringItem stringItem3;
    private StringItem stringItem5;
    private Form Palindrome;
    private TextField textField3;
    private StringItem stringItem4;
    private Command exitCommand;
    private Command okCommand;
    private Command exitCommand1;
    private Command okCommand1;
    private Command exitCommand2;
    private Command okCommand2;
    private Command exitCommand3;
    private Command okCommand3;
    private Command exitCommand4;
    private Command okCommand4;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The Aplicacion constructor.
     */
    public Aplicacion() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
 // write pre-action user code here
if (displayable == Fibonacci) {//GEN-BEGIN:|7-commandAction|1|41-preAction
            if (command == exitCommand2) {//GEN-END:|7-commandAction|1|41-preAction
 // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|41-postAction
 // write post-action user code here
} else if (command == okCommand2) {//GEN-LINE:|7-commandAction|3|43-preAction
    boolean rsul2 = false;
    String cadena_fibo =  new String();
    String cadena_fibo_res =  new String();
    int fibo = Integer.parseInt(textField2.getString());
    rsul2 = Fibonacci(fibo);
    for(int i = 0; i < posiciones_fibo; i++){
        cadena_fibo = Integer.toString(arreglo[i]);
        cadena_fibo_res = cadena_fibo_res + ", " + cadena_fibo;
    }
    stringItem5.setText(cadena_fibo_res);
    if(rsul2)
            stringItem3.setText("El numero: " + fibo + ", Es Fibonacci!!");
    else
            stringItem3.setText("El numero: " + fibo + ", No Es Fibonacci!!");

//GEN-LINE:|7-commandAction|4|43-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|28-preAction
} else if (displayable == Naturales) {
    if (command == exitCommand) {//GEN-END:|7-commandAction|5|28-preAction
 // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|6|28-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|7|30-preAction
    posiciones = 0;
    String cadena = new String();
    String cadena_aux =  new String();
    int[] resultado =  new int[1500];
    int[] auxiliar = new int [1500];  
    int contador = 0;
    int dato =  Integer.parseInt(textField.getString());
    resultado = numeros_maravillosos(dato, auxiliar);
    for(int i = 0; i < posiciones; i++){
        cadena = Integer.toString(resultado[i]);
        cadena_aux = cadena_aux + ", " + cadena;
    }
    stringItem.setText(cadena_aux);
    if(resultado[posiciones - 1] == 1)
        stringItem1.setText("Numero Maravilloso!!");
    else
        stringItem1.setText("Numero No Maravilloso!!");
    
//GEN-LINE:|7-commandAction|8|30-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|9|49-preAction
} else if (displayable == Palindrome) {
    if (command == exitCommand3) {//GEN-END:|7-commandAction|9|49-preAction
 // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|10|49-postAction
 // write post-action user code here
} else if (command == okCommand3) {//GEN-LINE:|7-commandAction|11|51-preAction
    boolean rsul3 =  false;
    String campo = textField3.getString();
    rsul3 = Palindromo(campo);
    if(rsul3)
            stringItem4.setText("La palabra si es palindroma");
    else
            stringItem4.setText("La palabra no es palindroma");

//GEN-LINE:|7-commandAction|12|51-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|13|35-preAction
} else if (displayable == Primos) {
    if (command == exitCommand1) {//GEN-END:|7-commandAction|13|35-preAction
 // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|14|35-postAction
 // write post-action user code here
} else if (command == okCommand1) {//GEN-LINE:|7-commandAction|15|37-preAction
    posiciones_primos = 0;    
    int primo = Integer.parseInt(textField1.getString());
    String cadena_primo =  new String();
    String cadena_primo_resul =  new String();
    boolean resul_primos = false;
    resul_primos = Criba(aux, primo); 
    for(int i = 0; i <= posiciones_primos; i++){
        cadena_primo = Integer.toString(aux[i]);
        cadena_primo_resul = cadena_primo_resul + ", " + cadena_primo;
    }
    stringItem6.setText(cadena_primo_resul);
    if(resul_primos)
            stringItem2.setText("El numero: " + primo + ", Es primo!");
    else
            stringItem2.setText("El numero: " + primo + ", No es primo!");
//GEN-LINE:|7-commandAction|16|37-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|17|17-preAction
} else if (displayable == list) {
    if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|17-preAction
 // write pre-action user code here
listAction();//GEN-LINE:|7-commandAction|18|17-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|19|7-postCommandAction
        }//GEN-END:|7-commandAction|19|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|20|
//</editor-fold>//GEN-END:|7-commandAction|20|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Naturales ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of Naturales component.
     *
     * @return the initialized component instance
     */
    public Form getNaturales() {
        if (Naturales == null) {
//GEN-END:|14-getter|0|14-preInit
 // write pre-init user code here
Naturales = new Form("form", new Item[]{getTextField(), getStringItem(), getStringItem1()});//GEN-BEGIN:|14-getter|1|14-postInit
            Naturales.addCommand(getExitCommand());
            Naturales.addCommand(getOkCommand());
            Naturales.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
 // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return Naturales;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {
//GEN-END:|15-getter|0|15-preInit
 // write pre-init user code here
list = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|15-getter|1|15-postInit
            list.append("Numeros Naturales", null);
            list.append("Numeros Primos", null);
            list.append("Fibonacci", null);
            list.append("Palindrome", null);
            list.append("Salir", null);
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[]{false, false, false, false, false});//GEN-END:|15-getter|1|15-postInit
 // write post-init user code here
}//GEN-BEGIN:|15-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|15-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|15-action|0|15-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {
//GEN-END:|15-action|0|15-preAction
 // enter pre-action user code here
String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|15-action|1|19-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Numeros Naturales")) {//GEN-END:|15-action|1|19-preAction
 // write pre-action user code here
switchDisplayable(null, getNaturales());//GEN-LINE:|15-action|2|19-postAction
 // write post-action user code here
} else if (__selectedString.equals("Numeros Primos")) {//GEN-LINE:|15-action|3|20-preAction
 // write pre-action user code here
switchDisplayable(null, getPrimos());//GEN-LINE:|15-action|4|20-postAction
 // write post-action user code here
} else if (__selectedString.equals("Fibonacci")) {//GEN-LINE:|15-action|5|21-preAction
 // write pre-action user code here
switchDisplayable(null, getFibonacci());//GEN-LINE:|15-action|6|21-postAction
 // write post-action user code here
} else if (__selectedString.equals("Palindrome")) {//GEN-LINE:|15-action|7|22-preAction
 // write pre-action user code here
switchDisplayable(null, getPalindrome());//GEN-LINE:|15-action|8|22-postAction
 // write post-action user code here
} else if (__selectedString.equals("Salir")) {//GEN-LINE:|15-action|9|24-preAction
 // write pre-action user code here
exitMIDlet();//GEN-LINE:|15-action|10|24-postAction
 // write post-action user code here
}//GEN-BEGIN:|15-action|11|15-postAction
        }//GEN-END:|15-action|11|15-postAction
 // enter post-action user code here
}//GEN-BEGIN:|15-action|12|
//</editor-fold>//GEN-END:|15-action|12|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Primos ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initialized instance of Primos component.
     *
     * @return the initialized component instance
     */
    public Form getPrimos() {
        if (Primos == null) {
//GEN-END:|33-getter|0|33-preInit
 // write pre-init user code here
Primos = new Form("form1", new Item[]{getTextField1(), getStringItem2(), getStringItem6()});//GEN-BEGIN:|33-getter|1|33-postInit
            Primos.addCommand(getExitCommand1());
            Primos.addCommand(getOkCommand1());
            Primos.setCommandListener(this);//GEN-END:|33-getter|1|33-postInit
 // write post-init user code here
}//GEN-BEGIN:|33-getter|2|
        return Primos;
    }
//</editor-fold>//GEN-END:|33-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Fibonacci ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initialized instance of Fibonacci component.
     *
     * @return the initialized component instance
     */
    public Form getFibonacci() {
        if (Fibonacci == null) {
//GEN-END:|39-getter|0|39-preInit
 // write pre-init user code here
Fibonacci = new Form("form", new Item[]{getTextField2(), getStringItem3(), getStringItem5()});//GEN-BEGIN:|39-getter|1|39-postInit
            Fibonacci.addCommand(getExitCommand2());
            Fibonacci.addCommand(getOkCommand2());
            Fibonacci.setCommandListener(this);//GEN-END:|39-getter|1|39-postInit
 // write post-init user code here
}//GEN-BEGIN:|39-getter|2|
        return Fibonacci;
    }
//</editor-fold>//GEN-END:|39-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Palindrome ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initialized instance of Palindrome component.
     *
     * @return the initialized component instance
     */
    public Form getPalindrome() {
        if (Palindrome == null) {
//GEN-END:|47-getter|0|47-preInit
 // write pre-init user code here
Palindrome = new Form("form", new Item[]{getTextField3(), getStringItem4()});//GEN-BEGIN:|47-getter|1|47-postInit
            Palindrome.addCommand(getExitCommand3());
            Palindrome.addCommand(getOkCommand3());
            Palindrome.setCommandListener(this);//GEN-END:|47-getter|1|47-postInit
 // write post-init user code here
}//GEN-BEGIN:|47-getter|2|
        return Palindrome;
    }
//</editor-fold>//GEN-END:|47-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|27-getter|0|27-preInit
 // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|27-getter|1|27-postInit
 // write post-init user code here
}//GEN-BEGIN:|27-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|27-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|29-getter|0|29-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|29-getter|1|29-postInit
 // write post-init user code here
}//GEN-BEGIN:|29-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|29-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|34-getter|0|34-preInit
 // write pre-init user code here
exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|34-getter|1|34-postInit
 // write post-init user code here
}//GEN-BEGIN:|34-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|34-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|36-getter|0|36-preInit
 // write pre-init user code here
okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|36-getter|1|36-postInit
 // write post-init user code here
}//GEN-BEGIN:|36-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|36-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initialized instance of exitCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {
//GEN-END:|40-getter|0|40-preInit
 // write pre-init user code here
exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|40-getter|1|40-postInit
 // write post-init user code here
}//GEN-BEGIN:|40-getter|2|
        return exitCommand2;
    }
//</editor-fold>//GEN-END:|40-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {
//GEN-END:|42-getter|0|42-preInit
 // write pre-init user code here
okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|42-getter|1|42-postInit
 // write post-init user code here
}//GEN-BEGIN:|42-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|42-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand3 ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initialized instance of exitCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand3() {
        if (exitCommand3 == null) {
//GEN-END:|48-getter|0|48-preInit
 // write pre-init user code here
exitCommand3 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|48-getter|1|48-postInit
 // write post-init user code here
}//GEN-BEGIN:|48-getter|2|
        return exitCommand3;
    }
//</editor-fold>//GEN-END:|48-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initialized instance of okCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand3() {
        if (okCommand3 == null) {
//GEN-END:|50-getter|0|50-preInit
 // write pre-init user code here
okCommand3 = new Command("Ok", Command.OK, 0);//GEN-LINE:|50-getter|1|50-postInit
 // write post-init user code here
}//GEN-BEGIN:|50-getter|2|
        return okCommand3;
    }
//</editor-fold>//GEN-END:|50-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand4 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initialized instance of exitCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand4() {
        if (exitCommand4 == null) {
//GEN-END:|56-getter|0|56-preInit
 // write pre-init user code here
exitCommand4 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|56-getter|1|56-postInit
 // write post-init user code here
}//GEN-BEGIN:|56-getter|2|
        return exitCommand4;
    }
//</editor-fold>//GEN-END:|56-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand4 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initialized instance of okCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand4() {
        if (okCommand4 == null) {
//GEN-END:|58-getter|0|58-preInit
 // write pre-init user code here
okCommand4 = new Command("Ok", Command.OK, 0);//GEN-LINE:|58-getter|1|58-postInit
 // write post-init user code here
}//GEN-BEGIN:|58-getter|2|
        return okCommand4;
    }
//</editor-fold>//GEN-END:|58-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|61-getter|0|61-preInit
 // write pre-init user code here
textField = new TextField("Numeros", null, 32, TextField.ANY);//GEN-LINE:|61-getter|1|61-postInit
 // write post-init user code here
}//GEN-BEGIN:|61-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|61-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|62-getter|0|62-preInit
 // write pre-init user code here
stringItem = new StringItem("Datos", null);//GEN-LINE:|62-getter|1|62-postInit
 // write post-init user code here
}//GEN-BEGIN:|62-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|62-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|63-getter|0|63-preInit
    /**
     * Returns an initialized instance of stringItem1 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {
//GEN-END:|63-getter|0|63-preInit
 // write pre-init user code here
stringItem1 = new StringItem("Resultado", null);//GEN-LINE:|63-getter|1|63-postInit
 // write post-init user code here
}//GEN-BEGIN:|63-getter|2|
        return stringItem1;
    }
//</editor-fold>//GEN-END:|63-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|64-getter|0|64-preInit
 // write pre-init user code here
textField1 = new TextField("Numero", null, 32, TextField.ANY);//GEN-LINE:|64-getter|1|64-postInit
 // write post-init user code here
}//GEN-BEGIN:|64-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|64-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initialized instance of stringItem2 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {
//GEN-END:|65-getter|0|65-preInit
 // write pre-init user code here
stringItem2 = new StringItem("Resultado", null);//GEN-LINE:|65-getter|1|65-postInit
 // write post-init user code here
}//GEN-BEGIN:|65-getter|2|
        return stringItem2;
    }
//</editor-fold>//GEN-END:|65-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
//GEN-END:|66-getter|0|66-preInit
 // write pre-init user code here
textField2 = new TextField("Numero ", null, 32, TextField.ANY);//GEN-LINE:|66-getter|1|66-postInit
 // write post-init user code here
}//GEN-BEGIN:|66-getter|2|
        return textField2;
    }
//</editor-fold>//GEN-END:|66-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initialized instance of stringItem3 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {
//GEN-END:|67-getter|0|67-preInit
 // write pre-init user code here
stringItem3 = new StringItem("Resultado ", null);//GEN-LINE:|67-getter|1|67-postInit
 // write post-init user code here
}//GEN-BEGIN:|67-getter|2|
        return stringItem3;
    }
//</editor-fold>//GEN-END:|67-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
//GEN-END:|68-getter|0|68-preInit
 // write pre-init user code here
textField3 = new TextField("Palabra", null, 32, TextField.ANY);//GEN-LINE:|68-getter|1|68-postInit
 // write post-init user code here
}//GEN-BEGIN:|68-getter|2|
        return textField3;
    }
//</editor-fold>//GEN-END:|68-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initialized instance of stringItem4 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {
//GEN-END:|69-getter|0|69-preInit
 // write pre-init user code here
stringItem4 = new StringItem("Resultado ", null);//GEN-LINE:|69-getter|1|69-postInit
 // write post-init user code here
}//GEN-BEGIN:|69-getter|2|
        return stringItem4;
    }
//</editor-fold>//GEN-END:|69-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initialized instance of stringItem5 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem5() {
        if (stringItem5 == null) {
//GEN-END:|70-getter|0|70-preInit
 // write pre-init user code here
stringItem5 = new StringItem("Cadena", null);//GEN-LINE:|70-getter|1|70-postInit
 // write post-init user code here
}//GEN-BEGIN:|70-getter|2|
        return stringItem5;
    }
//</editor-fold>//GEN-END:|70-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem6 ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initialized instance of stringItem6 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem6() {
        if (stringItem6 == null) {
//GEN-END:|71-getter|0|71-preInit
 // write pre-init user code here
stringItem6 = new StringItem("Cadena", null);//GEN-LINE:|71-getter|1|71-postInit
 // write post-init user code here
}//GEN-BEGIN:|71-getter|2|
        return stringItem6;
    }
//</editor-fold>//GEN-END:|71-getter|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    
    private int[] numeros_maravillosos(int dato, int[] arreglo) {
        if(dato == 2){
            arreglo[posiciones] = dato;
            posiciones++;
            arreglo[posiciones] = dato / 2;
            posiciones++;
            return arreglo;
        }else{
            arreglo[posiciones] = dato;
            if(dato % 2 == 0)
                dato = dato / 2;
            else
                dato = (dato * 3) + 1;
            posiciones++;
            return numeros_maravillosos(dato, arreglo);
        }    
    }

    private boolean Criba(int[] aux, int primo) {
        boolean resultado = false;
        int contador = 0;
        int bandera = 0;
        for(int i = 2; i <= primo; i++){
            for(int j = 2; j <= i; j++){
                if(i % j == 0)
                    bandera++;
            }
            if(bandera == 1){
                aux[contador] = i;
                contador++;
            }
            bandera = 0;
        }
        for(int i = 0; i < contador; i++){
            if(primo == aux[i]){
                resultado = true;
                break;
            }
            posiciones_primos++;
        }
        return resultado;
    }

    private boolean Fibonacci(int fibo) {
        boolean resultado =  false;
        posiciones_fibo = 1;
        arreglo[0] = 0;
        arreglo[1] = 1;
        int posiciones_aux = 1; 
        for(int i = 2; i < fibo + 1; i++){
            arreglo[i]  = arreglo[i - 1] + arreglo[i - 2];
            posiciones_aux++;
        }
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == fibo){
                resultado =  true;
                break;
            }
            posiciones_fibo++;
        }
        if(!resultado)
            posiciones_fibo = posiciones_aux / 3; 
        
        return resultado;
    }

    private boolean Palindromo(String cadena2) {
        boolean resultado = true;
        int contador = cadena2.length();
        int contador2 = 0;
        int contador3 = 0;
        char[] auxiliar =  new char[contador];
        char[] cadena =  new char[contador];
        char[] auxiliar2 =  new char[contador];
        cadena = cadena2.toCharArray();
        for(int i = 0; i < contador ; i++){
            if(cadena[i] != 32){
                auxiliar2[contador3] = cadena[i];
                contador3++;
            }
        }
        for(int i = contador - 1; i >= 0 ; i --){
            if(cadena[i] != 32){
                auxiliar[contador2] = cadena[i];
                contador2++;
            }
        }
        contador2 = auxiliar.length;
        contador3 = contador2;
        for(int i = 0; i < contador2 - 1; i++){
            if(auxiliar[i] != auxiliar2[i]){
                resultado =  false;
                break;
            }
            contador3--;
        }
        return resultado;
    }
}
    

