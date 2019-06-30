package com.leo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.leo.domain.Orders;
import com.leo.domain.User;
import com.leo.mapper.OrderMapper;

/**
 * order输入类型的测试
 * @author leoi555
 *
 */
public class OrderMapperTest {
	/**
	 * 自动封装成pojo类型的
	 * @throws IOException
	 */
	
	public  void test1() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> orders=mapper.listOrder();
		for(Orders orders2:orders) {
			System.out.println(orders2);
		}
	}
	/**
	 * 手动封装成pojo类型的
	 * @throws IOException
	 */
	
	public  void test2() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> orders=mapper.listOrderByMap();
		for(Orders orders2:orders) {
			System.out.println(orders2);
		}
	}
	
	/**
	 * 一对一
	 * @throws IOException
	 */
	@Test
	public  void test3() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrders = mapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	/**
	 * 一对多
	 * @throws IOException
	 */
	@Test
	public  void test3_1() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<User> user = mapper.selectUsers();
		for (User user2s : user) {
			System.out.println(user2s);
		}
	}
}
