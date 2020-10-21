package com.blazdemsar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazdemsar.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
