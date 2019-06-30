package com.leo.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 自定作业
 * @author leoi555
 *
 */
public class MyJob {
	public  void run() {
		// TODO Auto-generated method stub
		System.out.println("自定义作业类执行："+new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date()));
		
	}
}
