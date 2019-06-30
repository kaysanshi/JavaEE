package com.leo.mybatis;

import java.io.IOException;
import java.io.InputStream;
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
 * 通过测试包装类的查询
 * @author leoi555
 *
 */
public class Mybatis_Queryvo {
	@Test	
	public  void test1() throws IOException {
		// TODO Auto-generated method stub
		//加载核心配置文件
		String resource="sqlMapConfig2.xml";
		InputStream   in= Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,selectone:第一个参数是对的应的xml文件中的的id,第二个是对应的要传入的参数
		UserMapper mapper=sqlSession.getMapper(UserMapper.class);
		QueryVo vo=new QueryVo();
		User user=new User();
		user.setUsername("明");
		vo.setUser(user);
		List<User> list=mapper.findUserByQueryVo(vo);
		for(User u:list) {
			System.out.println(u);
		}
	}
}
