package rbn.edu.beans.product;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

public abstract class AbstractProductBean extends AbstractBean {

    private static final long serialVersionUID = -1409446027935733058L;

    @Autowired
    protected IProductService productService;

    protected Product product = new Product();

    public AbstractProductBean() {
	super.init();
    }

    protected void getBydId(long id) {
	product = productService.getById(id);
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

}
