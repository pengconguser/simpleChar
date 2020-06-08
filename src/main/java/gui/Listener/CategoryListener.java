package gui.Listener;

import Entity.Category;
import Service.CategoryService;
import gui.Panel.CategoryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
           //获取面板实例
        CategoryPanel categoryPanel = CategoryPanel.instance;
        //获取点击的按钮
        JButton b = (JButton) actionEvent.getSource();

        CategoryService categoryService =new CategoryService();

        if(b == categoryPanel.bAdd){
             String name = JOptionPane.showInputDialog(null);

             if(name == null){
                 return;
             }
             //预防输入为空的错误
             if(name.length() == 0){
                 JOptionPane.showMessageDialog(categoryPanel,"输入不能为空");
                 return;
             }
             categoryService.add(name);

             JOptionPane.showMessageDialog(categoryPanel,"新增成功!");
        }

        if(b == categoryPanel.bEdit){
            //编辑逻辑

            /**
             * 获取被选中的消费类别
             */
            Category c =categoryPanel.getSelectCategory();

            String name = JOptionPane.showInputDialog(categoryPanel,"修改分类名称");

            if(name == null){
                return;
            }
            //预防输入为空的错误
            if(name.length() == 0){
                JOptionPane.showMessageDialog(categoryPanel,"分类不能为空");
                return;
            }

            categoryService.update(c.getId(),name);
            JOptionPane.showMessageDialog(categoryPanel,"编辑成功！");
        }

        categoryPanel.updateDate();
    }
}
