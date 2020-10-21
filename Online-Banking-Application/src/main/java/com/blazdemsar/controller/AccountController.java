package com.blazdemsar.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blazdemsar.domain.Account;
import com.blazdemsar.domain.BankTransaction;
import com.blazdemsar.domain.Branch;
import com.blazdemsar.domain.Customer;
import com.blazdemsar.domain.User;
import com.blazdemsar.service.AccountService;
import com.blazdemsar.service.BankTransactionService;
import com.blazdemsar.service.BranchService;
import com.blazdemsar.service.CustomerService;
import com.blazdemsar.service.UserService;
import com.blazdemsar.validation.AccountValidator;

@Controller
public class AccountController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@Autowired
	BranchService branchService;

	@Autowired
	CustomerService customerService;

	@Autowired
	BankTransactionService bankTransactionService;

	@Autowired
	AccountValidator accountValidator;

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.addValidators(accountValidator); }
	 */

	@RequestMapping(value="account")
	public String getAccountForm(Account account, Model model, Principal principal) {
		System.out.println("@AccountController.getAccountForm(...)........ account: "+ account);
		List<Branch> branchList = branchService.findAll();
		Set<Branch> branchSet = new LinkedHashSet<>(branchList);

		String userName = principal.getName();

		User userFromDb = userService.findByName(userName);

		System.out.println(userFromDb.getName());

		if (userFromDb != null) {

			Customer custFromDb = customerService.findById(userFromDb.getUserId());

			if (custFromDb != null) {

				System.out.println(custFromDb.getCustomerName());
				System.out.println(custFromDb.getCustomerId());

				List<Account> yourAccounts = accountService.findByCustomerId(custFromDb.getCustomerId());

				if (yourAccounts != null) {

					System.out.println(yourAccounts);

					model.addAttribute("yourAccounts", yourAccounts);
				}
			}
		}




		model.addAttribute("branchSet", branchSet);
		model.addAttribute("customerSet", customerService.findAll());
		model.addAttribute("accounts", accountService.findAll());


		return "account";
	}

	//@PreAuthorize("hasAuthority('Administrator') && hasAuthority('User')")
	@RequestMapping(value="/saveAccount")
	public String saveAccount(@ModelAttribute Account account, BindingResult br, Model model) {
		System.out.println("@AccountController.saveAccount(...)........ account: "+ account);

		if (!br.hasErrors()) {

			Account accountFromDb = accountService.save(account);

		}

		model.addAttribute("accounts", accountService.findAll());

		return "account";
	}

	@RequestMapping(value="transfer")
	public String getTransferForm(BankTransaction bankTransaction, Model model) {
		System.out.println("@AccountController.getTransferForm(...)........ transfer: "+ bankTransaction);

		return "transfer";
	}

	@RequestMapping(value="makeTransfer")
	public String makeTransfer(@ModelAttribute BankTransaction bankTransaction, BindingResult br, Model model) {
		System.out.println("@AccountController.makeTransfer(...)........ transfer: "+ bankTransaction);

		Long fromAccount = bankTransaction.getTrxFromAccount();
		Long toAccount = bankTransaction.getTrxToAccount();
		double amount = bankTransaction.getTrxAmount();

		double result = accountService.transfer(fromAccount, toAccount, amount);

		bankTransaction.setTrxLocalDateTime(LocalDateTime.now());

		bankTransactionService.save(bankTransaction);

		//add to the model

		return "transfer";
	}

	@RequestMapping(value="deposit")
	public String getDepositForm(BankTransaction bankTransaction, Model model) {
		System.out.println("@AccountController.getDepositForm(...)........ deposit: "+ bankTransaction);

		return "deposit";
	}

	@RequestMapping(value="makeDeposit")
	public String makeDeposit(@ModelAttribute BankTransaction bankTransaction, BindingResult br, Model model) {
		System.out.println("@AccountController.makeDeposit(...)........ transfer: "+ bankTransaction);

		//Long fromAccount = bankTransaction.getTrxFromAccount();
		Long toAccount = bankTransaction.getTrxToAccount();
		double amount = bankTransaction.getTrxAmount();

		double result = accountService.deposit(toAccount, amount);

		bankTransaction.setTrxLocalDateTime(LocalDateTime.now());

		bankTransactionService.save(bankTransaction);

		//add to the model

		return "deposit";
	}

	@RequestMapping(value="withdraw")
	public String getWithdrawForm(BankTransaction bankTransaction, Model model) {
		System.out.println("@AccountController.getWithdrawForm(...)........ deposit: "+ bankTransaction);

		return "withdraw";
	}

	@RequestMapping(value="makeWithdrawal")
	public String makeWithdrawal(@ModelAttribute BankTransaction bankTransaction, BindingResult br, Model model) {
		System.out.println("@AccountController.makeWithdrawal(...)........ withdrawal: "+ bankTransaction);

		Long fromAccount = bankTransaction.getTrxFromAccount();
		//Long toAccount = bankTransaction.getTrxToAccount();
		double amount = bankTransaction.getTrxAmount();

		double result = accountService.withdraw(fromAccount, amount);

		bankTransaction.setTrxLocalDateTime(LocalDateTime.now());

		bankTransactionService.save(bankTransaction);

		//add to the model

		return "withdraw";
	}
	 
	@RequestMapping(value="transactions")
	public String getTransactionsForm(BankTransaction bankTransaction, Model model, Principal principal) {
		System.out.println("@AccountController.getTransactionsForm(...)........ transaction: "+ bankTransaction);

		String userName = principal.getName();

		User userFromDb = userService.findByName(userName);

		System.out.println(userFromDb.getName());

		if (userFromDb != null) {

			Customer custFromDb = customerService.findById(userFromDb.getUserId());

			if (custFromDb != null) {

				System.out.println(custFromDb.getCustomerName());
				System.out.println(custFromDb.getCustomerId());

				List<Account> yourAccounts = accountService.findByCustomerId(custFromDb.getCustomerId());

				if (yourAccounts != null) {

					System.out.println(yourAccounts);

					List<BankTransaction> yourTransactions = new ArrayList<>();

					for (Account acc : yourAccounts) {
						List<BankTransaction> yourFromTransactions = bankTransactionService.findByTrxFromAccount(acc.getAccountId());
						List<BankTransaction> yourToTransactions = bankTransactionService.findByTrxToAccount(acc.getAccountId());

						yourTransactions.addAll(yourFromTransactions);
						yourTransactions.addAll(yourToTransactions);
					}
					
					System.out.println(yourTransactions);
					
					model.addAttribute("yourTransactions", yourTransactions);
					
				}
			}
		}

		model.addAttribute("allTransactions", bankTransactionService.findAll());

		return "transactions";
	}

	@RequestMapping(value="login")
	public String login(@RequestParam(value="logout", required=false) String logout,
			@RequestParam(value="error", required=false) String error,
			HttpServletRequest request, HttpServletResponse response, Model model

			)
	{
		String message = null;
		System.out.println("@AccountController.login() ....");

		if(logout != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication !=null ) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
			message = "You have been logged out successfully.";
			return "login";
		}

		if(error != null) {
			message = "Your credentials do not match our records.";
		}

		model.addAttribute("message", message);
		return "login";

	}

	@GetMapping(value="accessDeniedPage")
	public String accessDenied() {	   
		return "accessDenied";
	}

	@RequestMapping(value= {"/", "/home"})
	public String getHomePage() {
		System.out.println("@AccountController.getHomePage(...)........ ");

		return "home";
	}

	//	@RequestMapping(value="delete")
	//	public String delete(Account account, @RequestParam Long id, Model model) {
	//		System.out.println("@AccountController.delete(...)........ account: "+ account);
	//		
	//		accountService.deleteById(id);
	//		model.addAttribute("accounts", accountService.findAll());
	//		
	//		return "account";
	//	}
	//	
	//	@RequestMapping(value="update")
	//	public String update(Account account, @RequestParam Long id, Model model) {
	//		System.out.println("@AccountController.delete(...)........ account: "+ account);
	//		
	//		Account a = accountService.findById(id);
	//		model.addAttribute("account", a);
	//		
	//		model.addAttribute("accounts", accountService.findAll());
	//		
	//		return "account";
	//	}



}
