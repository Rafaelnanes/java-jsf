package rbn.edu.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[] { ApplicationConfig.class, HibernateConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return null;
    }

    @Override
    protected Filter[] getServletFilters() {
	return new Filter[] {};
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }
}
