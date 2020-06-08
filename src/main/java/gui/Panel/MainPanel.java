package gui.Panel;

import Helper.Singleton;
import gui.Listener.ToolBarListener;
import gui.util.Guiutil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JPanel {
    private static final long serialVersionUID= 1L;

    public static final MainPanel instance = new MainPanel();

    //在界面渲染前加载皮肤
    static {
        Guiutil.useLNF();
    }

    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton("消费一览");
    public JButton bRecord =new JButton("记录");
    public JButton bCategory = new JButton("消费分类");
    public JButton bReport = new JButton("月消费报表");
    public JButton bConfig = new JButton("设置");
    public JButton bBackup = new JButton("备份");
    public JButton bRecover = new JButton("恢复");

    public CenterPanel workingPanel;

    private MainPanel(){
        Guiutil.setImageIcon(bSpend, "home.png","消费一览");
        Guiutil.setImageIcon(bRecord, "record.png","记一笔");
        Guiutil.setImageIcon(bCategory, "category2.png", "消费分类");
        Guiutil.setImageIcon(bReport, "report.png", "月消费报表");
        Guiutil.setImageIcon(bConfig, "config.png", "设置");
        Guiutil.setImageIcon(bBackup, "backup.png", "备份");
        Guiutil.setImageIcon(bRecover, "restore.png", "恢复");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);

        //用户不能移动工具栏
        tb.setFloatable(false);

        this.workingPanel = new CenterPanel(0.8);

        setLayout(new BorderLayout());
        //将工具栏在界面上方显示
        this.add(tb, BorderLayout.NORTH);
        //主要的工作区域在中间
        this.add(this.workingPanel,BorderLayout.CENTER);

        this.workingPanel.add(SpendPanel.instance);

        this.ButtonListener();
    }

    public void ButtonListener()
    {
        ToolBarListener tbl =new ToolBarListener();
        bBackup.addActionListener(tbl);
        bSpend.addActionListener(tbl);
        bCategory.addActionListener(tbl);
        bConfig.addActionListener(tbl);
        bRecord.addActionListener(tbl);
        bReport.addActionListener(tbl);
        bRecover.addActionListener(tbl);
    }

    public static void main(String [] args) {
        Guiutil.showPanel(MainPanel.instance,1);
    }
}
