package rbn.edu.beans.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class UserInfoBean extends AbstractUserBean {

    @PostConstruct
    private void init() {
	String id = UtilJSF.getParameters().get("id");
	if (id != null) {
	    getBydId(Long.valueOf(id));
	}
    }

}
