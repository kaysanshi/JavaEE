package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.Carousel;
import cn.qfengx.portal.bean.CarouselQueryVo;

public interface CarouselMapper {

	public List<Carousel> query(CarouselQueryVo cvo);

	public int querySum(CarouselQueryVo cvo);

	public int add(Carousel carousel);

	public int update(Carousel carousel);

	public void delete(Integer[] ids);

	public List<Carousel> queryAll();

}
