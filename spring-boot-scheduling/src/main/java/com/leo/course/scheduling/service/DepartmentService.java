package com.leo.course.scheduling.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Department;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午10:09:06
 */
public interface DepartmentService {

	Map<String, Object> add(Department depart);

	Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> update(Department depart);

	Map<String, Object> getBepartByname(HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> getBepartByno(Department department, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 通过院系代码获得其中的名称
	 * @param department
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getBepartno(Department department, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> getdepartBymajorno(Department department, HttpServletRequest request,
			HttpServletResponse response);

}
