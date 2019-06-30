package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.Projectcase;
import cn.qfengx.portal.bean.ProjectcaseQueryVo;

public interface ProjectcaseMapper {

	public List<Product> query(ProjectcaseQueryVo pcsvo);

	public int querySum(ProjectcaseQueryVo pcsvo);

	public int add(Projectcase projectcase);

	public int update(Projectcase projectcase);

	public void delete(Integer[] ids);

	public Projectcase queryById(Integer id);

}
