package com.leo.bos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IRegionDao;
import com.leo.bos.domain.BcRegion;
import com.leo.bos.service.IRegionService;
import com.leo.bos.utils.PageBean;
/**
 * 区域管理
 * @author leoi555
 *
 */
@Service
@Transactional
public class RegionServiceImpl implements IRegionService{
	@Autowired
	private IRegionDao regionDao;

	

	@Override
	public void saveBatch(List<BcRegion> list) {
		// TODO Auto-generated method stub
		//循环添加
		for(BcRegion region:list) {
		regionDao.saveOrUpdate(region);
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<BcRegion> getlist() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

	@Override
	public List<BcRegion> getlistByQ(String q) {
		// TODO Auto-generated method stub
		return regionDao.getListByQ(q);
	}
}
