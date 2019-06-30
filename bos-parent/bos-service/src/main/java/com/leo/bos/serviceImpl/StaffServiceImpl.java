package com.leo.bos.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IStaffDao;
import com.leo.bos.domain.BcStaff;
import com.leo.bos.service.IStaffService;
import com.leo.bos.utils.PageBean;
/**
 * 取派员
 * @author leoi555
 *
 */
@Service
@Transactional
public class StaffServiceImpl implements IStaffService{
	@Autowired
	private IStaffDao staffDao;

	@Override
	public void addStaff(BcStaff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}

	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		if (Strings.isNotBlank(ids)) {
			String[] staffids=ids.split(",");
			//循环执行delete 语句
			for(String id:staffids) {
				staffDao.deleteBatch(id);
			}
 		}
	}

	@Override
	public BcStaff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}

	@Override
	public void update(BcStaff staff) {
		// TODO Auto-generated method stub
		staffDao.upadte(staff);
	}

	@Override
	public List<BcStaff> findlistNotdel() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BcStaff.class);
		//添加过滤条件把未删除的给拿出
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByCriteria(detachedCriteria);
	}
	
}
