package com.leo.bos.service;

import com.leo.bos.domain.BcDecidedzone;
import com.leo.bos.utils.PageBean;

/**
 * 定区
 * @author leoi555
 *
 */
public interface IDecidedZoneService {
	/**
	 * 定区添加
	 * @param model
	 * @param subareaid
	 */
	void save(BcDecidedzone model, String[] subareaid);
	/**
	 * 分页显示
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
