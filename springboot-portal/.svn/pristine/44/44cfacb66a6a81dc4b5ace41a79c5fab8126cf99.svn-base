package cn.qfengx.portal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qfengx.portal.bean.News;
import cn.qfengx.portal.bean.NewsQueryVo;
import cn.qfengx.portal.bean.Newscate;
import cn.qfengx.portal.bean.NewscateQueryVo;

public interface NewsService {

	public Map<String, Object> list(NewsQueryVo nvo);

	public Map<String, Object> add(News news);

	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> update(News news, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> nquery();

	public Map<String, Object> nlist(NewscateQueryVo ncvo);

	public Map<String, Object> nadd(Newscate newscate);

	public Map<String, Object> nupdate(Newscate newscate);

	public Map<String, Object> ndelete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);
}
