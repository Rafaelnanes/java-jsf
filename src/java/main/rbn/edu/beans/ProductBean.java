package rbn.edu.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.model.Product;
import rbn.edu.service.ProductService;

@Component
@RequestScoped
public class ProductBean {

    private Product product = new Product();

    @Autowired
    private ProductService productService;

    public void addProduct() {
	productService.add(product);
	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Product added", "success");
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public ProductService getProductService() {
	return productService;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

}