package com.leo.bos.dao;

import java.util.List;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.domain.BcRegion;

/**
 * 区域管理
 * @author leoi555
 *
 */
public interface IRegionDao extends IBaseDao<BcRegion>{
	/**
	 * 模糊查询
	 * @param q
	 * @return
	 */
	List<BcRegion> getListByQ(String q);

}
