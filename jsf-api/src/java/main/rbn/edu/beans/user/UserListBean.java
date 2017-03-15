package rbn.edu.beans.user;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.User;
import rbn.edu.service.IUserService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserListBean {

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    public List<User> getProducts() {
	List<User> all = userService.getAll();
	User user = userService.getUserLogged();
	all.remove(user);
	return all;
    }

    public void remove() {
	try {
	    Long id = Long.valueOf(UtilJSF.getParameters().get("id"));
	    userService.remove(id);
	    UtilJSF.FaceMessage("User removed");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessage(e.getMessage());
	}
    }

    public String redirectToInfo() throws IOException {
	return "userInfo.xhtml";
    }

    public void setUserService(IUserService userService) {
	this.userService = userService;
    }

}
