package com.blazdemsar.validation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.blazdemsar.domain.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerId", "customer.customerId.empty", "Customer ID is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "customer.customerName.empty", "Customer name is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerGender", "customer.customerGender.empty", "Gender is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerDob", "customer.customerDob.empty", "Date of Birth is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerMobileNo", "customer.customerMobileNo.empty", "Mobile Nr. is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerPhone", "customer.customerPhone.empty", "Phone is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerEmail", "customer.customerEmail.empty", "Email is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress.addressLine1", "customer.customerAddress.addressLine1.empty", "Address line 1 is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress.addressLine2", "customer.customerAddress.addressLine2.empty", "Address line 2 is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress.city", "customer.customerAddress.city.empty", "City is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress.state", "customer.customerAddress.state.empty", "State is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "customer.ssn.empty", "SSN is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userId", "customer.user.userId.empty", "User ID is required." );
		
		System.out.println("====================printing the validation failures==========================");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Customer>> constraintViolations =  validator.validate(customer);
		
		System.out.println("********Size of ConstraintViolation: "+  constraintViolations.size() + " ************");
		
		for(ConstraintViolation<Customer> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
