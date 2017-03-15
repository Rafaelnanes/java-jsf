package rbn.edu.beans.user;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import rbn.edu.enums.UserAuthorizationType;
import rbn.edu.model.User;
import rbn.edu.model.UserLevel;
import rbn.edu.service.IUserService;

@ManagedBean
public abstract class AbstractUserBean {

    @ManagedProperty(value = "#{userService}")
    protected IUserService userService;

    protected User user;
    protected UserAuthorizationType authorizationType = UserAuthorizationType.ROLE_VISITOR;

    public AbstractUserBean() {
	user = new User();
	user.setEnabled(true);
    }

    protected void getBydId(long id) {
	user = userService.getById(id);
	for (UserLevel level : user.getUserLevels()) {
	    authorizationType = level.getLevel();
	}
    }

    public List<UserAuthorizationType> getAuthorizations() {
	return UserAuthorizationType.getValues();
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public UserAuthorizationType getAuthorizationType() {
	return authorizationType;
    }

    public void setAuthorizationType(UserAuthorizationType authorizationType) {
	this.authorizationType = authorizationType;
    }

    public void setUserService(IUserService userService) {
	this.userService = userService;
    }

}
