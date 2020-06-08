package Service;

import Entity.Config;
import mapper.ConfigMapper;
import org.apache.ibatis.session.SqlSession;

public class ConfigService extends BaseService {

    public ConfigService(){
        super.initSqlFactory();
    }

    public Config selectById(int id)
    {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        ConfigMapper configMapper = sqlSession.getMapper(ConfigMapper.class);
        Config config=configMapper.selectById(id);

        sqlSession.close();

        return config;
    }

    public Config create(Config config)
    {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        ConfigMapper configMapper = sqlSession.getMapper(ConfigMapper.class);

        configMapper.insert(config);
        sqlSession.commit();
        sqlSession.close();

        return config;
    }

    public Config update(Config config)
    {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        ConfigMapper configMapper = sqlSession.getMapper(ConfigMapper.class);
        configMapper.updateConfigBase(config);
        sqlSession.commit();
        sqlSession.close();

        return config;
    }

    public int getIntBudget(){
        Config config = this.selectById(1);

        return Integer.parseInt(config.getValue());
    }
}
