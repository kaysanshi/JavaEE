package com.leo.bos.service;

import java.util.List;

import com.leo.bos.domain.BcSubarea;
import com.leo.bos.utils.PageBean;

/**
 * 分区
 * @author leoi555
 *
 */
public interface ISubareaService {
	/**
	 * 添加
	 * @param model
	 */
	void save(BcSubarea model);
	/**
	 * 分页
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<BcSubarea> findAll();
	/**
	 * 
	 * @return
	 */
	List<BcSubarea> findListNotAssociation();
	/**
	 * 分区分布数据
	 * @return
	 */
	List<Object> findSubareaGroupByProvince();

}
