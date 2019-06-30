package com.leo.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leo.crm.dao.BaseDao;
/**
 * 实现BaseDao接口
 * @author leoi555
 *
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz;//接收运行期的泛型类型
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		//获得当前类型的父类（父类中含有泛型）
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		//返回值为数组类型的，最后再取出
		clazz = (Class) genericSuperclass.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		//先取出这个
		T byId = this.getById(id);
		getHibernateTemplate().delete(byId);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getHibernateTemplate().get(clazz, id);
		
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		//需要用聚合函数
				dc.setProjection(Projections.rowCount());
				List list = getHibernateTemplate().findByCriteria(dc);
				//清空聚合函数
				dc.setProjection(null);
				if (list!=null && list.size()>0) {
					Long count=(Long) list.get(0);
					return count.intValue();//这是返回int性的
				}else {
					return null;
				}
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		List<T> list=(List<T>) this.getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}
	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	

}
