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

import com.blazdemsar.domain.Account;

@Component
public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Account account = (Account)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountId", "account.accountId.empty", "Account ID is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountBranch", "account.accountBranch.empty", "Branch is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountType", "account.accountType.empty", "Account type is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountHolder", "account.accountHolder.empty", "Account holder is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountDateOpened", "account.accountDateOpened.empty", "Date is required." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountCustomer", "account.accountCustomer.empty", "Account customer is required." );
		
		if(account.getAccountCurrentBalance() < 0) {
			errors.rejectValue("accountCurrentBalance", "account.accountCurrentBalance.value", "Account balance should be more than 0.");
		}
		
		System.out.println("====================printing the validation failures==========================");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Account>> constraintViolations =  validator.validate(account);
		
		System.out.println("********Size of ConstraintViolation: "+  constraintViolations.size() + " ************");
		
		for(ConstraintViolation<Account> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
