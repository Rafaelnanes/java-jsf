package rbn.edu.beans.product;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductAddBean extends AbstractProductBean {

    public void create() {
	try {
	    productService.add(product);
	    UtilJSF.FaceMessage("Product added");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessageError(e.getMessage());
	}
    }

}
