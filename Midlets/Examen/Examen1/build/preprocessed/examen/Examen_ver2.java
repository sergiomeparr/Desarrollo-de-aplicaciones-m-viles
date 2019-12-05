package examen;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Examen_ver2 extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    double x1, y1, z1, x2, y2, z2, x3, y3, z3;
    double resultadot;
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form form;
    private TextField textField;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private Command okCommand;
    private Command exitCommand;
    private Command okCommand1;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The Examen_ver2 constructor.
     */
    public Examen_ver2() {
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
                
                exitMIDlet();//GEN-LINE:|7-commandAction|2|18-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|16-preAction
                x1 = Double.parseDouble(textField.getString());
                y1 = Double.parseDouble(textField1.getString());
                z1 = Double.parseDouble(textField2.getString());
                x2 = Double.parseDouble(textField3.getString());
                y2 = Double.parseDouble(textField4.getString());
                z2 = Double.parseDouble(textField5.getString());
                x3 = Double.parseDouble(textField6.getString());
                y3 = Double.parseDouble(textField7.getString());
                z3 = Double.parseDouble(textField8.getString());
                resultadot = calculo_determinante(x1, y1, z1, x2, y2, z2, x3, y3, z3);
                if(resultadot < 0)
                    resultadot = -1* resultadot;
                Perspectiva grafica = new Perspectiva(this, resultadot, x1, y1, z1, x2, y2, z2, x3, y3, z3);
                Display.getDisplay(this).setCurrent(grafica);
//GEN-LINE:|7-commandAction|4|16-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|7-postCommandAction
        }//GEN-END:|7-commandAction|5|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|6|
//</editor-fold>//GEN-END:|7-commandAction|6|


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
form = new Form("form", new Item[]{getTextField(), getTextField1(), getTextField2(), getTextField3(), getTextField4(), getTextField5(), getTextField6(), getTextField7(), getTextField8()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getOkCommand());
            form.addCommand(getExitCommand());
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

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|21-getter|0|21-preInit
 // write pre-init user code here
textField = new TextField("x1", null, 32, TextField.ANY);//GEN-LINE:|21-getter|1|21-postInit
 // write post-init user code here
}//GEN-BEGIN:|21-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|21-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|22-getter|0|22-preInit
 // write pre-init user code here
textField1 = new TextField("y1", null, 32, TextField.ANY);//GEN-LINE:|22-getter|1|22-postInit
 // write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
//GEN-END:|23-getter|0|23-preInit
 // write pre-init user code here
textField2 = new TextField("z1", null, 32, TextField.ANY);//GEN-LINE:|23-getter|1|23-postInit
 // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
        return textField2;
    }
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
//GEN-END:|24-getter|0|24-preInit
 // write pre-init user code here
textField3 = new TextField("x2", null, 32, TextField.ANY);//GEN-LINE:|24-getter|1|24-postInit
 // write post-init user code here
}//GEN-BEGIN:|24-getter|2|
        return textField3;
    }
//</editor-fold>//GEN-END:|24-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initialized instance of textField4 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {
//GEN-END:|25-getter|0|25-preInit
 // write pre-init user code here
textField4 = new TextField("y2", null, 32, TextField.ANY);//GEN-LINE:|25-getter|1|25-postInit
 // write post-init user code here
}//GEN-BEGIN:|25-getter|2|
        return textField4;
    }
//</editor-fold>//GEN-END:|25-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initialized instance of textField5 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {
//GEN-END:|26-getter|0|26-preInit
 // write pre-init user code here
textField5 = new TextField("z2", null, 32, TextField.ANY);//GEN-LINE:|26-getter|1|26-postInit
 // write post-init user code here
}//GEN-BEGIN:|26-getter|2|
        return textField5;
    }
//</editor-fold>//GEN-END:|26-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField6 ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initialized instance of textField6 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField6() {
        if (textField6 == null) {
//GEN-END:|27-getter|0|27-preInit
 // write pre-init user code here
textField6 = new TextField("x3", null, 32, TextField.ANY);//GEN-LINE:|27-getter|1|27-postInit
 // write post-init user code here
}//GEN-BEGIN:|27-getter|2|
        return textField6;
    }
//</editor-fold>//GEN-END:|27-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField7 ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initialized instance of textField7 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField7() {
        if (textField7 == null) {
//GEN-END:|28-getter|0|28-preInit
 // write pre-init user code here
textField7 = new TextField("y3", null, 32, TextField.ANY);//GEN-LINE:|28-getter|1|28-postInit
 // write post-init user code here
}//GEN-BEGIN:|28-getter|2|
        return textField7;
    }
//</editor-fold>//GEN-END:|28-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField8 ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initialized instance of textField8 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField8() {
        if (textField8 == null) {
//GEN-END:|29-getter|0|29-preInit
 // write pre-init user code here
textField8 = new TextField("z3", null, 32, TextField.ANY);//GEN-LINE:|29-getter|1|29-postInit
 // write post-init user code here
}//GEN-BEGIN:|29-getter|2|
        return textField8;
    }
//</editor-fold>//GEN-END:|29-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|31-getter|2|

    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    public void pauseApp() {
        midletPaused = true;
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public double calculo_determinante(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3){
        double resultado;
        resultado = ((((x1*y2*z3)+(x2*y3*z1)+(x3*y1*z2)) - ((z1*y2*x3)+(z2*y3*x1)+(z3*y1*x2)))) / 6;
        return resultado;
    }
}
