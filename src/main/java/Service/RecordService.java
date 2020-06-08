package Service;

import Entity.Record;
import gui.util.DateUtil;
import mapper.RecordMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecordService extends BaseService {
    public RecordService(){
        super.initSqlFactory();
    }

    public Record create(Record record){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        recordMapper.insert(record);
        sqlSession.commit();
        sqlSession.close();

        return record;
    }

    /**
     * 获取本月消费集合
     * @return
     */
    public List<Record> getThisMonthRecords(){
        List<Record> monthAllRecord = this.getRecord(DateUtil.monthBegin(),DateUtil.monthEnd());
        List< Record > result = new ArrayList< Record >();

        //获取本月第一天
        Date monthBegin = DateUtil.monthBegin();
        //获取本月总天数
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        //获取实例
        Calendar c = Calendar.getInstance();

        for (int i=0;i<monthTotalDay;i++){
              Record record = new Record();
              //计算并获取今日的时间实例
              c.setTime(monthBegin);
              c.add(Calendar.DATE,i);
              Date eachDayOfThisMontg = c.getTime();
              int todaySpend = getDaySpend(eachDayOfThisMontg, monthAllRecord);
              record.setSpend(todaySpend);
              result.add(record);
        }

        return result;
    }

    public List<Record> getRecord(int start,int count){
        List< Record > recordList = new ArrayList< Record >();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        recordList=recordMapper.getRecordByInt(start,count);

        return recordList;
    }

    public List<Record> getRecord(Date day){
        List< Record > recordList = new ArrayList< Record >();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        recordList=recordMapper.getRecordByDay(day);

        return recordList;
    }

    public List<Record> getRecord(Date start,Date end){
        List< Record > recordList = new ArrayList< Record >();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        recordList=recordMapper.getRecordByDate(start,end);

        return recordList;
    }

    /**
     * 从一个月的消费记录中获取某一天的消费金额
     * @param d
     * @param monthRawData
     * @return
     */
    public int getDaySpend(Date d,List< Record > monthRawData){
        int daySpend = 0;
        for(Record record : monthRawData){
            if(record.getDate().equals(d)){
                daySpend += record.getSpend();
            }
        }
        return daySpend;
    }

    public List<Record> getToDayRecord(){
        return getRecord(DateUtil.today());
    }
}
