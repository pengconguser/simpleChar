package gui.Panel;

import Entity.Config;
import Service.ConfigService;
import gui.Listener.ConfigListner;
import gui.util.ColorUtil;
import gui.util.Guiutil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ConfigPanel extends WorkingPanel {
    private static final long serialVersionUID =1L;
    public static ConfigPanel instance = null;

    static {
        try {
            instance = new ConfigPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Guiutil.useLNF();
    }

    public JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");

    public JLabel lConnetionType = new JLabel("数据库类型(支持mysql  hsql)");
    public JTextField tfConnectionType = new JTextField("hsql");

    JButton Bupdate  = new JButton("更新");

    private ConfigPanel() throws IOException {
        Guiutil.setColor(ColorUtil.grayColor,lBudget,lConnetionType);

        Guiutil.setColor(ColorUtil.blueColor,Bupdate);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        int gap = 40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lConnetionType);
        pInput.add(tfConnectionType);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);

        pSubmit.add(Bupdate);
        this.add(pSubmit,BorderLayout.CENTER);

        this.addListener();
    }

    @Override
    public void updateDate()  {
        //从数据库获取配置信息
        ConfigService configService =new ConfigService();
        Config config =configService.selectById(1);

        this.tfBudget.setText(config.getValue());
        this.tfConnectionType.setText(config.getType());
    }

    @Override
    public void addListener() {
        ConfigListner configListner = new ConfigListner();
        this.Bupdate.addActionListener(configListner);
    }

    public static void main(String [] args) {
        Guiutil.showPanel(ConfigPanel.instance);
    }
}
