package gui.Listener;

import Entity.Category;
import Entity.Record;
import Service.CategoryService;
import Service.RecordService;
import gui.Panel.RecordPanel;
import gui.util.DataUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ReportListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //获取report面板实例
        RecordPanel recordPanel = RecordPanel.instance;

        String remark  =  recordPanel.tfComment.getText();
        String spend   = recordPanel.tfSpend.getText();
        String categoryName =(String) recordPanel.cbCategory.getSelectedItem();
        Date date = recordPanel.datepick.getDate();

        if(!DataUtil.isInt(spend)){
            JOptionPane.showMessageDialog(recordPanel,"花费必须是数字!");
        }

        System.out.println(categoryName);
        //获取此时选中的实例
        Category category = recordPanel.cbModel.SelectCategory;

        RecordService recordService = new RecordService();
        CategoryService categoryService =new CategoryService();

        Record record = new Record();
        record.setSpend(Integer.parseInt(spend));
        record.setCid(category.getId());
        record.setComment(remark);
        record.setDate(date);

        category.setCount(category.getCount()+1);
        categoryService.update(category);

        recordService.create(record);
    }
}
