package com.blazdemsar.dao;

import java.util.List;

import com.blazdemsar.domain.User;

public interface UserDao {
	
	public List<User> findAll();
	
}
