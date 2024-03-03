
package com.sp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;



@Configuration
@EnableWebSecurity(debug=false)
public class ServicePlatformSecurityConfig {
	
	

	@Bean
	UserDetailsManager users(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		return users;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder builder = new MvcRequestMatcher.Builder(introspector);
		http
				.authorizeHttpRequests((authorizeRequests) -> authorizeRequests
				.requestMatchers(builder.pattern("/WEB-INF/view/**")).permitAll()
				.requestMatchers(builder.pattern("/WEB-INF/css/**")).permitAll()
				.requestMatchers(builder.pattern("/login")).permitAll()
				.requestMatchers(builder.pattern("/?continue")).permitAll()
				.requestMatchers(builder.pattern("/")).permitAll()
				.requestMatchers(builder.pattern("/createAccount")).permitAll()
				.requestMatchers(builder.pattern("/saveAccount")).permitAll()
				.anyRequest().authenticated()
				
			)
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll());
		
		return http.build();
	}
}