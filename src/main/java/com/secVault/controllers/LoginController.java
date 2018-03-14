package com.secVault.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.secVault.modal.LoginForm;
import com.secVault.service.Service;
import com.secVault.validators.LoginValidator;

/**
 * <role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager-gui"/>
 * @author avinashregana
 *
 */
@Controller
//@RequestMapping("/controller")
public class LoginController {
	@Autowired
	Service service;
	
	@Autowired
	LoginValidator loginValidator;
	
	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println("in init binder ...........1......");
		binder.setValidator(loginValidator);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm( Model model,  HttpServletRequest request  , @ModelAttribute("loginnnn")  LoginForm loginForm ) {

		System.out.println("In LoginCOntroller and loginForm() getmethod() " );
		
		/*LoginForm loginForm = new LoginForm();
		model.addAttribute("loginnnn", loginForm); */
		// the above step is similar to request.setAttribute("", "");

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginFormSubmit( Model model, @ModelAttribute("loginnnn") @Validated LoginForm loginForm,BindingResult result, HttpServletRequest request )//,@ModelAttribute("searchString") Search searchString) 
	{
System.out.println("in login post........5......");
		//Map<String, Object> map = model.asMap();
		//LoginForm loginForm = (LoginForm) map.get("loginnnn");
		System.out.println("In LoginCOntroller and loginFormSubmit() *** " + loginForm.getUsername());
		System.out.println("Entered Username : " + loginForm.getUsername());

//		if((loginForm.getUsername() == null ||loginForm.getUsername().equals("")) && (loginForm.getPassword() == null ||loginForm.getPassword().equals(""))) {
//			model.addAttribute("login", "login failed invalid username or password is empty");
//			System.out.println("if user name password are null");
//			return "login";
//		}
		if(result.hasErrors())
		{
			System.out.println("in if binding result has error....6.......");
			//model.addAttribute("register", new Register());
			// model.addAttribute("login", "All fiels must be filled");

			return "login";
		}
		
		 if(	service.loginCustomer(loginForm.getUsername(), loginForm.getPassword()) ) {
			model.addAttribute("login", "login sucessfull");
			System.out.println("login sucess");

			HttpSession session = request.getSession();
			session.setAttribute("UserName", loginForm.getUsername());
			return "dashBoard";
		}
		else {
			System.out.println("else case in login controller");
			model.addAttribute("login", "login failed invalid username or password");
		}

		return "login";
	}
}
