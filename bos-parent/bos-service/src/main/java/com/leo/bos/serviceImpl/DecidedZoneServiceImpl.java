package com.leo.bos.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IDecidedZoneDao;
import com.leo.bos.dao.ISubareaDao;
import com.leo.bos.domain.BcDecidedzone;
import com.leo.bos.domain.BcSubarea;
import com.leo.bos.service.IDecidedZoneService;
import com.leo.bos.utils.PageBean;
/**
 * 定区
 * @author leoi555
 *
 */
@Service
@Transactional
public class DecidedZoneServiceImpl implements IDecidedZoneService {
	@Autowired
	private IDecidedZoneDao decideDao;
	@Autowired
	private ISubareaDao subareaDao;
	@Override
	public void save(BcDecidedzone model, String[] subareaid) {
		// TODO Auto-generated method stub
		decideDao.save(model);
		//这里维护外键 一的一方放弃维护，只能由多方去维护这个外键
		for(String id : subareaid) {
			BcSubarea subarea = subareaDao.findById(id);
			subarea.setBcDecidedzone(model);//分区关联定区
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		decideDao.pageQuery(pageBean);
	}
}
