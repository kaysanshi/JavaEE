package com.leo.course.scheduling.mapper;

import java.util.List;

import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.domain.Department;
import com.leo.course.scheduling.utils.PageBean;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午10:11:27
 */
public interface DepartmentMapper {

	int add(Department depart);

	int selectCount();

	List<Department> getPageQueryList(PageBean pageBean);

	int update(Department depart);

	List<Department> getDepartByname();

	Department getDepartByno(Department department);

	List<Department> getDepartNameByno(Department department);

	Department getdepartBymajorno(Department department);

}
