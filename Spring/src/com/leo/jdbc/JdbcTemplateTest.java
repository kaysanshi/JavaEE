package com.leo.jdbc;



import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbcTemplate类
 * @author leoi555
 *
 */
public class JdbcTemplateTest {
	
	@Test
	public void test() throws Exception {
		//c3p0连接池
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate");
		dataSource.setUser("root");
		dataSource.setPassword("123");
		JdbcTemplate jT=new JdbcTemplate();
		jT.setDataSource(dataSource);
		String sql="insert into user value(null,'123','adc','asssd.com')";
		jT.update(sql);
	}
	@Test
	public void test1() throws Exception {
		//c3p0连接池
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate");
		dataSource.setUser("root");
		dataSource.setPassword("123");
		JdbcTemplate jT=new JdbcTemplate();
		jT.setDataSource(dataSource);
		String sql="delete from user where id=1";
		jT.update(sql);
		System.out.println("删除成功");
	}
	@Test
	public void test3() throws Exception {
		//c3p0连接池
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate");
		dataSource.setUser("root");
		dataSource.setPassword("123");
		JdbcTemplate jT=new JdbcTemplate();
		jT.setDataSource(dataSource);
		String sql="update user set name='账',password='1223',email='asdw@oo.com' where id=1";
		jT.update(sql);
		System.out.println("修改成功");
	}
}
