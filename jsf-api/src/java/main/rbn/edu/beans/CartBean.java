package rbn.edu.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import rbn.edu.model.Product;

@ManagedBean
@SessionScoped
public class CartBean extends AbstractBean {

    private static final long serialVersionUID = 2576703536386888771L;

    private Product productSelected = new Product();
    private List<Product> productsSelected = new ArrayList<Product>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Override
    @PostConstruct
    protected void init() {
	super.init();
    }

    public void addProduct() {
	totalPrice = totalPrice.add(productSelected.getValue());
	productsSelected.add(productSelected);
    }

    public void removeProduct(Product product) {
	for (int i = 0; i < productsSelected.size(); i++) {
	    Product productIterable = productsSelected.get(i);
	    if (productIterable.equals(product)) {
		totalPrice = totalPrice.subtract(productIterable.getValue());
		productsSelected.remove(i);
	    }
	}
    }

    public Product getProductSelected() {
	return productSelected;
    }

    public void setProductSelected(Product productSelected) {
	this.productSelected = productSelected;
    }

    public List<Product> getProductsSelected() {
	return productsSelected;
    }

    public void setProductsSelected(List<Product> productsSelected) {
	this.productsSelected = productsSelected;
    }

    public BigDecimal getTotalPrice() {
	return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
	this.totalPrice = totalPrice;
    }

}
