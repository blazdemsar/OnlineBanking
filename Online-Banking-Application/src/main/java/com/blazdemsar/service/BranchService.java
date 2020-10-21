package com.blazdemsar.service;

import java.util.List;

import com.blazdemsar.domain.Branch;

public interface BranchService {
	
	public Branch save(Branch branch);
	public void deleteById(Long id);
	public Branch updateById(Long id);
	public Branch update(Branch branch);
	public List<Branch> findAll();
	public Branch findById(Long id);
	
}
