package cn.qfengx.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.News;
import cn.qfengx.portal.bean.NewsQueryVo;
import cn.qfengx.portal.bean.Newscate;
import cn.qfengx.portal.bean.NewscateQueryVo;
import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.mapper.NewsMapper;
import cn.qfengx.portal.mapper.NewscateMapper;

@Transactional
@Service("NewsServiceImpl")
public class NewsServiceImpl implements cn.qfengx.portal.service.NewsService {

	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private NewscateMapper newscateMapper;
	
	@Override
	public Map<String, Object> list(NewsQueryVo nvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		nvo.setStart((nvo.getPage() - 1) * nvo.getLimit());
		List<News> list = newsMapper.query(nvo);
		int sum = newsMapper.querySum(nvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> add(News news) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (newsMapper.add(news) > 0) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			newsMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> update(News news, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (newsMapper.update(news) > 0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> nquery() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		List<Newscate> list = newscateMapper.queryAll();
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", list.size());
		return res;
	}

	@Override
	public Map<String, Object> nlist(NewscateQueryVo ncvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		ncvo.setStart((ncvo.getPage() - 1) * ncvo.getLimit());
		List<Newscate> list = newscateMapper.query(ncvo);
		for (Newscate nc : list) {
			if (nc.getPid() != -1)
				nc.setPname(newscateMapper.findById(nc.getPid()).getName());
		}
		int sum = newscateMapper.querySum(ncvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> nadd(Newscate newscate) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (newscateMapper.add(newscate) > 0) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> nupdate(Newscate newscate) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (newscateMapper.update(newscate) > 0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> ndelete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			newscateMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> info(Integer id) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			News product=newsMapper.queryById(id);
			res.put("code", "0");
			res.put("msg", "获取成功");
			res.put("data", product);
		}catch (Exception e) {
			// TODO: handle exception
			res.put("code", "1");
			res.put("msg", "获取失败");
			res.put("data", null);
		}
		return res;
	}

}
