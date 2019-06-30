package com.leo.course.scheduling.mapper;

import java.util.List;

import com.leo.course.scheduling.domain.Subject;
import com.leo.course.scheduling.utils.PageBean;

public interface SubjectMapper {

	int add(Subject subject);

	int selectCount();

	List<Subject> getPageQueryList(PageBean pageBean);

	int update(Subject subject);

	List<Subject> getListSubjectName();

}
