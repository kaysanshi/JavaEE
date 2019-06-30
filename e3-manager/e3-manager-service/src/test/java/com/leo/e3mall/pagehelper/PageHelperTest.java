package com.leo.e3mall.pagehelper;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.e3mall.mapper.ItemMapper;
import com.leo.e3mall.pojo.Item;
import com.leo.e3mall.pojo.ItemExample;

public class PageHelperTest {
	
		@Deprecated
		public void testPageHelper() throws Exception{
			//初始化spring容器
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
			//从容器中获取Mapper代理对象
			ItemMapper itemMapper= (ItemMapper) applicationContext.getBean("ItemMapper");
			//执行sql语句的之前设置分页信息使用PageHelper的startPage方法。
			PageHelper.startPage(1, 10);
			//执行查询
			ItemExample example=new ItemExample();
			List<Item> list = itemMapper.selectByExample(example); 
			//取分页信息。PageInfo 1,总记录数，2.总页数，3.当前页码
			PageInfo<Item> pageInfo=new PageInfo<>(list);
			System.out.println(pageInfo.getTotal());
			System.out.println(pageInfo.getPages());
			System.out.println(list.size());
			
		}
}
