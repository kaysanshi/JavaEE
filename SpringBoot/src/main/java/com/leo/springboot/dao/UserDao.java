package com.leo.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.springboot.domain.User;

/**
 * dao层
 * @author leoi555
 *
 */
@Repository("userDao")
public interface UserDao extends JpaRepository<User,Long>{

}
