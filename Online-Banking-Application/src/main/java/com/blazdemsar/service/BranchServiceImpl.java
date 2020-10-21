package com.blazdemsar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.domain.Branch;
import com.blazdemsar.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public Branch save(Branch branch) {
		
		return branchRepository.save(branch);
	}

	@Override
	public void deleteById(Long id) {
		
		branchRepository.deleteById(id);

	}

	@Override
	public Branch updateById(Long id) {
		
		return findById(id);
	}

	@Override
	public Branch update(Branch branch) {
		
		Branch branchFromDb = findById(branch.getBranchId());
		
		branchFromDb.setBranchName(branch.getBranchName());
		branchFromDb.setBranchAddress(branch.getBranchAddress());
		//branchFromDb.setBranchAccounts(branch.getBranchAccounts());
		
		return branchRepository.save(branchFromDb);
	}

	@Override
	public List<Branch> findAll() {
		
		return branchRepository.findAll();
	}

	@Override
	public Branch findById(Long id) {
		
		Optional<Branch> optBranch = branchRepository.findById(id);
		
		if (optBranch.isPresent()) {
			return optBranch.get();
		} else {
			return null;
		}
	}

}
