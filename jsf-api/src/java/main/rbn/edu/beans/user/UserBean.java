package rbn.edu.beans.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.model.User;
import rbn.edu.service.IUserService;

@ManagedBean
@SessionScoped
public class UserBean extends AbstractBean {

    private static final long serialVersionUID = -4387896804545360897L;
    private User user = new User();

    @Autowired
    private IUserService userService;

    @Override
    @PostConstruct
    protected void init() {
	super.init();
    }

    public boolean isUserLogged() {
	return userService.isUserLogged();
    }

    public String logout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml";
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

}