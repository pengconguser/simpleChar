package mapper;

import Entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    public List<Category> getAll();

    public  void updateCategoryBase(Category category);
}
