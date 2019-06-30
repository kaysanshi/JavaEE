package com.leo.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知类
 * @author leoi555
 *
 */
public class Advice {
	//前置通知：目标方法之前调用
	//后置通知：exception时，不会调用执行后调用
	//环绕通知：在目标方法前后都调用
	//异常拦截通知：出现异常就会调用
	//后置通知，无论是否异常都要调用
	
	//前置通知
	public  void  before() {
		System.out.println("前置通知");
	}
	//后置通知
	public void afterReturning() {
		System.out.println("后置通知异常不会调用");
		
	}
	//环绕通知

		public Object around(ProceedingJoinPoint pjp) throws Throwable {
			System.out.println("这是环绕通知之前的部分!!");
			Object proceed = pjp.proceed();//调用目标方法
			System.out.println("这是环绕通知之后的部分!!");
			return proceed;
		}

	//异常通知
	public void afterException() {
		System.out.println("异常通知");
	}
	//后置通知
	public void after() {
		System.out.println("后置通知出现异常也会调用");
	}
}
