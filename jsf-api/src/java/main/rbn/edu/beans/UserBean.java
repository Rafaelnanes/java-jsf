package rbn.edu.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.service.IUserService;

@Component
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = -4387896804545360897L;

    @Autowired
    private IUserService userService;

    public boolean isAuthorized() {
	return true;
    }

    public boolean isUserLogged() {
	return userService.isUserLogged();
    }

    public String getLogout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml";
    }

}