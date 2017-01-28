package rbn.edu.beans.product;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductInfoBean extends AbstractProductBean {

    private static final long serialVersionUID = -462161027450780784L;

    public ProductInfoBean() {
	String id = UtilJSF.getParameters().get("id");
	if (id != null) {
	    getBydId(Long.valueOf(id));
	}
    }

}
