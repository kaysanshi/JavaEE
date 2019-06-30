package com.leo.utils;
/**
 * 工具类
 * @author leoi555
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * HibernateUtil使用
 * @author leoi555
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static{
		Configuration cfg=new Configuration().configure();//加载hibernate配置文件
		sessionFactory=cfg.buildSessionFactory();//创建session
	}
	//获得的openSessioin
		public static Session openSession() {
			Session session=sessionFactory.openSession();
			if (session!=null){
				return session;
			}else {
				return null;
			}
			
		}
	//获得currentSession
		public static Session getCurrentsesion() {
			Session session=sessionFactory.getCurrentSession();
			if (session==null){
					System.out.println("获得session失败");
					return null;
			}else {
				return session;	
			}
			
		}
		public static void main(String[] args) {
			System.out.println(HibernateUtil.getCurrentsesion());
		}
		
}
