package com.leo.course.scheduling.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Subject;

public interface SubjectService {

	Map<String, Object> add(Subject subject, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> update(Subject subject);

	List<Subject> getListSubjectName();

}
