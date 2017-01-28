package rbn.edu.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import rbn.edu.enums.ProductTypeEnum;
import rbn.edu.model.Product;

@ManagedBean
@ViewScoped
public class ShopBean extends AbstractBean {

    private static final long serialVersionUID = -4413587028392313849L;

    private List<Product> products = new ArrayList<Product>();

    public ShopBean() {
	Product p = new Product();
	p.setId((long) 1);
	p.setName("teste");
	p.setProductType(ProductTypeEnum.CAR);
	p.setValue(BigDecimal.TEN);
	products.add(p);
    }

    @Override
    @PostConstruct
    protected void init() {
	super.init();
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProducts(List<Product> products) {
	this.products = products;
    }

}
