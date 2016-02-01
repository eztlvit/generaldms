package com.generaldms.biz;

import java.util.List;
import java.util.Map;

import com.generaldms.entity.User;

public interface UserBiz {
	public List<User> getAllUser();

	public User getUserById(int id);

	public User getUserByLogin(Map<String, String> pram);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);
}
