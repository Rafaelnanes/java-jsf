package rbn.edu.beans.user;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.model.User;
import rbn.edu.service.IUserService;

public abstract class AbstractUserBean extends AbstractBean {

    private static final long serialVersionUID = -1409446027935733058L;

    @Autowired
    protected IUserService userService;

    protected User user;

    public AbstractUserBean() {
	super.init();
	user = new User();
	user.setEnabled(true);
    }

    protected void getBydId(long id) {
	user = userService.getById(id);
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
