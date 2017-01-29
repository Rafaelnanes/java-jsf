package rbn.edu.beans.user;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.UserLevel;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserUpdateBean extends AbstractUserBean {

    private static final long serialVersionUID = -5563557539843689988L;

    public UserUpdateBean() {
	String id = UtilJSF.getParameters().get("id");
	if (id != null) {
	    getBydId(Long.valueOf(id));
	}
	user.setPassword("");
    }

    public void update() {
	try {
	    Set<UserLevel> level = new HashSet<UserLevel>();
	    level.add(new UserLevel(authorizationType, user));
	    user.setUserLevels(level);
	    userService.update(user);
	    UtilJSF.FaceMessage("User updated");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessageError(e.getMessage());
	}
    }

}
