package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.domain.User;

public interface UserService {
	public User getUserById(int userId);

	public List<User> findAllUser();

	public User selectByUsername(String username);

	public User selectByEmail(String email);

	public void saveUser(User user);

	public int updateByPrimaryKeySelective(User record);

}
