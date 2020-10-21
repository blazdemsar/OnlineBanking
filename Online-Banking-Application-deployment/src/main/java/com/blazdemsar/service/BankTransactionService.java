package com.blazdemsar.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.blazdemsar.domain.BankTransaction;
import com.blazdemsar.domain.TransactionType;

public interface BankTransactionService {
	
	public BankTransaction save(BankTransaction bankTransaction);
	public List<BankTransaction> findAll();
	public BankTransaction findById(Long transactionId);
	//public List<BankTransaction> findByLocalDateTimeBetween(Date from, Date to);
	public List<BankTransaction> findByTransactionType(TransactionType transactionType);
	public List<BankTransaction> findByTrxFromAccount(Long trxFromAccount);
	public List<BankTransaction> findByTrxToAccount(Long trxToAccount);
	public void deleteById(Long trxId); 
	
}
