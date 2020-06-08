package Service;

import Entity.Category;
import mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryService extends BaseService {

    public CategoryService(){
        super.initSqlFactory();
    }

    public List<Category> getAll() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<Category> categories = categoryMapper.getAll();
        sqlSession.close();

        return categories;
    }

    public Category add(String name){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        CategoryMapper categoryMapper =sqlSession.getMapper(CategoryMapper.class);

        Category category = new Category();
        category.setCount(0);
        category.setName(name);

        categoryMapper.insert(category);
        sqlSession.commit();
        sqlSession.close();

        return category;
    }

    public void update(int id , String name) {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        CategoryMapper categoryMapper =sqlSession.getMapper(CategoryMapper.class);

        Category category = categoryMapper.selectById(id);

        category.setName(name);
        categoryMapper.updateCategoryBase(category);

        sqlSession.commit();
        sqlSession.close();

    }

    public void update(Category category){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        CategoryMapper categoryMapper =sqlSession.getMapper(CategoryMapper.class);

        categoryMapper.updateCategoryBase(category);
        sqlSession.commit();
        sqlSession.close();
    }
}
