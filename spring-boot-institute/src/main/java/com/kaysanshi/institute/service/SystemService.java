package com.kaysanshi.institute.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.CarouselQueryVo;


public interface SystemService {

	public Map<String, Object> list(CarouselQueryVo cvo);

	public Map<String, Object> add(Carousel carousel);

	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> update(Carousel carousel, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> logo(Carousel logo, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> logoquery();

	public Map<String, Object> query();

}
