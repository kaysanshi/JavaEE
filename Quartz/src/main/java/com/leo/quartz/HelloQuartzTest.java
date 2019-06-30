package com.leo.quartz;

import java.util.Collection;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 设置触发器
 * @author leoi555
 *
 */
public class HelloQuartzTest {
	public static void main(String[] args) {
		//通过schedulerFactory获取一个调度器
		//StdSchedulerFactory实现了SchedulerFactory接口
		SchedulerFactory factory=new StdSchedulerFactory(); 
		Scheduler scheduler=null;
		try {
			//获取一个调度器
			scheduler=factory.getScheduler();
			//创建jobdetail绑定JOb实现类，指定job的名称所在组的名称以及绑定的类
			JobDetail job=JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName","group1").build();
			//创建Trigger
			CronScheduleBuilder builder;//=CronScheduleBuilder.cronSchedule("0 0/1 * * * * ?");
			builder=CronScheduleBuilder.dailyAtHourAndMinute(12, 30);
			//  corn表达式  每五秒执行一次  
		     Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "group1")    
		              .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))    
		              .startNow().build();
		     // 把作业和触发器注册到任务调度中    
	           scheduler.scheduleJob(job, trigger);    
	 
	           // 启动调度    
	           scheduler.start();    
	           Thread.sleep(10000);  
	           // 停止调度  
	           scheduler.shutdown(); 		
		
					
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
