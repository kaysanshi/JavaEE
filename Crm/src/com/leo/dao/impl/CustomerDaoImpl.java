package com.leo.dao.impl;

import java.util.List;

import javax.transaction.Transactional.TxType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.leo.dao.CustomerDao;
import com.leo.domain.Customer;
import com.leo.utils.HibernateUtil;
/**
 * 操作数据层
 * @author leoi555
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();//获得session
		try {
			Transaction transaction=session.beginTransaction();//打开事务
			session.save(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();//事务回滚
			System.out.println("数据添加失败");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
		
		
	}

	@Override
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();//获得session
		try {
			Transaction transaction=session.beginTransaction();//打开事务
			String hql="from Customer";
			Query query=session.createQuery(hql);
			List<Customer> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			System.out.println("获取数据失败");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();//获得session
		try {
			Transaction transaction=session.beginTransaction();//打开事务
			String hql="from Customer where cust_id=:id";
			Query query=session.createQuery(hql);
			query.setParameter("id", customer.getCust_id());
			Customer customer2=(Customer) query.uniqueResult();//获取单一的对象
			transaction.commit();
			return customer2;
		} catch (Exception e) {
			System.out.println("获取数据失败");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public boolean saveUpdate(Customer customer) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();//获得session
		try {
			Transaction transaction=session.beginTransaction();//打开事务
			String sql ="UPDATE Customer set cust_name = :name ,cust_source=:source,cust_industry=:industry,cust_level=:level,cust_linkman=:linkman,cust_phone=:phone,cust_mobile=:moblie WHERE cust_id = :id";
			Query query =session.createQuery(sql);
			query.setParameter("name", customer.getCust_name());
			query.setParameter("source", customer.getCust_source());
			query.setParameter("industry", customer.getCust_industry());
			query.setParameter("level", customer.getCust_level());
			query.setParameter("linkman", customer.getCust_linkman());
			query.setParameter("phone", customer.getCust_phone());
			query.setParameter("moblie", customer.getCust_mobile());
			query.setParameter("id", customer.getCust_id());
			int result = query.executeUpdate();
			transaction.commit();
			if (result>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();//事务回滚
			System.out.println("数据修改失败");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		//1 获得session
		Session session = HibernateUtil.getCurrentsesion();
		System.out.println(session);
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction(); 
		//2 将离线对象关联到session
		Criteria c = dc.getExecutableCriteria(session);
		//3 执行查询并返回
		List<Customer> list=c.list();
		beginTransaction.commit();
		session.close();
		return list;
	}

	@Override
	public Customer getCustomerById(Long cust_id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();//获得session
		try {
			Transaction transaction=session.beginTransaction();//打开事务
			String hql="from Customer where cust_id=:id";
			Query query=session.createQuery(hql);
			
			query.setParameter("id",cust_id);
			Customer customer2=(Customer) query.uniqueResult();//获取单一的对象
			transaction.commit();
			return customer2;
		} catch (Exception e) {
			System.out.println("获取数据失败");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	
	
}
