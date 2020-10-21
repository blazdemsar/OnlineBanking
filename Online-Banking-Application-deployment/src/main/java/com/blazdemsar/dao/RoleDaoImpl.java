package com.blazdemsar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blazdemsar.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public RoleDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 * @Override public Role save(Role role) {
	 * 
	 * System.out.println("Inside of UserDaoImpl.save..... : " + role);
	 * 
	 * String sql = "insert into role(roleId, name) values(?, ?)";
	 * System.out.println("jdbcTemplate : " );
	 * 
	 * jdbcTemplate.update(sql, role.getRoleId(), role.getName()); return role; }
	 */

	@Override
	public List<Role> findAll() {
		
		System.out.println("Inside of EmployeeDaoImpl.findAll.....");
		String sql = "select * from role";
		
		final List<Role> allRoles = jdbcTemplate.query(sql, new RoleMapper());
		
		return allRoles;
	}

}

class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Role role = new Role();
		
		role.setRoleId(rs.getInt("roleId"));
		role.setName(rs.getString("name"));
		
		return role;
	}
	
}
