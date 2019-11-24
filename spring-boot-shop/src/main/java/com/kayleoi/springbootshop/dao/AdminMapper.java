package com.kayleoi.springbootshop.dao;

import com.kayleoi.springbootshop.domain.Admin;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper <Admin> {
    @Override
    int deleteByPrimaryKey(Object key);

    @Override
    int delete(Admin record);

    @Override
    int insert(Admin record);

    @Override
    int insertSelective(Admin record);

    @Override
    boolean existsWithPrimaryKey(Object key);

    @Override
    List <Admin> selectAll();

    @Override
    Admin selectByPrimaryKey(Object key);

    @Override
    int selectCount(Admin record);

    @Override
    List <Admin> select(Admin record);

    @Override
    Admin selectOne(Admin record);

    @Override
    int updateByPrimaryKey(Admin record);

    @Override
    int updateByPrimaryKeySelective(Admin record);

    @Override
    int deleteByExample(Object example);

    @Override
    List <Admin> selectByExample(Object example);

    @Override
    int selectCountByExample(Object example);

    @Override
    Admin selectOneByExample(Object example);

    @Override
    int updateByExample(Admin record, Object example);

    @Override
    int updateByExampleSelective(Admin record, Object example);

    @Override
    List <Admin> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

    @Override
    List <Admin> selectByRowBounds(Admin record, RowBounds rowBounds);
}