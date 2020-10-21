package com.blazdemsar.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blazdemsar.domain.Account;
import com.blazdemsar.domain.Customer;
import com.blazdemsar.domain.Role;
import com.blazdemsar.domain.User;
import com.blazdemsar.service.AccountService;
import com.blazdemsar.service.CustomerService;
import com.blazdemsar.service.UserService;
import com.blazdemsar.validation.CustomerValidator;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerValidator customerValidator;
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.addValidators(customerValidator); }
	 */
	
	@RequestMapping(value="customer")
	public String getCustomerForm(Customer customer, Model model) {
		System.out.println("@CustomerController.getCustomerForm(...)........ customer: "+ customer);
		
		//List<Account> accountList = accountService.findAll();
		//customer.setCustomerAccounts(accountList);
		
		//List<User> userList = userService.findAll();
		//Set<User> userSet

		//model.addAttribute("accountList", accountList);
		model.addAttribute("customers", customerService.findAll());
		
		return "customer";
	}
	
	@RequestMapping(value="/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer, BindingResult br, Model model) {
		System.out.println("@CustomerController.saveCustomer(...)........ customer: "+ customer);
		
		if (!br.hasErrors()) {
			
			Customer customerFromDb = customerService.save(customer);
			
		}
		
		model.addAttribute("customers", customerService.findAll());
		
		return "customer";
	}
	
	@RequestMapping(value="deleteCustomer")
	public String deleteCustomer(Customer customer, @RequestParam Long id, Model model) {
		System.out.println("@CustomerController.deleteCustomer(...)........ customer: "+ customer);
		
		customerService.deleteById(id);
		model.addAttribute("accounts", customerService.findAll());
		
		return "customer";
	}
	
	@RequestMapping(value="updateCustomer")
	public String updateCustomer(Customer customer, @RequestParam Long id, Model model) {
		System.out.println("@CustomerController.updateCustomer(...)........ customer: "+ customer);
		
		Customer c = customerService.findById(id);
		model.addAttribute("customer", c);
		
		model.addAttribute("customers", customerService.findAll());
		
		return "customer";
	}
}
