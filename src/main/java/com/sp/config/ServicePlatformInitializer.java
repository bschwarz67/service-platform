
//this is essentially web.xml
package com.sp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServicePlatformInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class [] configFiles = {};
		return configFiles;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		// TODO Auto-generated method stub
		Class [] configFiles = {ServicePlatformConfig.class,ServicePlatformSecurityConfig.class};
		//Class [] configFiles = {ServicePlatformConfig.class};
		return configFiles;
		
		//return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] mappings =  {"/"};
		return mappings;
	}

}
