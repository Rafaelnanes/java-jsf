package rbn.edu.beans.product;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import rbn.edu.enums.ProductTypeEnum;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

@ManagedBean
public abstract class AbstractProductBean {

    @ManagedProperty(value = "#{productService}")
    protected IProductService productService;

    protected Product product = new Product();

    protected List<ProductTypeEnum> productTypes = new ArrayList<ProductTypeEnum>();

    public AbstractProductBean() {
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

    public void setProductService(IProductService productService) {
	this.productService = productService;
    }

}
