package com.blazdemsar.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blazdemsar.domain.BankTransaction;
import com.blazdemsar.domain.TransactionType;
import com.blazdemsar.service.BankTransactionService;

@RestController
public class DepositRestController {

	@Autowired	 
	@Qualifier(value="JpaRepoBankTransactionServiceImpl")
	BankTransactionService bankTransactionService;

	@RequestMapping(value="depositTransactions", method=RequestMethod.GET)
	public ResponseEntity<List<BankTransaction>> getAllDepositTransactions(){

		System.out.println("@DepositRestController.getAllDepositTransactions()......");

		List<BankTransaction> listOfDepositTransactions = bankTransactionService.findByTransactionType(TransactionType.DEPOSIT);

		if(listOfDepositTransactions.isEmpty()) {

			return new ResponseEntity<List<BankTransaction>>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<List<BankTransaction>>(listOfDepositTransactions, HttpStatus.ACCEPTED);

		}

	}

	@RequestMapping(value="saveDeposit", method=RequestMethod.POST)
	public ResponseEntity<BankTransaction> saveDeposit(@RequestParam("trxFromAccount") Long trxFromAccount, @RequestParam("trxToAccount") Long trxToAccount, @RequestParam("trxAmount") Double trxAmount, @RequestParam("comments") String comments) {

		System.out.println("@DepositRestController.saveDeposit()......");

		BankTransaction bankTransaction = new BankTransaction();

		bankTransaction.setTrxFromAccount(trxFromAccount);
		bankTransaction.setTrxToAccount(trxToAccount);
		bankTransaction.setTransactionType(TransactionType.DEPOSIT);
		bankTransaction.setTrxAmount(trxAmount);
		bankTransaction.setTrxLocalDateTime(LocalDateTime.now());
		bankTransaction.setComments(comments);

		BankTransaction trxFromDb = bankTransactionService.save(bankTransaction);

		return new ResponseEntity<BankTransaction>(trxFromDb, HttpStatus.ACCEPTED);

	}
	
	// http://localhost:8080/deleteDeposit/1
	@RequestMapping(value="deleteDeposit/{trxId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteDeposit(@PathVariable Long trxId){
		
		BankTransaction trxFromDb = bankTransactionService.findById(trxId);
		
		if(trxFromDb != null) {
			
			bankTransactionService.deleteById(trxId);
			
			return new ResponseEntity<String>("Bank transaction record with id: "+ trxId + "\" deleted", HttpStatus.ACCEPTED);
		
		} else {
			
			return new ResponseEntity<String>("No bank transaction with id: "+ trxId + "\" exists.", HttpStatus.ACCEPTED);
		
		}

	}

	// http://localhost:8080/updateDeposit/1?comments=DepositCommentFix
	@RequestMapping(value="updateDeposit/{trxId}", method=RequestMethod.PUT)
	public ResponseEntity<?>updateDeposit(@PathVariable Long trxId, @RequestParam String comments){

		BankTransaction trxFromDb = bankTransactionService.findById(trxId);

		if(trxFromDb != null) {

			trxFromDb.setComments(comments);

			BankTransaction updatedTrx = bankTransactionService.save(trxFromDb);

			return new ResponseEntity<BankTransaction>(updatedTrx, HttpStatus.ACCEPTED);

		}else {

			return new ResponseEntity<String>("Bank transaction with id: "+ trxId + " does not exist.", HttpStatus.ACCEPTED);

		}

	}

}
