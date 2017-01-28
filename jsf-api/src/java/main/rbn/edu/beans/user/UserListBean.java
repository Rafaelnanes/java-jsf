package rbn.edu.beans.user;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.model.User;
import rbn.edu.service.IUserService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserListBean extends AbstractBean {

    private static final long serialVersionUID = 4088777198917593829L;

    @Autowired
    protected IUserService userService;

    @PostConstruct
    @Override
    protected void init() {
	super.init();
    }

    public List<User> getProducts() {
	return userService.getAll();
    }

    public void remove() {
	Long id = Long.valueOf(UtilJSF.getParameters().get("id"));
	userService.remove(id);
	UtilJSF.FaceMessage("User removed");
    }

    public String redirectToInfo() throws IOException {
	return "userInfo.xhtml";
    }

}
