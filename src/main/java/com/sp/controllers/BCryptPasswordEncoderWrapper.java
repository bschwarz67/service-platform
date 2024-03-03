package com.sp.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderWrapper {
	public static String encode(String password){  
		BCryptPasswordEncoder e = new BCryptPasswordEncoder();
		return e.encode(password); 
	}
         
}
