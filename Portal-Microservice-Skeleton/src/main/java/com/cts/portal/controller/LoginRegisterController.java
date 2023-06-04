package com.cts.portal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.portal.feign.AuthorisingClient;
import com.cts.portal.model.JwtRequest;
import com.cts.portal.model.User;

@Controller
@RequestMapping("/portal")
@SessionAttributes("username")
public class LoginRegisterController {

	@Autowired
	private AuthorisingClient client;

	/**
	 * @param user
	 * @param model
	 * @return login view
	 */
	@GetMapping(value = "/login")
	public String showLoginPage(@ModelAttribute("user") JwtRequest user, Model model) {
		return "login";
	}

	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/logout")
	public String logoutAndShowLoginPage(Model model, HttpServletRequest request) {
		/*
		 * set session as invalidate 
		 * set username to null
		 */
		request.getSession().invalidate();
		model.addAttribute("username", null);
		return "redirect:/portal/login";
	}

	@PostMapping(value = "/login")
	public String afterLoginAuthenticateAndRedirect(@ModelAttribute("user") JwtRequest user, Model model,
			HttpServletRequest request) {
		/*
		 * call authentication microservice client
		 * generate the token
		 * if excepyions occured while generating token, redirect to same view
		 * otherwise return welcome view
		 */
		ResponseEntity<?> responseGenerated = null;
		try {
			
			responseGenerated = client.createAuthenticationToken(user);
			

		} catch (Exception e) {
			System.out.println(e.getMessage()+"=========================");
			e.printStackTrace();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}
		/*
		 * retreive jwt token from map set it to session
		 */
		@SuppressWarnings("unchecked")
		Map<String, String> tokenMap = (Map<String, String>) responseGenerated.getBody();
		String token = tokenMap.get("token");
		
		request.getSession().setAttribute("Authorization", "Bearer " + token);
		request.getSession().setAttribute("userName", user.getUserName());
		
		// change for checking admin or not -- Deep Roy
		return (user.getUserName().equals("admin"))? "admin-welcome-page" : "user-welcome-page";
	}
	
	@GetMapping("/gotoregister")
	public String gotoRegister(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model) {
		
		
	ResponseEntity<String>  resp =	client.craeteNewUser(user);
	
	System.out.println(resp.getBody().toString());
	if(resp.getStatusCodeValue()==201)
	{
		model.addAttribute("message", "Succcessly registered! Login now");
		user.setUserName(null);
		user.setPassword(null);
		return "login";
	}
	else
	{model.addAttribute("message", "Not Succcessly registered! Register again");
		
		
		return "register";
	}
	}
}
