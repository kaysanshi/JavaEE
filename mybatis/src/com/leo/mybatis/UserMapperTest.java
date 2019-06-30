package com.leo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.leo.domain.QueryVo;
import com.leo.domain.User;
import com.leo.mapper.UserMapper;

/**
 * mapper动态代理
 * @author leoi555
 *
 */
public class UserMapperTest {
	/**
	 * 查询
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
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user=mapper.selectid(12);
		System.out.println(user);
	}
	/**
	 *查询
	 * @throws IOException
	 */
	@Test
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
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setSex("2");
		user.setUsername("王五");
		List<User> user1=mapper.selectUserBysexAndname(user);
		for(User user2:user1) {
			System.out.println(user2);
		}
	}
	/**
	 * 代理的
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
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> ids=new ArrayList<>();
		ids.add(10);
		ids.add(16);
		ids.add(22);
		QueryVo vo=new QueryVo();
		vo.setList(ids);
		List<User> user1=mapper.selectUserByIdsByQueryVo(vo); 
		for(User user2:user1) {
			System.out.println(user2);
		}
	}
	/**
	 * 代理的
	 * @throws IOException
	 */
	@Test
	public  void test_13() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> ids=new ArrayList<>();
		ids.add(10);
		ids.add(16);
		ids.add(22);
		QueryVo vo=new QueryVo();
		vo.setListinter(ids);
		List<User> user1=mapper.selectUserByIdsByQueryVo(vo); 
		for(User user2:user1) {
			System.out.println(user2);
		}
	}
	/**
	 * 数组
	 * @throws IOException
	 */
	@Test
	public  void test4() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Integer[] ids=new Integer[3];
		ids[0]=10;ids[1]=16;ids[2]=22;
		List<User> user1=mapper.selectUserByIdsByInteger(ids); 
		for(User user2:user1) {
			System.out.println(user2);
		}
	}
	/**
	 * 直接list
	 */
	@Test
	public  void test5() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession生成实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> ids=new ArrayList<>();
		ids.add(10);
		ids.add(16);
		ids.add(22);
		List<User> user1=mapper.selectUserByIdsByList(ids); 
		for(User user2:user1) {
			System.out.println(user2);
		}
	}
}
