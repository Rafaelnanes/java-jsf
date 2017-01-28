package rbn.edu.beans.product;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductAddBean extends AbstractProductBean {

    private static final long serialVersionUID = -462161027450780784L;

    public void create() {
	try {
	    productService.add(product);
	    UtilJSF.FaceMessage("Product added");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessage(e.getMessage());
	}
    }

}
