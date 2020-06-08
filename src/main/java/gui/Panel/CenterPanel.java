package gui.Panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CenterPanel extends JPanel {
    private static final long serialVersionUID =1L;

    private double rate; //拉伸比例
    private JComponent c; //显示的组件
    private boolean strech; //是否拉伸

    /**
     * 排除默认构造
     * @param rate
     * @param strech
     */
    public CenterPanel(double rate,boolean strech)
    {
        this.setLayout(null);
        this.rate= rate;
        this.strech = strech;
    }

    //默认拉伸
    public CenterPanel(double rate)
    {
        this(rate,true);
    }

    /**
     * 刷新方法
     */
    public void repaint()
    {
        if(this.c != null){
            Dimension containerSize =this.getSize();
            Dimension componentSize = c.getPreferredSize();

            if(this.strech){
                 c.setSize((int)(containerSize.width*this.rate),(int)(containerSize.height*this.rate));
            }else{
                 c.setSize(componentSize);
                 c.setLocation(containerSize.width/2 - c.getSize().width/2,containerSize.height/2 - c.getSize().height/2);
            }
        }

        super.repaint();
    }

    /**
     * 显示面板
     */

    public void show(JComponent p) {
        this.c = p;
        //获取在显示框架上的全部面板  并移除
        Component [] cs =this.getComponents();

        for (Component c:cs) {
            this.remove(c);
        }

        /**
         * 判断需要显示的面板是否带WorkingPanel
         * 如果是的话 需要 updateDate()来让数据同步
         */
        if (p instanceof WorkingPanel){
            ((WorkingPanel) p).updateDate();
        }

        this.add(p);

        this.updateUI();
    }
}
