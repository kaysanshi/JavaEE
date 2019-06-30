package com.leo.bos.dao;

import java.util.List;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.domain.BcSubarea;
/**
 * 
 * @author leoi555
 *
 */
public interface ISubareaDao extends IBaseDao<BcSubarea>{
	/**
	 * 获得分区分布数据
	 * @return
	 */
	List<Object> findSubareaGroupByProvince();

}
