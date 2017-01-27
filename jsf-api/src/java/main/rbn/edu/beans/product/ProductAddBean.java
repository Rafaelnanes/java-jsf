package rbn.edu.beans.product;

import java.io.IOException;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.model.Product;
import rbn.edu.service.IProductService;
import rbn.edu.util.UtilJSF;

@Component
@RequestScoped
public class ProductAddBean {

    @Autowired
    protected IProductService productService;

    private Product product = new Product();

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public ProductAddBean() {
	this.product = new Product();
    }

    public void addProduct() throws IOException {
	productService.add(product);
	// product = new Product();
	UtilJSF.FaceMessage("Product added");
	FacesContext.getCurrentInstance().getExternalContext().redirect("productList.xhtml");
    }

}
