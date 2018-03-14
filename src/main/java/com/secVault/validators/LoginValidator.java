package com.secVault.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.secVault.modal.LoginForm;

@Component
public class LoginValidator implements Validator {

	
	
	@Override
	public boolean supports(Class<?> obj1) {
		System.out.println("inside supports () in login validator.....2.......");
		boolean isValidCalss = LoginForm.class.equals(obj1);
		return isValidCalss;
	}

	@Override
	public void validate(Object obj, Errors error) {
		System.out.println("in validate method....3........");
		LoginForm loginform = (LoginForm) obj ;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "", "enter valid username");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "", "enter valid password");
		
		System.out.println("in validate method....4........");
	}

}
