package gui.util;

import Entity.Record;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class ChartUtil {

    /**
     * 在柱状图下面的文字
     * @param rs
     * @return
     */
    private static String[] sampleLabels(List<Record> rs) {
        String[] sampleLabels = new String[rs.size()];
        for (int i = 0; i < sampleLabels.length; i++) {
             sampleLabels[i] = String.valueOf(i + 1 + "日");
        }

        return sampleLabels;

    }

    public static double[] sampleValues(List<Record> rs) {
        double[] sampleValues = new double[rs.size()];
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = rs.get(i).getSpend();
        }

        return sampleValues;
    }

    public static int max(double [] sampleValues)
    {
        int max =0;
        for (double v: sampleValues){
            if (v>max){
                 max  = (int) v;
            }
        }

        return max;
    }

    /**
     * 在柱状图下的文字
     */
    private static String[] sampleLabels() {
        String[] sampleLabels = new String[3];

        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5) {
                sampleLabels[i] = String.valueOf(i + 1 + "日");
            }
        }

        return sampleLabels;
    }

    public static double[] sampleValues()
    {
        double[] sampleValues = new double[3];
        Arrays.fill(sampleValues, 2.43);

        return sampleValues;
    }

    public static ChartPanel getImage(List<Record> rs, int width, int height)
    {
        // 根据消费记录得到的样本数据
        double[] sampleValues = sampleValues(rs);
        // 根据消费记录得到的下方日期文本
        String[] sampleLabels = sampleLabels(rs);
        // 样本中的最大值
        int max = max(sampleValues);
        // 数据颜色
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (int i=0 ; i<=sampleValues.length-1;i++){
              dataSet.addValue(sampleValues[i],sampleLabels[i],sampleLabels[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "月消费报表", // 图表标题
                "每月消费", // 目录轴的显示标签
                "数量", // 数值轴的显示标签
                dataSet, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                false,      // 是否显示图例(对于简单的柱状图必须是false)
                false,     // 是否生成工具
                false      // 是否生成URL链接
                );

        CategoryPlot categoryplot = chart.getCategoryPlot(); //获得 plot：CategoryPlot！！
        categoryplot.setBackgroundPaint(Color.LIGHT_GRAY); //设定图表数据显示部分背景色
        categoryplot.setDomainGridlinePaint(Color.white); //横坐标网格线白色
        categoryplot.setDomainGridlinesVisible(true); //可见
        categoryplot.setRangeGridlinePaint(Color.white); //纵坐标网格线白色
        categoryplot.setWeight(width);

        ChartPanel chartPanel = new ChartPanel(chart);

        return chartPanel;
    }

}
