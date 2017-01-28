package rbn.edu.config;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "rbn.edu.config", "rbn.edu.beans" })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @PostConstruct
    private void setLocale() {
	Locale.setDefault(Locale.US);
    }
}
