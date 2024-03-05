package com.sp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.DAO.UserDAO;
import com.sp.api.UserDTO;
import com.sp.validators.UserValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class UserController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserDAO UserDAO;
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
	
	@GetMapping("/Users")
	public String showUsers(Model model) {
		List<com.sp.api.UserDTO> userList = UserDAO.loadUsers();
		model.addAttribute("users", userList);
		return "user-list";
	}
	
	
	@RequestMapping(value="/createAccount", method = RequestMethod.GET)
	public String createUser(Model model) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		return "create-user";
	}
	
	
	@RequestMapping(value="/saveAccount", method = RequestMethod.POST)
	public String createUser(HttpServletRequest request, HttpServletResponse response, @Validated UserDTO userDTO, Errors e, Model model) {
		Function<String, String> encode = BCryptPasswordEncoderWrapper::encode; 
		
		//here we validate that the table users doesnt contain an entry with pk `username.` we can create a validator, use our UserDAO
		//to make sure the username doesnt already exist. if it does we can return with an error. if it doesnt we can continue processing.
		
		
		if(e.hasErrors()) {
			System.out.println(e.toString());
			return "create-user";
		}
			
		//authenticate
		
		SecurityContext context = SecurityContextHolder.createEmptyContext(); 
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), "{bcrypt}" + encode.apply((userDTO.getPassword())), authorities);
		((AbstractAuthenticationToken) usernamePasswordAuthenticationToken).setDetails(new WebAuthenticationDetails(request));

		context.setAuthentication(usernamePasswordAuthenticationToken);

		SecurityContextHolder.setContext(context);
		HttpSessionSecurityContextRepository httpSessionSecurityContextRepository = new HttpSessionSecurityContextRepository();
		httpSessionSecurityContextRepository.saveContext(context, request, response);
		
		return "redirect:/tickets";
		
	}
	
	
	
}
