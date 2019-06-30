package com.leo.bos.service;

import java.util.List;

import com.leo.bos.domain.BcRegion;
import com.leo.bos.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
public interface IRegionService {
	/**
	 * 保存操作
	 * @param list
	 */
	public void saveBatch(List<BcRegion> list);
	/**
	 * 分页查询
	 * @param pageBean
	 */
	public void pageQuery(PageBean pageBean);
	/**
	 * 获得所有
	 * @return
	 */
	public List<BcRegion> getlist();
	/**
	 * 通过字母来查询
	 * @return
	 */
	public List<BcRegion> getlistByQ(String q);

}
