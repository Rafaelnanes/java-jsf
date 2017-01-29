package rbn.edu.beans.product;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductUpdateBean extends AbstractProductBean {

    private static final long serialVersionUID = -462161027450780784L;

    public ProductUpdateBean() {
	String id = UtilJSF.getParameters().get("id");
	if (id != null) {
	    getBydId(Long.valueOf(id));
	}
    }

    public void update() {
	try {
	    productService.update(product);
	    UtilJSF.FaceMessage("Product updated");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessageError(e.getMessage());
	}
    }

}
