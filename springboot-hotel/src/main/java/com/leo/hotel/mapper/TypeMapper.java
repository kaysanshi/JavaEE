package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.Region;
import com.leo.hotel.domain.Type;
import com.leo.hotel.domain.User;
import com.leo.hotel.utils.PageBean;

public interface TypeMapper {
	/**
	 * 类型添加
	 * @param type
	 * @return
	 */
	int add(Type type);
	/**
	 * 修改
	 * @param type
	 * @return
	 */
	int update(Type type);
	/**
	 * 获取总的记录数
	 * @return
	 */
	int selectCount();
	/**
	 * 获取分页类表
	 * @param pageBean
	 * @return
	 */
	List<Type> getPageQueryList(PageBean pageBean);
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	int delete(String id);
	/**
	 * ajax获取
	 * @return
	 */
	List<Type> getListByAjax();

}
