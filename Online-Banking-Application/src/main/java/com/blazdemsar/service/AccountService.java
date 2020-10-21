package com.blazdemsar.service;

import java.util.List;

import com.blazdemsar.domain.Account;

public interface AccountService {
	
	public Account save(Account account);
	public void deleteById(Long id);
	public Account updateById(Long id);
	public Account update(Account account);
	public List<Account> findAll();
	public Account findById(Long id);
	public List<Account> findByCustomerId(Long id);
	public List<Account> findByAccountHolder(String accountHolder);
	
	public double withdraw(Long accountId, Double amount);
	public double deposit(Long accountId, Double amount);
	public double transfer(Long fromAccountId, Long toAccountId, Double amount);
	public double getBalance(Long accountId);
	
}
