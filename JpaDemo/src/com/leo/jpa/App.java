package com.leo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class App {
	public static void main(String[] args) {
		//1.创建EntityManagerFactory
		String persistenceUnitName="JpaDemo";
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName);
		//2.创建EntityManager
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//3,开启事务
		EntityTransaction transaction=entityManager.getTransaction();
		//4.进行持久化的操作
		Customer customer=new Customer();
		customer.setAge("12");
		customer.setEmail("555@163.com");
		customer.setLastName("555");
		entityManager.persist(customer);
		//5.提交事务
		transaction.commit();
		//6.关闭EntityManager
		entityManager.close();
		//7.关闭EntityManagerFactory
		entityManagerFactory.close();
	}
}
