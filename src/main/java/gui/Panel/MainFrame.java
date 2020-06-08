package gui.Panel;

import Helper.Singleton;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final MainFrame instance = new MainFrame();

    private MainFrame()
    {
        //设置窗口大小
        this.setSize(500,450);
        //设置窗口标题
        this.setTitle("by time for up");
        //设置床架的主面板
        this.setContentPane(MainPanel.instance);
        //窗体居中显示
        this.setLocationRelativeTo(null);
        //设置窗体大小是否可调
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
