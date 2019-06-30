package com.leo.api;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.leo.domain.Role;
import com.leo.domain.User;

/**
 * 多对多的关系
 * @author leoi555
 *
 */
public class DemoMToM {
	@Test
	//保存员工以及角色
	public void fun1(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 创建两个 User
		User u1 = new User();
		User u2 = new User();
		u1.setUser_name("张三");
		u2.setUser_name("李四");
		
		//2> 创建两个 Role
		Role r1 = new Role();
		Role r2 = new Role();
		r1.setRole_name("保洁");
		r2.setRole_name("保安");
		//3> 用户表达关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		//如果不配置的时候 两个都会进行关系维户，会进行主键约束重复不可以用
		//inverse="true" 属性在另一方维护关系，这个放弃维护关系
		//4> 角色表达关系
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		
		//5> 调用Save方法一次保存
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	
	
	@Test
	//新增一个角色
	public void fun3(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得指定的用户然后创建角色
		User user = session.get(User.class, 1l);
		//2> 创建角色
		Role r = new Role();
		r.setRole_name("男公关");
		//3> 将角色添加到用户中加入到set集合中
		user.getRoles().add(r);
		//4> 将角色转换为持久化(级联保存时下面的语句不用书写，级联保存：cascade="save-update")
		//session.save(r);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	
	@Test
	//为某一用户解除一个角色
	public void fun4(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得用户
		User user = session.get(User.class, 1l);
		//2> 获得要操作的角色对象(保洁,保安)
		Role r1 = session.get(Role.class, 1l);
		Role r2 = session.get(Role.class, 2l);
		//3> 将角色从用户的角色集合中移除
		user.getRoles().remove(r1);
		user.getRoles().remove(r2);
		
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
}
