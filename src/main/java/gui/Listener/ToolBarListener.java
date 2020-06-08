package gui.Listener;

import gui.Panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //获取主面板实例
        MainPanel p = MainPanel.instance;
        //获取点击的按钮
        JButton b = (JButton) actionEvent.getSource();
        /**
         * 按钮类不能作为switch的参数所以这里全部使用if判断语句
         *	获取备份面板的实例 并将其显示在工作区面板
         */
        if (b == p.bSpend) {
            p.workingPanel.show(SpendPanel.instance);
        }

        if (b == p.bRecord) {
            p.workingPanel.show(RecordPanel.instance);
        }

        if (b == p.bCategory) {
            p.workingPanel.show(CategoryPanel.instance);
        }

        if (b == p.bReport) {
            p.workingPanel.show(ReportPanel.instance);
        }

        if (b == p.bConfig) {
            p.workingPanel.show(ConfigPanel.instance);
        }

        if (b == p.bBackup) {
            p.workingPanel.show(BackupPanel.instance);
        }

        if (b == p.bRecover) {
            p.workingPanel.show(RecoverPanel.instance);
        }
    }
}
