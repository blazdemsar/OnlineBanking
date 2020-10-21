package com.blazdemsar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.dao.RoleDao;
import com.blazdemsar.domain.Role;

@Service (value="hibernateRoleService")
public class HibernateRoleServiceImpl implements HibernateRoleService {
	
	@Autowired
	RoleDao roleDao;
	
	/*
	 * @Override public Role createRole(Role role) { System.out.
	 * println("HibernateRoleServiceImpl......using hibernate in dao layer to save role object...."
	 * ); return roleDao.save(role); }
	 */

	@Override
	public List<Role> findAll() {
		System.out.println("HibernateRoleServiceImpl......using hibernate in dao layer to save role object....");
		return roleDao.findAll();
	}

}
