package rbn.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()//

		.antMatchers("/app/user/**").access("hasRole('ROLE_ADMIN')")//
		.antMatchers("/app/product/**").access("hasRole('ROLE_ADMIN')")//
		.antMatchers("/app/customer/**").access("hasRole('ROLE_CUSTOMER')")//
		.and().exceptionHandling().accessDeniedPage("/403.xhtml")

		.and().formLogin().loginPage("/login.xhtml").loginProcessingUrl("/appLogin")
		.usernameParameter("j_username").passwordParameter("j_password").defaultSuccessUrl("/index.xhtml")//
		.and().logout().logoutUrl("/logout.xhtml").logoutSuccessUrl("/login.xhtml")//

		.and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	return encoder;
    }

}
