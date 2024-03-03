package com.sp.validators;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.sp.api.UserDTO;
import com.sp.controllers.BCryptPasswordEncoderWrapper;

public class UserValidator implements Validator {

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		UserDTO userDTO = (UserDTO) target;
		Function<String, String> encode = BCryptPasswordEncoderWrapper::encode;
		if(userDTO.getUsername().length() > 20) {
			e.rejectValue("username", "incorrectUsernameFormatError", "please enter username in the correct format");
			return;
		}
		if(userDTO.getPassword().length() > 500) {
			e.rejectValue("password", "incorrectPasswordFormatError", "please enter password in the correct format");
			return;
		}
		if(userDTO.getJobTitle().length() > 20) {
			e.rejectValue("jobTitle", "incorrectJobTitleFormatError", "please enter job title in the correct format");
			return;
		}
		
		
		try {
			UserDetails user = User.builder()
		
				.username(userDTO.getUsername())
				.password("{bcrypt}" + encode.apply((userDTO.getPassword())))
				.roles("USER")
				//.passwordEncoder(encode) // {bcrypt} not getting added beforehand, when authenticating bcrypt isnt used to match by default
				//need to research this more to see how bcrypt can be automatically used in auth
				.build();
		
			userDetailsManager.createUser(user);		
		}
		catch(org.springframework.dao.DuplicateKeyException exception) {
			e.rejectValue("username", "duplicateUsernameError", "this username is already taken please choose another");
			System.out.println(exception.getMessage());
		}
		catch(Exception exception) {
			e.reject("unknown error",exception.toString());
			System.out.println(exception);
		}
		
		

	}

}
