package com.leo.course.scheduling.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Teacher;

public interface TeacherService {

	Map<String, Object> add(Teacher teacher);

	Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> update(Teacher teacher);

	Map<String, Object> listteacher(HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> getTeacherByid(Teacher teacher, HttpServletRequest request, HttpServletResponse response);

	List<Teacher> getListTeacherName();

	List<Teacher> getListTeacherbyListId(List<Integer> teacherid);


}
