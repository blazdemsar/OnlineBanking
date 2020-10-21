package com.blazdemsar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blazdemsar.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	/*
	 * @Override public User save(User user) {
	 * 
	 * User userFromDb = findById(user.getUserId());
	 * 
	 * try {
	 * 
	 * session = sessionFactory.openSession(); session.beginTransaction();
	 * 
	 * if (userFromDb != null) { session.saveOrUpdate(user);
	 * 
	 * } else { session.save(user); }
	 * 
	 * session.getTransaction().commit(); System.out.println("The record for user "+
	 * user.getUserId() + " has been saved.");
	 * 
	 * } catch(Exception ex) {
	 * System.out.println("Problem in saving the user record....");
	 * ex.printStackTrace(); } finally { session.close(); }
	 * 
	 * return user; }
	 */

	@Override
	public List<User> findAll() {
		
		System.out.println("UserDaoImpl......................");
		
		List<User> users = new ArrayList<>();
		
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			users = session.createQuery("from User").list();
			for(User u : users) {
				System.out.println(u.getName() +", "+u.getUserId() + ", "+ u.getEmail());
			}
		}
		
		return users;
		
	}

	/*
	 * @Override public User findById(long id) {
	 * 
	 * User user = null;
	 * 
	 * try { session = sessionFactory.openSession(); session.beginTransaction();
	 * user = session.get(User.class, id); session.getTransaction().commit();
	 * }catch(Exception e) {
	 * System.out.println("Problem in retriving the user record.");
	 * e.printStackTrace(); }finally { session.close(); }
	 * 
	 * return user; }
	 */
	

}


