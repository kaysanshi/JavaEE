package com.leo.bos.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.leo.bos.dao.IFunctionDao;
import com.leo.bos.dao.IUserDao;
import com.leo.bos.domain.AuthFunction;
import com.leo.bos.domain.User;
/**
 * 
 * @author leoi555
 *
 */
public class BOSRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFunctionDao functionDao;
	//授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		//获取当前登陆对象
		User  user=(User) SecurityUtils.getSubject().getPrincipal();
		//User user=arg0.getPrimaryPrincipal();
		//根据当前登陆用户查询数据库获取实际对应的权限
		List<AuthFunction> list;
		if (user.getUsername().equals("admin")) {
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AuthFunction.class);
			//超级管理员内置用户查询所有权限
			list=functionDao.findByCriteria(detachedCriteria);
		}else {
			list=functionDao.findFunctionbyUserId(user.getId());
		}
		for(AuthFunction function:list) {
			//关键子权限的标识
			info.addStringPermission(function.getCode());;
		}
		return null;
	}
	//认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("方法认证中。。。。");
		UsernamePasswordToken passwordToken=(UsernamePasswordToken) arg0;
		//获取页面输入的用户名
		String username=passwordToken.getUsername();
		//根据用户名查询数据库中的密码
		User user=userDao.findUserByUsername(username);
		if (user==null) {
			return null;
		}
		//框架负者比对数据库中的密码和页面密码是否输入的一致
		//简单认证的对象
		AuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		
		return info;
	}

}
