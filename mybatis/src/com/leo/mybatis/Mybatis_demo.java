package com.leo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.leo.domain.User;

/**
 * 
 * @author leoi555
 *
 */
public class Mybatis_demo {
	@Test	
	public  void test1() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		User user = sqlSession.selectOne("test.selectid", 10);
		System.out.println(user.getId());
		//释放资源
		sqlSession.close();
	}
	/**
	 * 模糊查询
	 * @throws IOException
	 */
	@Test	
	public  void test2() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		List<User> user = sqlSession.selectList("test.selectlist", "王");
		for(User user2:user) {
			System.out.println(user2);
		}
		//释放资源
		sqlSession.close();
	}
	/**
	 * 添加用户
	 */
	@Test	
	public  void test3() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		User user=new User();
		user.setUsername("kkka");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("北京");
		int i=sqlSession.insert("test.insertuser", user);
		//需要提交事务
		sqlSession.commit();
		//返回主键id
		int idString=user.getId();
		System.out.println("返回的主键id："+idString);
		//释放资源
		sqlSession.close();
	}
	/**
	 * update
	 * @throws IOException
	 */
	@Test	
	public  void test4() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		User user=new User();
		user.setId(22);
		user.setUsername("kkka");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("北京");
		int i=sqlSession.update("test.updateuser", user);
		//需要提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
	/**
	 * 删除
	 * @throws IOException
	 */
	public  void test5() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		sqlSession.delete("test.deleteUser",10);
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
}
