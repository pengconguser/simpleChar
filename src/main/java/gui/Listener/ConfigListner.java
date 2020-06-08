package gui.Listener;

import Entity.Config;
import Service.ConfigService;
import gui.Panel.ConfigPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigListner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ConfigPanel configPanel = ConfigPanel.instance;

        ConfigService configService = new ConfigService();
        Config config = configService.selectById(1);

        String type = configPanel.tfConnectionType.getText();
        String value = configPanel.tfBudget.getText();

        if (config == null) {
            Config configData = new Config();
            configData.setValue(value);
            configData.setType(type);

            configService.create(configData);
        } else {
            config.setType(type);
            config.setValue(value);
            configService.update(config);
        }
    }
}
