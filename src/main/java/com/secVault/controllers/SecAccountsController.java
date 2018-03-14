package com.secVault.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secVault.modal.LoginForm;
import com.secVault.modal.Search;
import com.secVault.modal.SecAccounts;
import com.secVault.service.Service;
@Controller
public class SecAccountsController {

	@Autowired
	Service service;

	@RequestMapping(value = "/SecAccounts", method = RequestMethod.GET)
	public String loginForm( Model model  , HttpServletRequest request, @ModelAttribute("string") Search searchString) {
		System.out.println("no model attribute .........................");
		System.out.println("In SecAccountsController and get() ") ;
		HttpSession session = request.getSession(false);
		String UserName = (String) session.getAttribute("UserName");
		List <SecAccounts> accounts = service.getAccounts( UserName);
		
		model.addAttribute("SecAccountsList", accounts);
	
		return "secAccounts";
  }
	
	
	
}