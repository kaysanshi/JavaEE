package com.leo.e3mall.service;


/**
 * 根据token查询用户信息
 * <p>Title: TokenService</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public interface TokenService {

	com.leo.e3mall.utils.E3Result getUserByToken(String token);
}
