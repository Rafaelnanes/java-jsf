package rbn.edu.beans.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.enums.ProductTypeEnum;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

public abstract class AbstractProductBean extends AbstractBean {

    private static final long serialVersionUID = -1409446027935733058L;

    @Autowired
    protected IProductService productService;

    protected Product product = new Product();

    protected List<ProductTypeEnum> productTypes = new ArrayList<ProductTypeEnum>();

    public AbstractProductBean() {
	super.init();
	for (ProductTypeEnum type : ProductTypeEnum.values()) {
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

    public List<ProductTypeEnum> getProductTypes() {
	return productTypes;
    }

    public void setProductTypes(List<ProductTypeEnum> productTypes) {
	this.productTypes = productTypes;
    }

}
