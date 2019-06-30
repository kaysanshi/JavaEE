package com.leo.bos.serviceImpl;


import java.util.Iterator;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.dao.IUserDao;
import com.leo.bos.domain.AuthRole;
import com.leo.bos.domain.User;
import com.leo.bos.service.IuserService;
import com.leo.bos.utils.MD5Utils;
import com.leo.bos.utils.PageBean;
/**
 * 
 * @author leoi555
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IuserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//使用MD5加密
		String password=MD5Utils.md5(user.getPassword());
		System.out.println(user.getUsername()+":::"+user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
		
	}
	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		System.out.println(password);
		password=MD5Utils.md5(password);
		//userDao.executeUpdate("user.editpassword", id,password);
		userDao.editPassword(id,password);
	}
	@Override
	public void save(User model, String[] roleIds) {
		// TODO Auto-generated method stub
		//添加角色的同时先对密码进行加密然后在保存
		String password = model.getPassword();
		password=MD5Utils.md5(password);
		model.setPassword(password);
		userDao.save(model);
		if (roleIds!=null && roleIds.length>0) {
			for (String string : roleIds) {
				//保存的同时保存这个对象所具有的权限
				//手动关联托管对象
				AuthRole role=new AuthRole(string);
				//用户对象关联角色
				model.getAuthRoles().add(role);	
			}
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		userDao.pageQuery(pageBean);
	}

}
