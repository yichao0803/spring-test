package com.example.springtest.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @className: StaticScheduleTask
 * @description: StaticScheduleTask
 * @author: zhangyichao
 * @date: 2021/11/22
 **/
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks(){
        System.err.println("静态任务，执行时间："+ LocalDateTime.now());
    }
}
