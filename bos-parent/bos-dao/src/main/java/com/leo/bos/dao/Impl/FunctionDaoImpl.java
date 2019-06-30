package com.leo.bos.dao.Impl;

import java.util.List;

import org.apache.xml.resolver.helpers.PublicId;
import org.springframework.stereotype.Repository;

import com.leo.bos.dao.IFunctionDao;
import com.leo.bos.dao.base.impl.BaseDaoImpl;
import com.leo.bos.domain.AuthFunction;
/**
 * 权限管理
 * @author leoi555
 *
 */
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<AuthFunction> implements IFunctionDao{
	
	@Override
	public List<AuthFunction> findAll() {
		String hql="From AuthFunction f where f.function is NULL";
		List<AuthFunction> list=(List<AuthFunction>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<AuthFunction> findFunctionbyUserId(String id) {
		// TODO Auto-generated method stub
		//这里加入select就是指定查询到权限表的对象 DISTINCT:排除重复的字段结果
		String hql="select DISTINCT f From AuthFunction f LEFT OUTER JOIN f.authRoles r LEFT OUTER JOIN r.TUsers u where u.id=?";
		List<AuthFunction> list=(List<AuthFunction>) this.getHibernateTemplate().find(hql, id);
		return list;
	}

	@Override
	public List<AuthFunction> findMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthFunction> finMenuById(String id) {
		// TODO Auto-generated method stub

		String hql="select DISTINCT f From AuthFunction f LEFT OUTER JOIN f.authRoles r LEFT OUTER JOIN r.TUsers u where u.id=? "
				+ "and f.generatemenu='1' order by f.zindex DESC";
		List<AuthFunction> list=(List<AuthFunction>) this.getHibernateTemplate().find(hql, id);
		return list;
	}
}
