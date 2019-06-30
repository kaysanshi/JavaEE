package com.kaysanshi.institute.mapper;

import java.util.List;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.CarouselQueryVo;

public interface CarouselMapper {

	List<Carousel> query(CarouselQueryVo cvo);

	int querySum(CarouselQueryVo cvo);

	int add(Carousel carousel);

	void delete(Integer[] ids);

	int update(Carousel carousel);

	int updatelogo(Carousel logo);

	Object querylogo();

	List<Carousel> queryAll();

}
