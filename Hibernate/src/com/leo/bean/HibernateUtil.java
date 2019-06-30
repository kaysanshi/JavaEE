package com.leo.bean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 数据初始化Util类
 * @author leoi555
 *
 */

public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private static SessionFactory sessionFactory=null;//sessionFactory对象，
	static {
		try {
		Configuration cfg=new Configuration().configure();//加载hibernate配置文件
		sessionFactory=cfg.buildSessionFactory();
		}catch(Exception e) {
			System.out.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	//获取session
	public static Session getSession() {
		Session session=threadLocal.get();
		if (session==null ||! session.isOpen()) {
			if (sessionFactory==null) {
				rebuildSessionFactory();
				
			}
		session=(sessionFactory!=null)? sessionFactory.openSession():null;
		threadLocal.set(session);
		}
		return session;
		
	}
	/**
	 * 重建会话工厂
	 */
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			Configuration cfg=new Configuration().configure();//加载配置文件
			sessionFactory=cfg.buildSessionFactory();//
		}catch(Exception exception) {
			System.out.println("创建会话工厂失败");
			exception.printStackTrace();
		}
	}
	/**
	 * 获取SessionFactory对象
	 */
	public static SessionFactory getSessionFactory() {
			return sessionFactory;
	}
	/**
	 * 关闭session
	 */
	public static void closeSession() {
		Session session=(Session)threadLocal.get();
		threadLocal.set(null);
		if (session!=null) {
			session.close();//关闭session
		}
	}
}
