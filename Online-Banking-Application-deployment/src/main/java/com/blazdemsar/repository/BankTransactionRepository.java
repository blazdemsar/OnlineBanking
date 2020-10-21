package com.blazdemsar.repository;

//import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazdemsar.domain.BankTransaction;
import com.blazdemsar.domain.TransactionType;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
	
	// Used only for display purposes
	// Don't use create, update, delete methods
	
	//public List<BankTransaction> findByLocalDateTimeBetween(Date from, Date to);
	public List<BankTransaction> findByTransactionType(TransactionType transactionType);
	public List<BankTransaction> findByTrxFromAccount(Long trxFromAccount);
	public List<BankTransaction> findByTrxToAccount(Long trxToAccount);
	
}
