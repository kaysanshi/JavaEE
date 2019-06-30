package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.News;
import cn.qfengx.portal.bean.NewsQueryVo;

public interface NewsMapper {

	public List<News> query(NewsQueryVo nvo);

	public int querySum(NewsQueryVo nvo);

	public int add(News news);

	public void delete(Integer[] ids);

	public int update(News news);

	public News queryById(Integer id);

}
