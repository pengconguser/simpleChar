package gui.util;

import gui.Panel.CenterPanel;
import gui.Panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Guiutil {
    private static String imageFolder = "img";

    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        //设置按钮图标
        b.setIcon(i);
        //设置组件的显示大小
        b.setPreferredSize(new Dimension(61, 81));

        //设置显示的文字
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示画板类
     */
    public static void showPanel(JPanel p , double strech) {
        Guiutil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }

    /**
     * 为一个或者多个组件设置前景色
     * @param color
     * @param cs
     */
    public static void setColor(Color color,JComponent...cs){
        for (JComponent jComponent : cs) {
            jComponent.setForeground(color);
        }
    }


}
