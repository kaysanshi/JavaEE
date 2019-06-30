package com.leo.hotel.mapper;

import java.util.List;
import com.leo.hotel.domain.Starlevel;
import com.leo.hotel.utils.PageBean;

public interface StarlevelMapper {
	/**
	 * 添加
	 * @param star
	 * @return
	 */
	int add(Starlevel star);
	/**
	 * 总的数量
	 * @return
	 */
	int selectCount();
	/**
	 * 分页数据
	 * @param pageBean
	 * @return
	 */
	List<Starlevel> getPageQueryList(PageBean pageBean);
	/**
	 * 修改
	 * @param star
	 * @return
	 */
	int update(Starlevel star);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int delete(String id);
	/**
	 * 通过ajax查询
	 * @return
	 */
	List<Starlevel> getListByAjax();

}
