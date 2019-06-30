package com.leo.bos.dao;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.domain.BcStaff;

/**
 * 
 * @author leoi555
 *
 */
public interface IStaffDao extends IBaseDao<BcStaff>{
	/**
	 * 批量删除
	 * 逻辑删除
	 * @param id
	 */
	void deleteBatch(String id);

}
