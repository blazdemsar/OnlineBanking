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

import com.blazdemsar.domain.Branch;

@Component
public class BranchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Branch.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Branch branch = (Branch)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchId", "branch.branchId.empty", "Branch ID is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchName", "branch.branchName.empty", "Branch name is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAddress.addressLine1", "branch.branchAddress.addressLine1.empty", "Address line 1 is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAddress.addressLine2", "branch.branchAddress.addressLine2.empty", "Address line 2 is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAddress.city", "branch.branchAddress.city.empty", "City is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAddress.state", "branch.branchAddress.state.empty", "State customer is required." );
		
		System.out.println("====================printing the validation failures==========================");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Branch>> constraintViolations =  validator.validate(branch);
		
		System.out.println("********Size of ConstraintViolation: "+  constraintViolations.size() + " ************");
		
		for(ConstraintViolation<Branch> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
