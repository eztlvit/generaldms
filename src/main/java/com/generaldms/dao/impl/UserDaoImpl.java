package com.generaldms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.generaldms.dao.UserDao;
import com.generaldms.entity.User;
import com.generaldms.mapper.UserMapper;

@Repository(value="userDaoImpl")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getById(id);
	}

	public User getUserByLogin(Map<String, String> pram) {
		// TODO Auto-generated method stub
		return userMapper.getByLogin(pram);
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteById(id);
	}

}
