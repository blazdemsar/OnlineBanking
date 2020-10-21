package com.blazdemsar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blazdemsar.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public List<Account> findByAccountHolder(String accountHolder);
	
	//@Query(value="select * from account where customerId=:id", nativeQuery=true)
	@Query(value="select a from Account a where a.accountCustomer.customerId=:id")
	public List<Account> findByCustomerId(Long id);
	
}
