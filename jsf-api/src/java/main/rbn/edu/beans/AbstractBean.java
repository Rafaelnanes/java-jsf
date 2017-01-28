package rbn.edu.beans;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class AbstractBean implements Serializable {

    private static final long serialVersionUID = -2882208938979858817L;

    protected void init() {
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	ServletContext servletContext = (ServletContext) externalContext.getContext();
	WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
		.autowireBean(this);

    }

}
