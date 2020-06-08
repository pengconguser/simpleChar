package Model;

import Entity.Category;
import Service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel<String> {
    public List< Category > cs = new CategoryService().getAll();

    public String c;
    public Category SelectCategory;

    public CategoryComboBoxModel() {
        /**
         * 默认选择第一个
         * 即数据库记录里面的最后一个
         */
        if(!cs.isEmpty()){
            c = cs.get(0).getName();
        }
    }

    @Override
    public void setSelectedItem(Object o) {
          c = (String) o;
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty()){
            return c;
        }else{
            return null;
        }
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public String getElementAt(int i) {
        Category category =cs.get(i);
        this.SelectCategory = category;

        return category.getName();
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {

    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {

    }
}
