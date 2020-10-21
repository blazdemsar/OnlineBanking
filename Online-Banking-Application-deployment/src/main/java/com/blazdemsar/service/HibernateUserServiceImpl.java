package com.blazdemsar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.dao.UserDao;
import com.blazdemsar.domain.User;

@Service
public class HibernateUserServiceImpl implements HibernateUserService {
	
	@Autowired
	UserDao userDao;

	/*
	 * @Override public User save(User user) { return userDao.save(user); }
	 */

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	/*
	 * @Override public User findById(long id) { return userDao.findById(id); }
	 */
	
	

}
