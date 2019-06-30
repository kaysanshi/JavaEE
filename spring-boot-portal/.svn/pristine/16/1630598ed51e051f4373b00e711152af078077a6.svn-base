package cn.qfengx.portal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qfengx.portal.bean.Projectcase;
import cn.qfengx.portal.bean.ProjectcaseQueryVo;

public interface ProjectcaseService {

	public Map<String, Object> list(ProjectcaseQueryVo pcsvo);

	public Map<String, Object> add(Projectcase projectcase);

	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> update(Projectcase projectcase, HttpServletRequest req, HttpServletResponse resp);

}
