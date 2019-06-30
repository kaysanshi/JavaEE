package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.ProductQueryVo;

public interface ProductMapper {

	public List<Product> query(ProductQueryVo qvp);

	public int add(Product product);

	public void delete(Integer[] ids);

	public int querySum(ProductQueryVo qvp);

	public int update(Product product);

	public Product queryById(Integer id);
}
