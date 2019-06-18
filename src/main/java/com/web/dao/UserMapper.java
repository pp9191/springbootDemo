package com.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.web.entity.User;

@Mapper
public interface UserMapper {
	Integer deleteByPrimaryKey(Integer id);

	Integer insert(User record);

	Integer insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(User record);

    Integer updateByPrimaryKey(User record);

    User login(User user);

	User selectByAccount(User user);
}