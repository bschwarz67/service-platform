//this is essentially servlet.xml, each bean here is scoped within just this servlet context and can be overwritten in another context

package com.sp.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sp.controllers.ErrorController;
import com.sp.validators.TicketValidator;
import com.sp.validators.UserValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sp"})
public class ServicePlatformConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println(registry.toString());
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource dataSource() {
		
		if(System.getenv("RENDER") != null) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource(System.getenv("POSTGRESQL_PRIVATE_URL") + "?useSSL=false");
			System.out.println("testing simple output");
			System.out.println("testing picking up an env variable " + System.getenv("RENDER"));
			
			dataSource.setDriverClassName("org.postgresql.Driver");
			return dataSource;
			
		}
		else 
		{
			DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:" + System.getenv("MYSQL_PRIVATE_URL") + "?useSSL=false");
			System.out.println("testing simple output");
			System.out.println("testing picking up an env variable " + System.getenv("TEST"));
			//dataSource.setUsername(System.getenv("MYSQLUSER"));
			//dataSource.setPassword(System.getenv("MYSQLPASSWORD"));
			//dataSource.setUrl("jdbc:" + "MYSQL_PRIVATE_URL" + "?useSSL=false");
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			return dataSource;
		}
		
	}
	
	
	
	@Autowired
	public RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@Bean
	public ErrorController errorController() {
		return new ErrorController();
	}
	
	@Bean
	public Object service() {
		requestMappingHandlerMapping.setDefaultHandler(errorController());
		return new Object();
		
	}
	
	@Bean 
	TicketValidator ticketValidator() {
		return new TicketValidator();
	}
	@Bean 
	UserValidator userValidator() {
		return new UserValidator();
	}
	
}
