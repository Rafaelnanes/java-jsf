package rbn.edu.beans.user;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.model.User;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserAddBean extends AbstractUserBean {

    private static final long serialVersionUID = -5563557539843689988L;

    public void add() {
	userService.add(user);
	user = new User();
	UtilJSF.FaceMessage("Customer added");
    }

}
