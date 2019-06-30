package com.leo.api;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.leo.domain.Customer;
import com.leo.domain.LinkMan;

/**
 * 级联操作
 * @author leoi555
 *
 */
public class DemoToCascadeOntoMany {
	@Test
	//保存客户 以及客户 下的联系人
	//一个customer下有多个联系人对象
	public void fun1(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		Customer c = new Customer();
		c.setCust_name("传智播客");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黎活明");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("刘悦东");
		
		//表达一对多,客户下有多个联系人
		//如果客户放弃维护联系人，维护的代码可以省略
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);
		
		//表达对对对,联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		
		session.save(c);
		session.save(lm1);
		session.save(lm2);
		//这就对应了在customer的一个实体对象中对应了两个外部的联系人对象
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}

	//为客户增加联系人
	public void fun2(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得要操作的客户对象
		Customer c = session.get(Customer.class,5l);
		//2> 创建联系人
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("郝强勇");
		//3> 将联系人添加到客户,将客户设置到联系人中
		c.getLinkMens().add(lm1);
		lm1.setCustomer(c);
		//4> 执行保存
		session.save(lm1);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	
	//为客户删除联系人只是把外键得映射给删除了但是还是不可以删除这个表中的数据
	//同样也可可以直接把表中的信息给删除去，直接用session.delete(object);删除你所查询到的对象即可
	public void fun3(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//在数据库中如果有对象引用这个属性时，删除其中一个是不可以删除的
		//删除的时候需要用级联删除，如果要删除可以用：inverse="false";这是维护外键，可以直接删并设置外键为空
		//或者用 不维护外键：inverse="true",casecade="delete";级联删除；
		//3操作
		//1> 获得要操作的客户对象
		Customer c = session.get(Customer.class,5l);
		//2> 获得要移除的联系人
		LinkMan lm = session.get(LinkMan.class, 3l);
		//3> 将联系人从客户集合中移除
		c.getLinkMens().remove(lm);
		lm.setCustomer(null);
		//删除这个对应的数据并且把数据给删除掉
		session.delete(lm);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
}
