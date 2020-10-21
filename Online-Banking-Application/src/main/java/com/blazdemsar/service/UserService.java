package com.blazdemsar.service;

import java.util.List;

import com.blazdemsar.domain.User;

public interface UserService {
	
	public User createUser(User user);
	public User findByName(String name);
	public List<User> findAll();
	public boolean existsById(Long id);
	public void deleteById(Long id);
	public User findById(Long id);
	
}
