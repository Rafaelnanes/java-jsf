package rbn.edu.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.service.IUserService;

@Component
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = -4387896804545360897L;

    @Autowired
    private IUserService userService;

    public boolean isUserLogged() {
	return userService.isUserLogged();
    }

    public String logout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml";
    }

}