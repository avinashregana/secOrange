package com.secVault.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.secVault.modal.Customer;

@Component
public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> obj) {
		System.out.println("inside supports () in register validator.....2.......");
		boolean isValidClass = Customer.class.equals(obj);
		return isValidClass;
	}

	@Override
	public void validate(Object obj, Errors error) {
		
		System.out.println("in validate method..register..3........");
		
		Customer customer = (Customer) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "", "enter valid username");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "", "enter valid password");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstname", "", "enter valid firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastname", "", "enter valid lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "gender", "", "enter valid gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "ssn", "", "enter valid ssn");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "", "enter valid email");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "dob", "", "enter valid dob");
		
		System.out.println("in validate method.register...4........");
	}

	}



