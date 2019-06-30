package com.leo.course.scheduling.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Student;

public interface StudentService {

	Map<String, Object> add(Student student, HttpServletResponse response, HttpServletRequest request);

	Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> update(Student student);

}
