package gui.Panel;


import gui.util.ColorUtil;
import gui.util.Guiutil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BackupPanel extends WorkingPanel {
    private static final long serialVersionUID =1L;

    public static final BackupPanel instance = new BackupPanel();

    static {
        Guiutil.useLNF();
    }

    JButton lBack = new JButton("备份");

    private BackupPanel()
    {
        Guiutil.setColor(ColorUtil.blueColor,lBack);
        this.add(lBack);

        this.addListener();
    }


    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String [] arg) {
        Guiutil.showPanel(BackupPanel.instance);
    }
}
