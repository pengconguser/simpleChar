package gui.Panel;

import Entity.Category;
import Model.CategoryComboBoxModel;
import Model.CategoryTableModel;
import Service.CategoryService;
import gui.Listener.ReportListener;
import gui.util.ColorUtil;
import gui.util.Guiutil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class RecordPanel extends WorkingPanel {
    private static final long serialVersionUID =1L;
    public static final RecordPanel instance = new RecordPanel();

    //加载默认皮肤
    static {
        Guiutil.useLNF();
    }

    //初始化组件
    public JLabel lSpend = new JLabel("花费(￥)");
    public JLabel lCategory = new JLabel("分类");
    public JLabel lComment = new JLabel("备注");
    public JLabel lDate = new JLabel("日期");


    public JTextField tfSpend = new JTextField("0"); //输入类型
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<String> cbCategory = new JComboBox<String>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());

    JButton bSubmit = new JButton("记一下");

    private RecordPanel()
    {
        Guiutil.setColor(ColorUtil.grayColor,lSpend,lCategory,lComment,lDate);
        Guiutil.setColor(ColorUtil.blueColor,bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit =new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));
        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        this.addListener();
    }

    @Override
    public void updateDate() {
        CategoryService categoryService= new CategoryService();
        List<Category> categories =categoryService.getAll();

        tfComment.setText("");
        tfSpend.setText("");

        if(categories.size() !=0){
            cbCategory.setSelectedItem(0);
        }
        datepick.setDate(new Date());
    }

    @Override
    public void addListener() {
        ReportListener listener = new ReportListener();

        bSubmit.addActionListener(listener);
    }

    public static void main(String [] args) {
        Guiutil.showPanel(RecordPanel.instance);
    }
}
