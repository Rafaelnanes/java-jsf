package rbn.edu.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

@ManagedBean
@ViewScoped
public class ShopBean {

    @ManagedProperty(value = "#{productService}")
    private IProductService productService;

    private List<Product> products = new ArrayList<Product>();

    public ShopBean() {

    }

    @PostConstruct
    protected void init() {
	products = productService.getAll();
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProductService(IProductService productService) {
	this.productService = productService;
    }

}
