package cn.qfengx.portal.mapper;

import cn.qfengx.portal.bean.User;

public interface UserMapper {

	public User login(User user);

	public void updateLogin(User upuser);

	public int updatepwd(User requser);

}
