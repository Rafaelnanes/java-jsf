package rbn.edu.beans.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.enums.ProductType;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

public abstract class AbstractProductBean extends AbstractBean {

    private static final long serialVersionUID = -1409446027935733058L;

    @Autowired
    protected IProductService productService;

    protected Product product = new Product();

    protected List<ProductType> productTypes = new ArrayList<ProductType>();

    public AbstractProductBean() {
	super.init();
	for (ProductType type : ProductType.values()) {
	    productTypes.add(type);
	}
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

    public List<ProductType> getProductTypes() {
	return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
	this.productTypes = productTypes;
    }

}
