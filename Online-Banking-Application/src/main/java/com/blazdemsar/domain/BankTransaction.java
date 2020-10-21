package com.blazdemsar.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BankTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trxID;
	
	private Long trxFromAccount;
	
	private Long trxToAccount;
	
	private Double trxAmount;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime trxLocalDateTime;
	
	private String comments;
	
	
	public BankTransaction(){
		
	}


	public Long getTrxID() {
		return trxID;
	}


	public void setTrxID(Long trxID) {
		this.trxID = trxID;
	}


	public Long getTrxFromAccount() {
		return trxFromAccount;
	}


	public void setTrxFromAccount(Long trxFromAccount) {
		this.trxFromAccount = trxFromAccount;
	}


	public Long getTrxToAccount() {
		return trxToAccount;
	}


	public void setTrxToAccount(Long trxToAccount) {
		this.trxToAccount = trxToAccount;
	}
	
	public Double getTrxAmount() {
		return trxAmount;
	}


	public void setTrxAmount(Double trxAmount) {
		this.trxAmount = trxAmount;
	}
	

	public TransactionType getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}


	public LocalDateTime getTrxLocalDateTime() {
		return trxLocalDateTime;
	}


	public void setTrxLocalDateTime(LocalDateTime trxLocalDateTime) {
		this.trxLocalDateTime = trxLocalDateTime;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
}
