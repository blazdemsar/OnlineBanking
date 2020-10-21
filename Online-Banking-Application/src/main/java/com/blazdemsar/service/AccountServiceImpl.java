package com.blazdemsar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.domain.Account;
import com.blazdemsar.domain.Branch;
import com.blazdemsar.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account updateById(Long id) {
		return findById(id);
	}

	@Override
	public List<Account> findByCustomerId(Long id) {
		return accountRepository.findByCustomerId(id);
	}

	@Override
	public Account update(Account account) {
		
		Account accountFromDb = findById(account.getAccountId());
		
		accountFromDb.setAccountBranch(account.getAccountBranch());
		accountFromDb.setAccountType(account.getAccountType());
		accountFromDb.setAccountHolder(account.getAccountHolder());
		accountFromDb.setAccountDateOpened(account.getAccountDateOpened());
		accountFromDb.setAccountCurrentBalance(account.getAccountCurrentBalance());
		accountFromDb.setAccountCustomer(account.getAccountCustomer());
		
		return accountRepository.save(accountFromDb);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(Long id) {
		
		Optional<Account> optAccount = accountRepository.findById(id);
		
		if (optAccount.isPresent()) {
			return optAccount.get();
		} else {
			return null;
		}
		
	}

	@Override
	public List<Account> findByAccountHolder(String accountHolder) {
		
		return accountRepository.findByAccountHolder(accountHolder);
	}

	@Override
	public double withdraw(Long accountId, Double amount) {
		
		Account accountFromDb = findById(accountId);
		
		double currentBalance = accountFromDb.getAccountCurrentBalance();
		
		if(currentBalance >= amount) {
			double newBalance = currentBalance - amount;
		
			accountFromDb.setAccountCurrentBalance(newBalance);
		
			Account updatedAccount = accountRepository.save(accountFromDb);
			
			return updatedAccount.getAccountCurrentBalance();
		}
		
		return -1;
	}

	@Override
	public double deposit(Long accountId, Double amount) {
		
		Account accountFromDb = findById(accountId);
		
		double currentBalance = accountFromDb.getAccountCurrentBalance();
		
		double newBalance = currentBalance + amount;
		
		accountFromDb.setAccountCurrentBalance(newBalance);
	
		Account updatedAccount = accountRepository.save(accountFromDb);
		
		return updatedAccount.getAccountCurrentBalance();
	}

	@Override
	public double transfer(Long fromAccountId, Long toAccountId, Double amount) {
		
		Account accountFromDb1 = findById(fromAccountId);
		Account accountFromDb2 = findById(toAccountId);
		
		double acc1currentBalance = accountFromDb1.getAccountCurrentBalance();
		double acc2currentBalance = accountFromDb2.getAccountCurrentBalance();
		
		if (acc1currentBalance > amount) {
			
			double newAcc1balance = acc1currentBalance - amount;
			double newAcc2balance = acc2currentBalance + amount;
			
			accountFromDb1.setAccountCurrentBalance(newAcc1balance);
			accountFromDb2.setAccountCurrentBalance(newAcc2balance);
			
			accountRepository.save(accountFromDb1);
			accountRepository.save(accountFromDb2);
			
			return 1;
			
		}
		
		return -1;
		
	}

	@Override
	public double getBalance(Long accountId) {

		Account accountFromDb = findById(accountId);
		
		return accountFromDb.getAccountCurrentBalance();
	}
	
	

}
