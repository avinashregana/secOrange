package com.secVault.controllers;


import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.secVault.modal.Search;
import com.secVault.modal.SecAccounts;
import com.secVault.service.Service;

@Controller
public class LazyController {
	@Autowired
	Service service;

	@RequestMapping(value = "/lazy", method = RequestMethod.GET)
	public String getLazyAddress( Model model , @RequestParam("AccId") String AccId , HttpServletRequest request ,@ModelAttribute("string") Search searchString ) {

		System.out.println("In loazyContrller  and get() " );
		
		HttpSession session = request.getSession(false);
		String CustomerUserName = (String) session.getAttribute("UserName");
		
		List <SecAccounts> SecAccountsList = service.getAccounts(CustomerUserName);
		
		System.out.println(AccId +"  username from jsp model attribute");
		
		model.addAttribute("SecAccountsList", SecAccountsList);
		model.addAttribute("AccId", AccId);
		
		return "secAccounts";
	}
	
	
	@RequestMapping(value = "/sortByCompany", method = RequestMethod.GET)
	public String getSortCompany(Model model , HttpServletRequest request ,@ModelAttribute("string") Search searchString) {
	
		System.out.println("In sortByCompanyInLazy  and get() " );
		
		HttpSession session = request.getSession(false);
		String CustomerUserName = (String) session.getAttribute("UserName");
		
		@SuppressWarnings("unchecked")
		TreeSet <SecAccounts> SecAccountsList =  (TreeSet<SecAccounts>) service.accountsSortByCompany(CustomerUserName);

		
		model.addAttribute("SecAccountsList", SecAccountsList);
		
		
		return "secAccounts";
	}
	
	
	@RequestMapping(value = "/sortByDate", method = RequestMethod.GET)
	public String getSortByCreateDate(Model model , HttpServletRequest request ,@ModelAttribute("string") Search searchString) {
	
		System.out.println("In sortByCreateDate  and get() " );
		
		HttpSession session = request.getSession(false);
		String CustomerUserName = (String) session.getAttribute("UserName");
		
		@SuppressWarnings("unchecked")
		TreeSet <SecAccounts> SecAccountsList =  (TreeSet<SecAccounts>) service.accountsSortByCreateDate(CustomerUserName);

		
		model.addAttribute("SecAccountsList", SecAccountsList);
		
		
		return "secAccounts";
	}
	
}
