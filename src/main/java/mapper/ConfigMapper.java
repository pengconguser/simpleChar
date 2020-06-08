package mapper;

import Entity.Config;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface ConfigMapper extends BaseMapper<Config> {

    public void updateConfigBase(Config config);
}
