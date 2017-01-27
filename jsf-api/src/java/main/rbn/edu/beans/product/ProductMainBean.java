package rbn.edu.beans.product;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.beans.AbstractCrudBean;
import rbn.edu.config.AppConstants;
import rbn.edu.enums.OperationEnum;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
@Component
public class ProductMainBean extends AbstractCrudBean {

    private static final long serialVersionUID = -462161027450780784L;

    @Autowired
    protected IProductService productService;

    protected Product product = new Product();

    public ProductMainBean() {
	System.out.println("asdfasd");
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    @Override
    public void create() {
	productService.add(product);
	product = new Product();
	UtilJSF.FaceMessage("Product added");
    }

    @Override
    public void update() {
	productService.update(product);
	UtilJSF.FaceMessage("Product updated");
    }

    public void redirectToUpdate() throws IOException {
	String id = UtilJSF.getParameters().get("id");
	product = productService.getById(Integer.valueOf(id));
	operationName = OperationEnum.UPDATE;
	FacesContext.getCurrentInstance().getExternalContext().redirect(AppConstants.ROUTE_PRODUCT_MAIN);
    }

    public void redirectToCreate() throws IOException {
	product = new Product();
	operationName = OperationEnum.CREATE;
	FacesContext.getCurrentInstance().getExternalContext().redirect(AppConstants.ROUTE_PRODUCT_MAIN);
    }
}
