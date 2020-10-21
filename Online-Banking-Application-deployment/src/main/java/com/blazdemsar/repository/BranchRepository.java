package com.blazdemsar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazdemsar.domain.Branch;


public interface BranchRepository extends JpaRepository<Branch, Long> {

}
