package rbn.edu.beans.product;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.Product;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductListBean extends AbstractProductBean {

    public List<Product> getProducts() {
	return productService.getAll();
    }

    public void remove() {
	try {
	    Long id = Long.valueOf(UtilJSF.getParameters().get("id"));
	    productService.remove(id);
	    UtilJSF.FaceMessage("Product removed");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessage(e.getMessage());
	}
    }

    public String redirectToInfo() throws IOException {
	return "productInfo.xhtml";
    }

}
