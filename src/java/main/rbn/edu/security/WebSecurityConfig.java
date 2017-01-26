package rbn.edu.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").and().formLogin()
		.loginPage("/login.xhtml").loginProcessingUrl("/appLogin").usernameParameter("j_username")
		.passwordParameter("j_password").defaultSuccessUrl("/main.xhtml").and().logout().logoutUrl("/index")
		.logoutSuccessUrl("/login.xhtml");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }

}
