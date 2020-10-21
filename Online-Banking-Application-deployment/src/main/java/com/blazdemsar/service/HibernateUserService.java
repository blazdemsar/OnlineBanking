package com.blazdemsar.service;

import java.util.List;

import com.blazdemsar.domain.User;

public interface HibernateUserService {
	
	//public User save(User user);
	public List<User> findAll();
	//public User findById(long id);
	
}
