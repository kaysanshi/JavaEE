package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.Region;
import com.leo.hotel.utils.PageBean;

public interface RegionMapper {
	/**
	 * 获取总的记录数
	 * @return
	 */
	int selectCount();
	/**
	 * 获取分页查询
	 * @param pageBean
	 * @return
	 */
	List<Region> getPageQueryList(PageBean pageBean);
	/**
	 * 修改
	 * @param region
	 * @return
	 */
	int update(Region region);
	/**
	 * 添加
	 * @param region
	 * @return
	 */
	int add(Region region);
	/**
	 * 可以批量删除
	 * @param id
	 * @return
	 */
	int delete(String id);
	/**
	 * 获取region列表
	 * @return
	 */
	List<Region> getReionListByAjax();

}
