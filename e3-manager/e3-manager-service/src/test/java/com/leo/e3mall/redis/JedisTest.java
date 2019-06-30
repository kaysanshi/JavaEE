package com.leo.e3mall.redis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leo.e3mall.common.jedis.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * 使用jedis连接redis
 * @author leoill
 *TODO
 *2019年1月11日
 */
public class JedisTest {
	
	/**
	 * 测试的文件配置的形式
	 * @throws Exception
	 */
	public void testJedisClient() throws Exception{
		//初始化spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisClient jedis=(JedisClient) context.getBean(null, JedisClient.class);
		jedis.set("test12","my first jedis test");
		System.out.println(jedis.get("test12"));
	}
	
	@Test
	public void testJedis() {
		//创建一个连接的jedis对象参数host,port
		Jedis jedis=new Jedis("192.168.15.112",6379);
		//直接使用jedis操作reis所有的jedis的命令对应一个方法
		jedis.set("test123","my first jedis test");
		System.out.println(jedis.get("test123"));
		//关闭连接
		jedis.close();
	
	}
	/**
	 * 创建一个连接池对象(单机版)
	 */
	public void testJedisPool() {
		//创建一个连接池，两个参数host,port
		JedisPool jedisPool=new JedisPool("",6379);
		//重连接池获得一个连接，就是一个redis对象
		Jedis jedis= jedisPool.getResource();
		//使用jedis操作redis
		System.out.println(jedis.get("test123"));
		//关闭连接，每次使用完都要关闭连接
		jedis.close();
		//关闭连接池
		jedisPool.close();
	}
	/**
	 * 连接redis集群使用
	 */
	public void testJedisCluster() {
		//创建一个JedisCluser对象，有一个参数nodes是一个set类型，set中包含若干个hostandPort对象
		Set<HostAndPort>  nodes=new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.162", 7001));
		nodes.add(new HostAndPort("192.168.25.162", 7002));
		nodes.add(new HostAndPort("192.168.25.162", 7003));
		nodes.add(new HostAndPort("192.168.25.162", 7004));
		nodes.add(new HostAndPort("192.168.25.162", 7005));
		nodes.add(new HostAndPort("192.168.25.162", 7006));
		nodes.add(new HostAndPort("192.168.25.162", 7007));
		nodes.add(new HostAndPort("192.168.25.162", 7008));
		JedisCluster jedisCluster=new JedisCluster(nodes);
		//直接使用jedisCluser对象操作jedis
		jedisCluster.set("test", "123");
		String string=jedisCluster.get("test");
		System.out.println(string);
		//关闭集群连接对象
		jedisCluster.close();
	}
	
}
