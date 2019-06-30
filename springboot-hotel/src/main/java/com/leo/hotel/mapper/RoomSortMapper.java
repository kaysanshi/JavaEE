package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.Roomsort;
import com.leo.hotel.utils.PageBean;

/**
 * 房间的分类
 * @author leoill
 *TODO
 *2018年11月30日
 */
public interface RoomSortMapper {
	/**
	 * 添加
	 * @param sort
	 * @return
	 */
	int add(Roomsort sort);
	/**
	 * 修改
	 * @param sort
	 * @return
	 */
	int update(Roomsort sort);
	int delete(String id);
	int selectCount();
	List<Roomsort> getPageQueryList(PageBean pageBean);
	List<Roomsort> getListByAjax();

}
