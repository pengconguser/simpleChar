package Service;

import Entity.Record;
import gui.Page.SpendPage;
import gui.util.DateUtil;

import java.util.List;

public class SpendService extends BaseService {


    public SpendPage getSpendPage(){
        RecordService recordService = new RecordService();
        //获取本月消费记录
        List<Record> thisMonthRecords  =recordService.getThisMonthRecords();

        //获取今日消费数据
        List<Record> toDayRecords =recordService.getToDayRecord();

        //获取本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        //定义获取的的数据
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        //获得预算
        int monthBudget = new ConfigService().getIntBudget();

        /**
         * 统计本月消费额
         * 遍历本月的没一条消费记录 获取金额并相加
         */
        for (Record record : thisMonthRecords) {
            monthSpend += record.getSpend();
        }

        //统计今日消费
        for (Record record : toDayRecords) {
            todaySpend += record.getSpend();
        }
        //计算日均消费
        avgSpendPerDay = monthSpend / thisMonthTotalDay;


        //计算本月剩余
        monthAvailable = monthBudget - monthSpend;
        //计算距离月末多少天
        monthLeftDay = DateUtil.thisMonthLeftDay();
        //计算日均可用
        dayAvgAvailable = monthAvailable / monthLeftDay;
        //计算使用比例
        usagePercentage = monthSpend * 100 / monthBudget;
        //生成SpendPage 并return
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable,
                dayAvgAvailable, monthLeftDay, usagePercentage);
    }
}
