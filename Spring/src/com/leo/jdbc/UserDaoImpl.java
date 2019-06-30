package com.leo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leo.domain.User;
//不需要创建JDbc模板从父类方法获得即可
//public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
//super.getJdbcTemplate().
//可以直接将DataSource直接在这个类中注入时直接作为参数把数据源给注入就可以了
public class UserDaoImpl implements UserDao {
	private JdbcTemplate Jt;
	public JdbcTemplate getJt() {
		return Jt;
	}

	public void setJt(JdbcTemplate jt) {
		Jt = jt;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,'kkk','123','kkka222.COM')";
		Jt.update(sql);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql="delete from user where id=?";
		Jt.update(sql,id);
		System.out.println("删除成功");
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql="update user set name=?,password=?,email=? where id=?";
		Jt.update(sql, user.getName(),user.getPassword(),user.getEmail(),user.getId());
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from user";
		return Jt.queryForObject(sql, Integer.class);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from user ";
		
		 List<User> list=Jt.query(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			
		});
		return list;
	}

	@Override
	public User getUserbyId(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=?";
		return Jt.queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			
		},id);
	}

}
