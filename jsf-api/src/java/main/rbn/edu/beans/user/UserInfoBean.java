package rbn.edu.beans.user;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserInfoBean extends AbstractUserBean {

    private static final long serialVersionUID = -5563557539843689988L;

    public UserInfoBean() {
	String id = UtilJSF.getParameters().get("id");
	if (id != null) {
	    getBydId(Long.valueOf(id));
	}
    }

}
