package com.leo.bos.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.ISubareaDao;
import com.leo.bos.domain.BcSubarea;
import com.leo.bos.service.ISubareaService;
import com.leo.bos.utils.PageBean;
/**
 * 分区
 * @author leoi555
 *
 */
@Service
@Transactional
public class SuareaServiceImpl implements ISubareaService {
	@Autowired
	private ISubareaDao subDao;

	@Override
	public void save(BcSubarea model) {
		// TODO Auto-generated method stub
		subDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subDao.pageQuery(pageBean);
	}

	@Override
	public List<BcSubarea> findAll() {
		// TODO Auto-generated method stub
		return subDao.findAll();
	}
	/**
	 * 查询所有未关联定区的分区
	 */
	@Override
	public List<BcSubarea> findListNotAssociation() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BcSubarea.class);
		//添加过滤条件,分区对象中decidedzone属性为null
		detachedCriteria.add(Restrictions.isNull("bcDecidedzone"));
		return subDao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Object> findSubareaGroupByProvince() {
		// TODO Auto-generated method stub
		return subDao.findSubareaGroupByProvince();
	}
}
