package gui.Panel;

import Entity.Category;
import Model.CategoryTableModel;
import Service.CategoryService;
import gui.Listener.CategoryListener;
import gui.util.ColorUtil;
import gui.util.Guiutil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CategoryPanel extends WorkingPanel {
    private static final long serialVersionUID =1L;
    public static final CategoryPanel instance = new CategoryPanel();

    static {
        Guiutil.useLNF();
    }

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    public String colunmNames[]  =  new String[]{"分类名称","消费次数"};
    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable Jt = new JTable(ctm);

    private CategoryPanel()
    {
        Guiutil.setColor(ColorUtil.blueColor);
        JScrollPane sp =new JScrollPane(Jt);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        this.addListener();

    }


    @Override
    public void updateDate() {
        CategoryService categoryService =new CategoryService();
        this.ctm.categories  = categoryService.getAll();

        Jt.updateUI();
        Jt.getSelectionModel().setSelectionInterval(0,0);

        if(ctm.categories.size() == 0){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);

    }

    /**
     * 获取当前选中的类别
     * @return
     */
    public Category getSelectCategory(){
         int index =Jt.getSelectedRow();
         return ctm.categories.get(index);
    }

    public static void main(String [] args) {
        Guiutil.showPanel(CategoryPanel.instance);
    }
}
