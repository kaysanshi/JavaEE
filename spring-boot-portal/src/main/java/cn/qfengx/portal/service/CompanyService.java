package cn.qfengx.portal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import cn.qfengx.portal.bean.Company;
import cn.qfengx.portal.bean.CompanyQueryV;

public interface CompanyService {

	Map<String, Object> add(Company company);

	Map<String, Object> list(CompanyQueryV nvo);

	Map<String, Object> update(Company company);

	Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse res);

}
