package com.leo.bos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IFunctionDao;
import com.leo.bos.domain.AuthFunction;
import com.leo.bos.domain.User;
import com.leo.bos.service.IFunctionService;
import com.leo.bos.utils.PageBean;
import com.leo.bos.utils.SessionUtils;

/**
 * 
 * @author leoi555
 *
 */
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{
	@Autowired
	private IFunctionDao functionDao;

	@Override
	public List<AuthFunction> getlist() {
		// TODO Auto-generated method stub
		return functionDao.findAll();
	}

	@Override
	public void add(AuthFunction model) {
		// TODO Auto-generated method stub
		AuthFunction parentFunction=model.getAuthFunction();
		if (parentFunction !=null && parentFunction.getId().equals("")) {
			model.setAuthFunction(null);
		}
		functionDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		
		functionDao.pageQuery(pageBean);
	}

	@Override
	public List<AuthFunction> findMenu() {
		// TODO Auto-generated method stub
		User user=SessionUtils.getLoginUser();
		List<AuthFunction> list;
		if (user.getUsername().equals("admin")) {
			//如果是超级管理员内置用户则查询所有
			list=functionDao.findMenu();
		}else {
			list=functionDao.finMenuById(user.getId());
		}
		return list;
	}
}
