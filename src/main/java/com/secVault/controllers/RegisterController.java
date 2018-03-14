package com.secVault.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.secVault.modal.Customer;
import com.secVault.service.Service;
import com.secVault.validators.RegisterValidator;

@Controller
public class RegisterController {

	@Autowired
	RegisterValidator registerValidator;

	@Autowired
	Service service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println("in init binder ...register........1......");
		binder.setValidator(registerValidator);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm( Model model, @ModelAttribute("register")  Customer cust) {
		System.out.println("In RegisterCOntroller and get() *** " );
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerFormSubmit( Model model, @ModelAttribute("register") @Validated Customer cust, BindingResult result) {
		
		System.out.println("in register post 5");
		
		if(result.hasErrors())
		{
			System.out.println("in if binding result has error....6.......");
			//model.addAttribute("register", new Register());
			// model.addAttribute("login", "All fiels must be filled");
			return "register";
		}

		System.out.println("In RegisterCOntroller and post() *** " );
		if(cust.getUsername() == null || cust.getUsername().trim().equals("") || cust.getPassword() == null || cust.getPassword().trim().equals("")) {
			if(cust.getUsername() == null || cust.getUsername().trim().equals("")) {
				model.addAttribute("userNameErr", "Please enter a valid username");
			}
			if(cust.getPassword() == null || cust.getPassword().trim().equals("")) {
				model.addAttribute("passwordErr", "Please enter a valid password");
			}		
		}
		else if(cust.getPassword().length()<4) {
			model.addAttribute("passwordErr", " password criteria do not match");	
		}
		else {
			System.out.println(cust.getFirstname()+ "first name in register post() controller");
			if(service.customerRegister(cust) == true) {
				model.addAttribute("result", " registration sucessfull");
			}
			else {
				model.addAttribute("result", " registration failed check enterd fields");
			}
		}
		return "register";
	}
}
