package rbn.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "rbn.edu.service.impl" })
public class ServiceImplConfig extends WebMvcConfigurerAdapter {

}