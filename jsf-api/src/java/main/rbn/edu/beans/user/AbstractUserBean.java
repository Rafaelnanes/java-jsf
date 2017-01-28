package rbn.edu.beans.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.enums.UserAuthorizationType;
import rbn.edu.model.User;
import rbn.edu.model.UserLevel;
import rbn.edu.service.IUserService;

public abstract class AbstractUserBean extends AbstractBean {

    private static final long serialVersionUID = -1409446027935733058L;

    @Autowired
    protected IUserService userService;

    protected User user;
    protected UserAuthorizationType authorizationType = UserAuthorizationType.ROLE_VISITOR;

    public AbstractUserBean() {
	super.init();
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

}
