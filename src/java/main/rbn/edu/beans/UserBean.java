package rbn.edu.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.service.UserService;

@Component
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = -4387896804545360897L;

    @Autowired
    private UserService userService;

    public boolean isAutorizado() {
	return true;
    }

    public boolean isUsuarioLogado() {
	return userService.isUsuarioLogado();
    }

}