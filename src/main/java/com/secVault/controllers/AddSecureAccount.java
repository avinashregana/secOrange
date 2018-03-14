package com.secVault.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secVault.modal.SecAccounts;
import com.secVault.service.Service;

@Controller
public class AddSecureAccount {
	@Autowired
	Service service;
	
	@RequestMapping(value = "/AddAccount", method = RequestMethod.GET )
	public String addSecureget(Model model , @ModelAttribute("addNewAccount") SecAccounts secAccount , HttpServletRequest request ) {

		System.out.println("in addSecureAccount() and doGet()");


		return "addNewAccount";
	}

	@RequestMapping(value = "/AddAccount", method = RequestMethod.POST )
	public String addSecurePost(Model model , @ModelAttribute("addNewAccount") SecAccounts secAccount , HttpServletRequest request ) {
		String result= null;
		System.out.println("in addSecureAccount() and doPost()");

		HttpSession session = request.getSession(false);
		String UserName = (String) session.getAttribute("UserName");

		if(service.insertAccount(secAccount,UserName)) {
			result = "dashBoard";
			System.out.println("sucess in controller post()");
			return "dashBoard";
		}
		
		return "AddAccount";
	}
}
