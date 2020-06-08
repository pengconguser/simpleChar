
import gui.Panel.MainFrame;
import gui.Panel.MainPanel;
import gui.Panel.SpendPanel;
import gui.util.Guiutil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Boot {
    public static void main(String [] args) throws InvocationTargetException, InterruptedException {
        Guiutil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }   
        });
    }
}
