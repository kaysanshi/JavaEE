package com.kaysanshi.institute.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	public Map<String, Object> img(MultipartFile file, HttpServletRequest req, HttpServletResponse resp);
}
