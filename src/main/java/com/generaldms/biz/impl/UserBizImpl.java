package com.generaldms.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generaldms.biz.UserBiz;
import com.generaldms.dao.UserDao;
import com.generaldms.entity.User;

@Service("userBiz")
public class UserBizImpl implements UserBiz{
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	public User getUserByLogin(Map<String, String> pram) {
		// TODO Auto-generated method stub
		return userDao.getUserByLogin(pram);
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

}
