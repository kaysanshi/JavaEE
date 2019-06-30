package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.User;
import com.leo.hotel.utils.PageBean;

public interface UserMapper{

	/**
	 * 添加
	 * @param user
	 * @return
	 */
	int add(User user);
	/**
	 * 检查登录状态
	 * @param user
	 * @return
	 */
	User checkUser(User user);
	/**
	 *获取总的记录数
	 * @return
	 */
	int selectCount();
	/**
	 * 分页查询
	 * @return
	 */
	List<User> getPageQueryList(PageBean pageBean);
	/**
	 * 更新
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 删除用户
	 * @param id
	 */
	int  deleteBatch(String id);

}
