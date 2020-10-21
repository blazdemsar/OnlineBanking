package com.blazdemsar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazdemsar.domain.Customer;
import com.blazdemsar.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer updateById(Long id) {
		return findById(id);
	}

	@Override
	public Customer update(Customer customer) {
		
		Customer customerFromDb = findById(customer.getCustomerId());
		
		customerFromDb.setCustomerName(customer.getCustomerName());
		customerFromDb.setCustomerGender(customer.getCustomerGender());
		customerFromDb.setCustomerDob(customer.getCustomerDob());
		customerFromDb.setCustomerMobileNo(customer.getCustomerMobileNo());
		customerFromDb.setCustomerPhone(customer.getCustomerPhone());
		customerFromDb.setCustomerEmail(customer.getCustomerEmail());
		customerFromDb.setCustomerAddress(customer.getCustomerAddress());
		customerFromDb.setSsn(customer.getSsn());
		customerFromDb.setCustomerAccounts(customer.getCustomerAccounts());
		customerFromDb.setUser(customer.getUser());
		
		return customerRepository.save(customerFromDb);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) {
		
		Optional<Customer> optCustomer = customerRepository.findById(id);
		
		if (optCustomer.isPresent()) {
			return optCustomer.get();
		} else {
			return null;
		}
		
	}

}
