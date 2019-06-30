package com.leo.bos.service;

import com.leo.bos.domain.QpNoticebill;
import com.leo.bos.domain.User;
import com.leo.bos.utils.SessionUtils;

/**
 * 
 * @author leoi555
 *
 */
public interface INoticebillService {
	/**
	 * 保存业务的通知单
	 * @param model
	 */
	void add(QpNoticebill model);
		
}
