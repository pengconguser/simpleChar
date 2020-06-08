package Model;

import Entity.Category;
import Service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class CategoryTableModel implements TableModel {
    String[] columnNames = new String[]{"分类名称","消费次数"};

    public List<Category> categories = new CategoryService().getAll();

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnNamesIndex) {
        return this.columnNames[columnNamesIndex];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category =categories.get(rowIndex);

        /**
         * 按照规则渲染表格
         */
        if(columnIndex == 0){
            return category.getName();
        }
        if(columnIndex == 1){
            return category.getCount();
        }

        return null;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
