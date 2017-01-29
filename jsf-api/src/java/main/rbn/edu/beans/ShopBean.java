package rbn.edu.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

@ManagedBean
@ViewScoped
public class ShopBean extends AbstractBean {

    private static final long serialVersionUID = -4413587028392313849L;

    @Autowired
    private IProductService productService;

    private List<Product> products = new ArrayList<Product>();

    public ShopBean() {

    }

    @Override
    @PostConstruct
    protected void init() {
	super.init();
	products = productService.getAll();
    }

    public List<Product> getProducts() {
	return products;
    }

}
