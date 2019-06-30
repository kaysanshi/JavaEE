package com.leo.bos.serviceImpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IRoleDao;
import com.leo.bos.domain.AuthFunction;
import com.leo.bos.domain.AuthRole;
import com.leo.bos.service.IRoleService;
import com.leo.bos.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao roleDao;

	@Override
	public void add(AuthRole model, String functionIds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(functionIds)) {
			String[] split = functionIds.split(",");
			for (String functionId : split) {
				//手动构造了一个对象设置id，对象为托管状态
				AuthFunction function=new AuthFunction(functionId);
				
				//角色关联权限（持久的关联托管的不可以关联瞬时的）
				model.getAuthFunctions().add(function);
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		roleDao.pageQuery(pageBean);
	}

	@Override
	public List<AuthRole> listRole() {
		return roleDao.findAll();
	}
}
