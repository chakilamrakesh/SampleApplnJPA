package com.ojas.servlet.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 
 * @author kmahendra
 *
 */
public class WebServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }
 
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }
 
    @Override
    protected String[] getServletMappings() {
    	System.out.println("in Dispatcher servlet...");
        return new String[] { "/" };
    }
 
}

