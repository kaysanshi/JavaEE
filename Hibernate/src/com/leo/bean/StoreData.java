package com.leo.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		//
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");//加载配置文件
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Employee el=new Employee();
		el.setFirstname("leo");
		el.setLastname("leio");
		session.persist(el);
		transaction.commit();
		session.close();
		System.out.println("sucsessfully saved");
	}
		
}
