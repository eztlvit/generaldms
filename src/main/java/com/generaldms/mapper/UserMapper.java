package com.generaldms.mapper;

import java.util.List;
import java.util.Map;

import com.generaldms.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    List<User> getAll();
    
    User getById(int id);
    
    void deleteById(int id);
    
    void update(User user);
    
    User getByLogin(Map<String, String> pram);
}