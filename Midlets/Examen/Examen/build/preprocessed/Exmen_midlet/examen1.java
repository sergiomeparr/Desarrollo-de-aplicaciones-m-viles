/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exmen_midlet;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Sergi
 */
public class examen1 extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form form;
    private TextField textField;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private StringItem stringItem;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private Command okCommand;
    private Command exitCommand;
    private Command exitCommand1;
    private Command okCommand1;
    private Command okCommand2;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The examen1 constructor.
     */
    public examen1() {
        
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
switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
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
if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|18-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|18-preAction
 // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|2|18-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|16-preAction
    double x1, y1, z1, x2, y2, z2, x3, y3, z3;
    x1 = Double.parseDouble(textField.getString());
    y1 = Double.parseDouble(textField1.getString());
    z1 = Double.parseDouble(textField6.getString());
    x2 = Double.parseDouble(textField2.getString());
    y2 = Double.parseDouble(textField3.getString());
    z2 = Double.parseDouble(textField7.getString());
    x3 = Double.parseDouble(textField4.getString());
    y3 = Double.parseDouble(textField5.getString());
    z3 = Double.parseDouble(textField8.getString());
    double resultadot = calculo_determinante(x1, y1, z1, x2, y2, z2, x3, y3, z3);
    if(resultadot < 0)
        resultadot = -1* resultadot;
    stringItem.setText(Double.toString(resultadot));
    
//GEN-LINE:|7-commandAction|4|16-postAction
 // write post-action user code here
} else if (command == okCommand2) {//GEN-LINE:|7-commandAction|5|49-preAction
   
//GEN-LINE:|7-commandAction|6|49-postAction
                
            }//GEN-BEGIN:|7-commandAction|7|7-postCommandAction
        }//GEN-END:|7-commandAction|7|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|8|
//</editor-fold>//GEN-END:|7-commandAction|8|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
 // write pre-init user code here
form = new Form("form", new Item[]{getTextField(), getTextField1(), getTextField6(), getTextField2(), getTextField3(), getTextField7(), getTextField4(), getTextField5(), getTextField8(), getStringItem()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getOkCommand());
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand2());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
 // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|15-getter|0|15-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|15-getter|1|15-postInit
 // write post-init user code here
}//GEN-BEGIN:|15-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|15-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|17-getter|0|17-preInit
 // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|17-getter|1|17-postInit
 // write post-init user code here
}//GEN-BEGIN:|17-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|17-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|30-getter|0|30-preInit
 // write pre-init user code here
textField = new TextField("x1", null, 32, TextField.ANY);//GEN-LINE:|30-getter|1|30-postInit
 // write post-init user code here
}//GEN-BEGIN:|30-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|30-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
textField1 = new TextField("y1", null, 32, TextField.ANY);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
//GEN-END:|32-getter|0|32-preInit
 // write pre-init user code here
textField2 = new TextField("x2", null, 32, TextField.ANY);//GEN-LINE:|32-getter|1|32-postInit
 // write post-init user code here
}//GEN-BEGIN:|32-getter|2|
        return textField2;
    }
//</editor-fold>//GEN-END:|32-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
//GEN-END:|33-getter|0|33-preInit
 // write pre-init user code here
textField3 = new TextField("y2", null, 32, TextField.ANY);//GEN-LINE:|33-getter|1|33-postInit
 // write post-init user code here
}//GEN-BEGIN:|33-getter|2|
        return textField3;
    }
//</editor-fold>//GEN-END:|33-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initialized instance of textField4 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {
//GEN-END:|34-getter|0|34-preInit
 // write pre-init user code here
textField4 = new TextField("x3", null, 32, TextField.ANY);//GEN-LINE:|34-getter|1|34-postInit
 // write post-init user code here
}//GEN-BEGIN:|34-getter|2|
        return textField4;
    }
//</editor-fold>//GEN-END:|34-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|35-getter|0|35-preInit
    /**
     * Returns an initialized instance of textField5 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {
//GEN-END:|35-getter|0|35-preInit
 // write pre-init user code here
textField5 = new TextField("y3", null, 32, TextField.ANY);//GEN-LINE:|35-getter|1|35-postInit
 // write post-init user code here
}//GEN-BEGIN:|35-getter|2|
        return textField5;
    }
//</editor-fold>//GEN-END:|35-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|36-getter|0|36-preInit
 // write pre-init user code here
stringItem = new StringItem("vol\u00FAmen tetraedro", null);//GEN-LINE:|36-getter|1|36-postInit
 // write post-init user code here
}//GEN-BEGIN:|36-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|36-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField6 ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initialized instance of textField6 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField6() {
        if (textField6 == null) {
//GEN-END:|37-getter|0|37-preInit
 // write pre-init user code here
textField6 = new TextField("z1", null, 32, TextField.ANY);//GEN-LINE:|37-getter|1|37-postInit
 // write post-init user code here
}//GEN-BEGIN:|37-getter|2|
        return textField6;
    }
//</editor-fold>//GEN-END:|37-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField7 ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initialized instance of textField7 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField7() {
        if (textField7 == null) {
//GEN-END:|38-getter|0|38-preInit
 // write pre-init user code here
textField7 = new TextField("z2", null, 32, TextField.ANY);//GEN-LINE:|38-getter|1|38-postInit
 // write post-init user code here
}//GEN-BEGIN:|38-getter|2|
        return textField7;
    }
//</editor-fold>//GEN-END:|38-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField8 ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initialized instance of textField8 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField8() {
        if (textField8 == null) {
//GEN-END:|39-getter|0|39-preInit
 // write pre-init user code here
textField8 = new TextField("z3", null, 32, TextField.ANY);//GEN-LINE:|39-getter|1|39-postInit
 // write post-init user code here
}//GEN-BEGIN:|39-getter|2|
        return textField8;
    }
//</editor-fold>//GEN-END:|39-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|42-getter|0|42-preInit
 // write pre-init user code here
exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|42-getter|1|42-postInit
 // write post-init user code here
}//GEN-BEGIN:|42-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|42-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|44-getter|0|44-preInit
 // write pre-init user code here
okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|44-getter|1|44-postInit
 // write post-init user code here
}//GEN-BEGIN:|44-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|44-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {
//GEN-END:|48-getter|0|48-preInit
 // write pre-init user code here
okCommand2 = new Command("Grafica", Command.OK, 0);//GEN-LINE:|48-getter|1|48-postInit
 // write post-init user code here
}//GEN-BEGIN:|48-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|48-getter|2|



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
    
    public double calculo_determinante(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3){
        double resultado;
        resultado = ((((x1*y2*z3)+(x2*y3*z1)+(x3*y1*z2)) - ((z1*y2*x3)+(z2*y3*x1)+(z3*y1*x2)))) / 6;
        return resultado;
    }
}
