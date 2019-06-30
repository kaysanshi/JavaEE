package com.leo.course.scheduling.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Times;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午7:33:17
 */
public interface TimesService {

	Map<String, Object> add(Times times, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request, HttpServletResponse response);

}
