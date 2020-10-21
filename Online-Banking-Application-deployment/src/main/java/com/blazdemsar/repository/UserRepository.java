package com.blazdemsar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazdemsar.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByName(String name);
}
