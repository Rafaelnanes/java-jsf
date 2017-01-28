package rbn.edu.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rbn.edu.dao.IUserDAO;
import rbn.edu.dao.IUserLevelDAO;
import rbn.edu.model.User;
import rbn.edu.model.UserLevel;
import rbn.edu.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IUserLevelDAO userLevelDAO;

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
    @Transactional
    public User add(User t) {
	t.setPassword(new BCryptPasswordEncoder().encode(t.getPassword()));
	Set<UserLevel> userLevels = t.getUserLevels();
	User user = userDAO.add(t);
	for (UserLevel level : userLevels) {
	    userLevelDAO.add(level);
	}
	return user;
    }

    @Override
    @Transactional
    public User update(User t) {
	removeAllUserLevelsByUserId(t.getId());
	Set<UserLevel> userLevels = t.getUserLevels();
	User user = updateTransactional(t);
	for (UserLevel level : userLevels) {
	    userLevelDAO.add(level);
	}
	return user;
    }

    @Transactional
    private User updateTransactional(User t) {
	return userDAO.update(t);
    }

    @Transactional
    private void removeAllUserLevelsByUserId(long id) {
	userLevelDAO.removeAllByUserId(id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
	return userDAO.getAll();
    }

    @Override
    @Transactional
    public User getById(long id) {
	return userDAO.getById(id);
    }

    @Override
    @Transactional
    public void remove(long id) {
	removeAllUserLevelsByUserId(id);
	userDAO.remove(id);
    }

    @Override
    public UserLevel getUserLevelById(long id) {
	return userLevelDAO.getById(id);
    }

}
