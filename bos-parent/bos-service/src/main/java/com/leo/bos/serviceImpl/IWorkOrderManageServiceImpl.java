package com.leo.bos.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IWorkOrderManageDao;
import com.leo.bos.domain.QpWorkordermanage;
import com.leo.bos.service.IWorkOrderManageService;
/**
 * 
 * @author leoi555
 *
 */
@Service
@Transactional
public class IWorkOrderManageServiceImpl  implements IWorkOrderManageService {
	@Autowired
	private IWorkOrderManageDao  workOrdermanageDao;

	@Override
	public void save(QpWorkordermanage model) {
		// TODO Auto-generated method stub
		workOrdermanageDao.save(model);
	}
}
