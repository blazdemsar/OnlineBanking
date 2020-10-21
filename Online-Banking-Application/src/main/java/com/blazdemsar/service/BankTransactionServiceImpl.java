package com.blazdemsar.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.domain.BankTransaction;
import com.blazdemsar.domain.TransactionType;
import com.blazdemsar.repository.BankTransactionRepository;

@Service(value="JpaRepoBankTransactionServiceImpl")
public class BankTransactionServiceImpl implements BankTransactionService {
	
	@Autowired
	BankTransactionRepository bankTransactionRepository;
	
	@Override
	public BankTransaction save(BankTransaction bankTransaction) {
		
		return bankTransactionRepository.save(bankTransaction);
	}

	@Override
	public List<BankTransaction> findAll() {
		return bankTransactionRepository.findAll();
	}

	@Override
	public BankTransaction findById(Long transactionId) {
		
		Optional<BankTransaction> optBankTransaction = bankTransactionRepository.findById(transactionId);
		
		if (optBankTransaction.isPresent()) {
			return optBankTransaction.get();
		} else {
			return null;
		}
		
	}

//	@Override
//	public List<BankTransaction> findByLocalDateTimeBetween(Date from, Date to) {
//		return null;
//	}

	@Override
	public List<BankTransaction> findByTransactionType(TransactionType transactionType) {
		return bankTransactionRepository.findByTransactionType(transactionType);
	}

	@Override
	public List<BankTransaction> findByTrxFromAccount(Long trxFromAccount) {
		return bankTransactionRepository.findByTrxFromAccount(trxFromAccount);
	}

	@Override
	public List<BankTransaction> findByTrxToAccount(Long trxToAccount) {
		return bankTransactionRepository.findByTrxToAccount(trxToAccount);
	}

	@Override
	public void deleteById(Long trxId) {
		bankTransactionRepository.deleteById(trxId);
	}
	
	

}
