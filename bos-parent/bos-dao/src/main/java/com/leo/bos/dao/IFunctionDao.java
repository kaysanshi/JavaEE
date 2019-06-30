package com.leo.bos.dao;

import java.util.List;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.domain.AuthFunction;

public interface IFunctionDao extends IBaseDao<AuthFunction>{
	/**
	 * 查询所有
	 */
	public List<AuthFunction> findAll();
	/**
	 * 根据用户id查询对应的权限
	 * @param id
	 * @return
	 */
	public List<AuthFunction> findFunctionbyUserId(String id);
	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<AuthFunction> findMenu();
	/**
	 * 根据用户id查询菜单
	 * @param id
	 * @return
	 */
	public List<AuthFunction> finMenuById(String id);
	
}
