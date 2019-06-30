package com.baizhi.cooler.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.baizhi.cooler.utils.PageBean;


public interface BaseDao<T> {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(T entity);
	/**
	 * 更新
	 * @param entity
	 */
	public void upadte(T entity);
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity);
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	/**
	 * 查询全部
	 * @return
	 */
	public List<T> findAll();
	//查 符合条件的总记录数通过离线查询对象
	Integer	getTotalCount(DetachedCriteria dc);
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	//savaUpdate
	public void saveOrUpdate(T entity);
	/**
	 * 根据不同参数
	 * @param queryName
	 * @param obj
	 */
	public void executeUpdate(String queryName,Object...obj);
	//分页
	public void pageQuery(PageBean pageBean);
	/**
	 * 离线查询
	 * @param detachedCriteria
	 * @return
	 */
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
}
