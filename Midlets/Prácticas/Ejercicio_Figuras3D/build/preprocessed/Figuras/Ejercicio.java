package Figuras;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Ejercicio extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    Cubo grafica = new Cubo(this);
    Piramide grafica2 = new Piramide(this);
    Esfera grafica3 = new Esfera(this);
    Cilindro grafica4 = new Cilindro(this);
    Cono grafica5 =  new Cono(this);
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List list;
    private Command exitCommand;
    private Command exitCommand1;
    private Command exitCommand2;
    private Command exitCommand3;
    private Command exitCommand4;
//</editor-fold>//GEN-END:|fields|0|
    public Ejercicio() {
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
if (displayable == list) {//GEN-BEGIN:|7-commandAction|1|17-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|17-preAction
 // write pre-action user code here
listAction();//GEN-LINE:|7-commandAction|2|17-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|3|7-postCommandAction
        }//GEN-END:|7-commandAction|3|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|4|
//</editor-fold>//GEN-END:|7-commandAction|4|


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
            list.append("Cubo", null);
            list.append("Pir\u00E1mide", null);
            list.append("Esfera", null);
            list.append("Cilindro", null);
            list.append("Cono", null);
            list.append("Salir", null);
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[]{false, false, false, false, false, false});//GEN-END:|15-getter|1|15-postInit
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
            if (__selectedString.equals("Cubo")) {//GEN-END:|15-action|1|19-preAction
                  Display.getDisplay(this).setCurrent(grafica);
                  
//GEN-LINE:|15-action|2|19-postAction
 // write post-action user code here
} else if (__selectedString.equals("Pir\u00E1mide")) {//GEN-LINE:|15-action|3|20-preAction
                  Display.getDisplay(this).setCurrent(grafica2);
//GEN-LINE:|15-action|4|20-postAction
 // write post-action user code here
} else if (__selectedString.equals("Esfera")) {//GEN-LINE:|15-action|5|21-preAction
                  Display.getDisplay(this).setCurrent(grafica3);
//GEN-LINE:|15-action|6|21-postAction
 // write post-action user code here
} else if (__selectedString.equals("Cilindro")) {//GEN-LINE:|15-action|7|22-preAction
                  Display.getDisplay(this).setCurrent(grafica4);
//GEN-LINE:|15-action|8|22-postAction
 // write post-action user code here
} else if (__selectedString.equals("Cono")) {//GEN-LINE:|15-action|9|23-preAction
                  Display.getDisplay(this).setCurrent(grafica5);
//GEN-LINE:|15-action|10|23-postAction
 // write post-action user code here
} else if (__selectedString.equals("Salir")) {//GEN-LINE:|15-action|11|28-preAction
 // write pre-action user code here
exitMIDlet();//GEN-LINE:|15-action|12|28-postAction
 // write post-action user code here
}//GEN-BEGIN:|15-action|13|15-postAction
        }//GEN-END:|15-action|13|15-postAction
 // enter post-action user code here
}//GEN-BEGIN:|15-action|14|
//</editor-fold>//GEN-END:|15-action|14|




//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|32-getter|0|32-preInit
 // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|32-getter|1|32-postInit
 // write post-init user code here
}//GEN-BEGIN:|32-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|32-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|40-getter|0|40-preInit
 // write pre-init user code here
exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|40-getter|1|40-postInit
 // write post-init user code here
}//GEN-BEGIN:|40-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|40-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initialized instance of exitCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {
//GEN-END:|44-getter|0|44-preInit
 // write pre-init user code here
exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|44-getter|1|44-postInit
 // write post-init user code here
}//GEN-BEGIN:|44-getter|2|
        return exitCommand2;
    }
//</editor-fold>//GEN-END:|44-getter|2|

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

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand4 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initialized instance of exitCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand4() {
        if (exitCommand4 == null) {
//GEN-END:|52-getter|0|52-preInit
 // write pre-init user code here
exitCommand4 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|52-getter|1|52-postInit
 // write post-init user code here
}//GEN-BEGIN:|52-getter|2|
        return exitCommand4;
    }
//</editor-fold>//GEN-END:|52-getter|2|

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
    
}
