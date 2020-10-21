package com.blazdemsar.service;

import java.util.List;

import com.blazdemsar.domain.Customer;

public interface CustomerService {
	
	public Customer save(Customer customer);
	public void deleteById(Long id);
	public Customer updateById(Long id);
	public Customer update(Customer customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
	
}
