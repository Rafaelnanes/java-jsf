package rbn.edu.beans.user;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.User;
import rbn.edu.model.UserLevel;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserAddBean extends AbstractUserBean {

    public void add() {
	try {
	    Set<UserLevel> level = new HashSet<UserLevel>();
	    level.add(new UserLevel(authorizationType, user));
	    user.setUserLevels(level);
	    userService.add(user);
	    user = new User();
	    UtilJSF.FaceMessage("User added");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessageError(e.getMessage());
	}
    }

}
