package com.leo.api;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.leo.domain.Customer;
import com.leo.domain.LinkMan;

/**
 * 懒加载策略
 * @author leoi555
 *
 */
public class Demo_get_load {
	/**
	 * get获得对象：
	 * 立即查询
	 */
	public void test(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得要操作的客户对象
		Customer c = session.get(Customer.class,5l);
		//2> 创建联系人
		
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	/**
	 * load获得：延迟加载，语句在执行时不发送任何sql语句，会先返回一个代理对象，只有使用时才会执行查询
	 *是否延迟加载，可以配置class属性lazy:true;加载时不查询，使用的时候才查询。
	 *根据关联的session查询确保调用属性加载数据时sesion用保持打开
	 *默认是延迟加载
	 */
	
	
	public void test2(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得要操作的客户对象
		Customer c = session.load(Customer.class,5l);
		//2> 创建联系人
		
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	/**
	 * 集合级别的关联
	 */
	public void test3(){
		//1 获得session
		Session session = HibernateUtil.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		//1> 获得要操作的客户对象
		Customer c = session.load(Customer.class,5l);
		Set<LinkMan> linkMens= c.getLinkMens();//关联级别
		System.out.println(linkMens);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	//集合级别的关联
	//fetch:select 单表查询
	//lazy:true 使用时才加载集合数据.默认值
		@Test
		public void fun1(){
			Session session =  HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMens();//关联级别
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		
		//集合级别的关联
			//fetch:select 单表查询
			//lazy:false 立即记载集合数据
			@Test
			public void fun2(){
				Session session = HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
				
				Customer c = session.get(Customer.class, 2l);
				
				Set<LinkMan> linkMens = c.getLinkMens();//关联级别
				
				System.out.println(linkMens);
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
			//集合级别的关联
			//fetch:select 单表查询
			//lazy:extra 极其懒惰.与懒加载效果基本一致. 如果只获得集合的size.只查询集合的size(count语句)
			@Test
			public void fun3(){
				Session session =  HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
				
				Customer c = session.get(Customer.class, 2l);
				
				Set<LinkMan> linkMens = c.getLinkMens();//关联级别
				
				System.out.println(linkMens.size());
				
				System.out.println(linkMens);
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
			//集合级别的关联
			//fetch:join	多表查询
			//lazy:true|false|extra 失效.立即加载.不会进行懒加载
			@Test
			public void fun4(){
				Session session =  HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
				
				Customer c = session.get(Customer.class, 2l);
				
				Set<LinkMan> linkMens = c.getLinkMens();//关联级别
				
				System.out.println(linkMens.size());
				
				System.out.println(linkMens);
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
			
			@Test
			//fetch: subselect 子查询
			//lazy: true 懒加载
			public void fun5(){
				Session session =  HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
					
				String  hql = "from Customer";
				
				Query query = session.createQuery(hql);
				
				List<Customer> list = query.list();
				
				for(Customer c:list){
					System.out.println(c);
					System.out.println(c.getLinkMens().size());
					System.out.println(c.getLinkMens());
				}
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
			@Test
			//fetch: subselect 子查询
			//lazy: false 立即加载
			public void fun6(){
				Session session =  HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
					
				String  hql = "from Customer";
				
				Query query = session.createQuery(hql);
				
				List<Customer> list = query.list();
				
				for(Customer c:list){
					System.out.println(c);
					System.out.println(c.getLinkMens().size());
					System.out.println(c.getLinkMens());
				}
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
			@Test
			//fetch: subselect 子查询
			//lazy: extra 极其懒惰
			public void fun7(){
				Session session = HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
					
				String  hql = "from Customer";
				
				Query query = session.createQuery(hql);
				
				List<Customer> list = query.list();
				
				for(Customer c:list){
					System.out.println(c);
					System.out.println(c.getLinkMens().size());
					System.out.println(c.getLinkMens());
				}
				
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
		////////////////////////////////////////////////////
			/**
			 * 反加载：
			 * 通过属性获取对象级别的加载
			 */
			@Test
			public void testOver(){
				Session session = HibernateUtil.openSession();
				Transaction tx = session.beginTransaction();
				//----------------------------------------------------
					
				LinkMan linkMan=session.get(LinkMan.class, 1l);
				Customer customer=linkMan.getCustomer();
					System.out.println(customer);
				//----------------------------------------------------
				tx.commit();
				session.close();
				
			}
}
