package rbn.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rbn.edu.dao.IUserDAO;
import rbn.edu.model.User;
import rbn.edu.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public boolean isUserLogged() {
	String login = null;
	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	try {
	    login = (String) authentication.getPrincipal();
	} catch (ClassCastException e) {
	    login = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
	}
	return login.equals("anonymousUser") ? false : true;
    }

    @Override
    public User add(User t) {
	return userDAO.add(t);
    }

    @Override
    public User update(User t) {
	return userDAO.update(t);
    }

    @Override
    public List<User> getAll() {
	return userDAO.getAll();
    }

    @Override
    public User getById(long id) {
	return userDAO.getById(id);
    }

    @Override
    public void remove(long id) {
	userDAO.remove(id);
    }

}
