package com.example.springtest.schedule;

import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
//
///**
// * @className: DynamicScheduleTask
// * @description: TODO
// * @author: zhangyichao
// * @date: 2021/11/22
// **/
//@Configuration
//@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {
//    @Mapper
//    public interface CronMapper {
//        @Select("select cron from cron limit 1")
//        public String getCron();
//    }
//
//    @Autowired      //注入mapper
//    @SuppressWarnings("all")
//    CronMapper cronMapper;
//
//    /**
//     * 执行定时任务.
//     */
//    @Override
   public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        System.out.println("init configureTasks ");
//        taskRegistrar.addTriggerTask(()-> System.out.println("执行动态定时任务："+ LocalDateTime.now().toLocalDate()),
//                        triggerConnect->{
//                            String cron= cronMapper.getCron();
//                            if(StringUtils.isNullOrEmpty(cron)){
//                                System.out.println(" cron is null ");
//                            }
//                            return new CronTrigger(cron).nextExecutionTime(triggerConnect);
//                        }
//                );
  }
}
