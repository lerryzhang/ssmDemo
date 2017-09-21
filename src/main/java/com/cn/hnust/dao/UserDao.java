package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.domain.User;

public interface UserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	public List<User> findAllUser();

	User selectByUsername(String username);

	User selectByEmail(String email);
}