package mapper;

import Entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RecordMapper extends BaseMapper<Record> {
        public List<Record> getRecordByInt(@Param("start") int start,@Param("count") int count);

        public List<Record> getRecord();

        public List<Record> getRecordByDate(@Param("start") Date start, @Param("end") Date end);

        public List<Record> getRecordByDay(@Param("day") Date day);
}
