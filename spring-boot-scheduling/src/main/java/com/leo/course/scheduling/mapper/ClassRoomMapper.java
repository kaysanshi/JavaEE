package com.leo.course.scheduling.mapper;

import java.util.List;

import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.utils.PageBean;

/**
 * 
 * @author leoill
 *TODO
 *2019年3月3日
 */
public interface ClassRoomMapper {

	int add(Classroom room);

	int selectCount();

	List<Classroom> getPageQueryList(PageBean pageBean);

	int update(Classroom room);

	List<Classroom> getListClassRoomName();

}
