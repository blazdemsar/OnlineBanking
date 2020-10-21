package com.blazdemsar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazdemsar.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
