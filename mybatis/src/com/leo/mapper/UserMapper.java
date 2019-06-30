package com.leo.mapper;
/**
 * mapper动态代理
 * @author leoi555
 *
 */

import java.util.List;


import com.leo.domain.QueryVo;
import com.leo.domain.User;

public interface UserMapper {
	//遵循四个原则
	//接口方法名==user.xml中的id名
	//返回类型要与map.xml返回一致
	//参数类型也要一致
	//在配置的xml文件namspace要写这个类名
	public User selectid(Integer id);
	public User selectlist(String username);
	//通过
	public  List<User> findUserByQueryVo(QueryVo vo);
	//根据性别和名字查询用户
	public List<User> selectUserBysexAndname(User user);
	//根据多个id来查询：通过数组，通过list，通过代理的对象
	public List<User> selectUserByIdsByInteger(Integer[] ids);
	public List<User> selectUserByIdsByList(List<Integer> ids);
	public List<User> selectUserByIdsByQueryVo(QueryVo ids);
	
}
