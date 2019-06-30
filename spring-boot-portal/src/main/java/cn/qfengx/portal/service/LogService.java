package cn.qfengx.portal.service;

import java.util.Map;

import cn.qfengx.portal.bean.Accesslog;

public interface LogService {
	public void addAccessLog(Accesslog accesslog);

	public Map<String, Object> recent(Integer count);
}
