package gui.Panel;

import gui.util.ColorUtil;
import gui.util.Guiutil;

import javax.swing.*;
import java.io.IOException;

public class RecoverPanel extends WorkingPanel {
    private static final long serialVersionUID = 1L;

    public static final RecoverPanel instance = new RecoverPanel();

    public JButton lCover = new JButton("恢复");

    private RecoverPanel() {
        Guiutil.setColor(ColorUtil.blueColor,lCover);

        this.add(lCover);
        this.addListener();
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String[] arg) {
        Guiutil.showPanel(RecoverPanel.instance);
    }
}
