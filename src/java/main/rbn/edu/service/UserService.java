package rbn.edu.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isUsuarioLogado() {
	String login = null;
	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	try {
	    login = (String) authentication.getPrincipal();
	} catch (ClassCastException e) {
	    login = ((User) authentication.getPrincipal()).getUsername();
	}
	return login.equals("anonymousUser") ? false : true;
    }
}
