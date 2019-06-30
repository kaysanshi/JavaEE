package com.leo.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.utils.PageBean;
/**
 * 持久层中的通用的方法的使用
 * @author leoi555
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> clazz;//接收运行期的类型：
	//注解直接去调用hibernateDaoSupport中的setsessionFaction方法注入sessionFactory
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
		//获得当前类型的父类
		ParameterizedType genericSuperclass=(ParameterizedType)this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		//返回值为数组类型的，最后再取出
		clazz=(Class)genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void upadte(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql="from "+this.clazz.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		//这是获得一个聚合函数
		dc.setProjection(Projections.rowCount());//获得什么样的sql；select count(*) ....
		//通过Criteria查询
		List list=getHibernateTemplate().findByCriteria(dc);
		//清空聚合函数
		dc.setProjection(null);
		if (list!=null && list.size()>0) {
			Long count=(Long)list.get(0);
			//long型的转换为int类型的
			return count.intValue();
		}else {
			return null;
		}
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		List<T> list = (List<T>)this.getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void executeUpdate(String queryName, Object...obj) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query query=currentSession.getNamedQuery(queryName);
		System.out.println(obj.length);
		System.out.println(obj.toString());
		int i=1;
		//赋值：
		for(Object object :obj) {
			//为hql赋值?赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		Integer currentPage = pageBean.getCurrentPage();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//指定hibernate的发送的SQL的方式，就是把里面的属性是如何封装起来封装对象的形式
		//把区域表中的子段subarea中和Region中的属性封装到他的属性列表中；
		//多表关联的分页查询设置
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		Integer pageSize = pageBean.getPageSize();
		//获得总的条数
		Integer totalCount = this.getTotalCount(detachedCriteria);
		pageBean.setTotal(totalCount);
		//获取分页
		int start=(currentPage-1)*pageSize;
		int maxResult=pageSize;
		pageBean.setRows(this.getPageList(detachedCriteria, start, maxResult));
		//打印结果
		System.out.println(pageBean.getRows());
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
}
