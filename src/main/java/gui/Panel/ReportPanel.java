package gui.Panel;

import Entity.Record;
import Service.RecordService;
import gui.util.ChartUtil;
import gui.util.Guiutil;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportPanel extends WorkingPanel {
    private static final long serialVersionUID= 1L;

    public static final ReportPanel instance = new ReportPanel();


    public JLabel Jl =new JLabel();

    private ReportPanel()
    {
        this.setLayout(new BorderLayout());

        RecordService recordService = new RecordService();
        List<Record> rs = (List<Record>) recordService.getThisMonthRecords();

        ChartPanel chartPanel = ChartUtil.getImage(rs,400,300);
        this.add(chartPanel);

        this.add(Jl);
        this.addListener();
    }

    @Override
    public void updateDate() {
        RecordService recordService = new RecordService();

        List< Record > rs = recordService.getThisMonthRecords();
        ChartPanel chartPanel = ChartUtil.getImage(rs,400,300);
        this.add(chartPanel);

    }

    @Override
    public void addListener() {

    }

    public static void main(String [] arg) {
        Guiutil.showPanel(ReportPanel.instance);
    }
}
