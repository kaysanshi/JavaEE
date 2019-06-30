package com.leo.course.scheduling.mapper;

import java.util.List;

import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.utils.PageBean;

public interface TeacherMapper {

	int update(Teacher teacher);

	List<Teacher> getPageQueryList(PageBean pageBean);

	int selectCount();

	int add(Teacher teacher);

	List<Teacher> getteacherList();

	Teacher getTeacherByid(Teacher teacher);
	
	//这些都是关联查询
	List<Teacher> getListTeacherName();

	Teacher getTeacherByListid(Integer teacherid);


}
