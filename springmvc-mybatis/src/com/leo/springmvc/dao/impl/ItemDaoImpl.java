package com.leo.springmvc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.leo.springmvc.dao.ItemDao;
import com.leo.springmvc.domain.Items;
import com.leo.springmvc.domain.ItemsExample;
/**
 * 相当于动态mapper的实现类
 * @author leoi555
 *
 */
public class ItemDaoImpl extends SqlSessionDaoSupport implements ItemDao {

	@Override
	public List<Items> getItemsList() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		/**
		 * spring获得mybatis的sqlsession然后获得代理的mapper实现mapper接口
		 */
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		System.out.println(mapper);
		 List<Items> list = mapper.getItemsList();
		System.out.println(list);
		return list;
	}

	@Override
	public Items getItemById(String idInteger) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = this.getSqlSession();
		/**
		 * spring获得mybatis的sqlsession然后获得代理的mapper实现mapper接口
		 */
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		System.out.println(mapper);
		 Items item= mapper.getItemById(idInteger);
		System.out.println(item);
		return item;
	}

	@Override
	public void updateItemById(Items items) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		/**
		 * spring获得mybatis的sqlsession然后获得代理的mapper实现mapper接口
		 */
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		System.out.println(mapper);
		mapper.updateItemById(items);
	}

	@Override
	public void deleteItemsByIdByQbyArray(Integer[] ids) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		/**
		 * spring获得mybatis的sqlsession然后获得代理的mapper实现mapper接口
		 */
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		System.out.println(mapper);
		mapper.deleteItemsByIdByQbyArray(ids);
	}

	@Override
	public void updateItemsByIdByQList(List<Items> itemsList) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		/**
		 * spring获得mybatis的sqlsession然后获得代理的mapper实现mapper接口
		 */
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		System.out.println(mapper);
		mapper.updateItemsByIdByQList(itemsList);
	}

}
