package cn.qfengx.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.Accesslog;
import cn.qfengx.portal.mapper.AccesslogMapper;
import cn.qfengx.portal.service.LogService;

@Transactional
@Service("LogServiceImpl")
public class LogServiceImpl implements LogService {

	@Autowired
	private AccesslogMapper accesslogMapper;
	
	@Override
	public void addAccessLog(Accesslog accesslog) {
		// TODO Auto-generated method stub
		accesslogMapper.add(accesslog);
	}

	@Override
	public Map<String, Object> recent(Integer count) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		List<Accesslog> list = accesslogMapper.recent(count);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", list.size());
		return res;
	}

}
