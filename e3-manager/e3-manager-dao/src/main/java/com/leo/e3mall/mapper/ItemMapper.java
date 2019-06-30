package com.leo.e3mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.leo.e3mall.pojo.Item;
import com.leo.e3mall.pojo.ItemExample;

public interface ItemMapper {

	List<Item> selectByExample(ItemExample example);
	
	int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);


    Item selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

}
