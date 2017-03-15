package rbn.edu.beans.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

import rbn.edu.model.User;
import rbn.edu.service.IUserService;

@ManagedBean
@SessionScoped
public class UserBean {

    private User user = new User();

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    public boolean isUserLogged() {
	return userService.isUserLogged();
    }

    public String logout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	SecurityContextHolder.getContext().setAuthentication(null);
	return "/login.xhtml";
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public void setUserService(IUserService userService) {
	this.userService = userService;
    }

}