package Service;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;


public  class BaseService {
    protected   SqlSessionFactory sqlSessionFactory = null;


    public  void initSqlFactory()
    {
        if(this.sqlSessionFactory != null){
            return;
        }
        try {
            //获取配置文件的输入流
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

            MybatisSqlSessionFactoryBuilder mybatisSqlSessionFactoryBuilder =new MybatisSqlSessionFactoryBuilder();

            //通过配置文件获取session工厂
            SqlSessionFactory sessionFactory = mybatisSqlSessionFactoryBuilder.build(inputStream);

            sqlSessionFactory = sessionFactory;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected LinkedHashMap<String,Object> fail(LinkedHashMap<String,Object> dataMap){
        LinkedHashMap<String, Object> maps = new LinkedHashMap<>();
        maps.put("message","操作成功!");

        if(!dataMap.isEmpty()){
            maps.put("data",dataMap);
        }

        return maps;
    }

    protected LinkedHashMap<String,Object> fail(){
        LinkedHashMap<String, Object> maps = new LinkedHashMap<>();

        maps=this.fail(maps);

        return maps;
    }
}
