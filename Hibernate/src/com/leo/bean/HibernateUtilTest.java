package com.leo.bean;

import org.hibernate.Session;

/**
 * 测试Util类使用prouct持久化类
 * @author leoi555
 *
 */
public class HibernateUtilTest {
	/**
	 * 添加
	 */
	public void addProduct() {
		Session session=null;
		Product product=new Product();
		//为持久化类赋值
		product.setName("java web");
		product.setPrice(80.0);
		product.setFactory("明日科技");
		product.setRemark("无");
		//hibernate的持久化操作
		try {
		session=HibernateUtil.getSession();//获取session
		session.beginTransaction();//开启事务
		session.save(product);
		session.getTransaction().commit();//事务提交
		}catch(Exception e) {
			session.getTransaction().rollback();//事务回滚
			System.out.println("数据添加失败");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();//关闭session
		}
	}
	/**
	 * 查询get方法
	 */
	public void getlistProduct() {
		Session session=null;
		
		//hibernate的持久化操作
		try {
		session=HibernateUtil.getSession();//获取session
		Product product=session.get(Product.class,new Integer("1"));//转载对象
		}catch(Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();//关闭session
		}
	}
	/**
	 * 查询load方法：
	 * 
	 */
	public void loadlistProduct() {
		Session session=null;
		
		//hibernate的持久化操作
		try {
		session=HibernateUtil.getSession();//获取session
		Product product=session.load(Product.class,new Integer("1"));//转载对象
		//load的另一种形式
		//session.load(new Product(),new Integer("1"));//转载对象	
		}catch(Exception e) {
			System.out.println("对象转载失败");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();//关闭session
		}
	}
	/**
	 * 删除数据
	 */
		public void deleteProduct() {
			Session session=null;
			
			//hibernate的持久化操作
			try {
			session=HibernateUtil.getSession();//获取session
			Product product=session.get(Product.class,new Integer("1"));//转载对象
			session.delete(product);
			session.flush();//强制刷新提交
			}catch(Exception e) {
				System.out.println("对象删除失败");
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();//关闭session
			}
		}
	/**
	 * 数据的更新
	 */
		public void updateProduct() {
			Session session=null;
			
			//hibernate的持久化操作
			try {
			session=HibernateUtil.getSession();//获取session
			Product product=session.get(Product.class,new Integer("1"));//转载对象
					product.setName("java web");
					product.setPrice(80.0);
					product.setFactory("明日科技");
					product.setRemark("已经修改");
			session.flush();//强制刷新提交
			}catch(Exception e) {
				System.out.println("对象修改失败");
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();//关闭session
			}
		}
}
