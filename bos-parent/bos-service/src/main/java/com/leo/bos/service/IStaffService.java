package com.leo.bos.service;

import java.util.List;

import com.leo.bos.domain.BcStaff;
import com.leo.bos.utils.PageBean;

/**
 * 取派员
 * @author leoi555
 *
 */
public interface IStaffService {
	/**
	 * 添加取派员
	 * @param model
	 */
	void addStaff(BcStaff model);
	/**
	 * 分页
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);
	/**
	 * 逻辑删除，请修改其中的摸一个数据
	 * @param ids
	 */
	void deleteBatch(String ids);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	BcStaff findById(String id);
	/**
	 * 修改
	 * @param staff
	 */
	void update(BcStaff staff);
	
	List<BcStaff> findlistNotdel();

}
