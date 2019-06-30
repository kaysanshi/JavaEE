package com.leo.bean;
/**
 * 测试类
 * @author leoi555
 *
 */

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployeee {
	private static SessionFactory factory;
	public static void main(String[] args) {
		factory=new Configuration().configure().buildSessionFactory();
		ManageEmployeee ME=new ManageEmployeee();
		//添加记录到database中
		 Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
	      Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
	      Integer empID3 = ME.addEmployee("John", "Paul", 10000);
	      ME.listEmployees();
	      ME.updateEmployee(empID1, 5000);
	      ME.deleteEmployee(empID2);
	      ME.listEmployees();
	}
	/**
	 * 删除
	 * @param empID2
	 */
	private void deleteEmployee(Integer empID2) {
		// TODO Auto-generated method stub
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employeee employee = 
	                   (Employeee)session.get(Employeee.class, empID2); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	/**
	 * 更新
	 * @param empID1
	 * @param i
	 */
	private void updateEmployee(Integer empID1, int salary) {
		// TODO Auto-generated method stub
		Session session = factory.openSession( );
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employeee employeee = 
	                    (Employeee)session.get(Employeee.class, empID1); 
	         employeee.setSalary( salary );
	         session.update(employeee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	/**
	 * 获取列表
	 */
	private void listEmployees() {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			List employee=session.createQuery("FROM Employeee").list();
			for(Iterator iterator=employee.listIterator();iterator.hasNext();) {
				Employeee employeee=(Employeee) iterator.next();
				 System.out.print("First Name: " + employeee.getFirstName()); 
		         System.out.print("  Last Name: " + employeee.getLastName()); 
		         System.out.println("  Salary: " + employeee.getSalary()); 
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
	}
	/**
	 * 添加
	 * @param string
	 * @param string2
	 * @param i
	 * @return
	 */
	private Integer addEmployee(String string, String string2, int i) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction txTransaction=null;
		Integer employeeId=null;
		try {
			txTransaction=session.beginTransaction();//开始事务
			Employeee employeee=new Employeee(string,string2,i);
			employeeId=(Integer) session.save(employeee);
			txTransaction.commit();//提交事务
		}catch(HibernateException e){
			if (txTransaction!=null) {
				txTransaction.rollback();//回滚
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return employeeId;
	}
}
