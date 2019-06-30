package com.leo.demo;
/**
 * 静态方法
 * @author leoi555
 *
 */
public class UserFactory {
	public static User createUser() {
		System.out.println("静态工厂的创建");
		return new User();
		
	}
	/**
	 * 未能够实现通过动态方法建立
	 * @return
	 */
	public  User createUser1() {
		System.out.println("实例工厂");
		return new User();
	}
}
