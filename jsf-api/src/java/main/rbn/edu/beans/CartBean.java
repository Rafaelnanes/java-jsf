package rbn.edu.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.Product;
import rbn.edu.model.User;
import rbn.edu.model.UserProduct;
import rbn.edu.model.UserProductId;
import rbn.edu.service.IUserProductService;
import rbn.edu.service.IUserService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@SessionScoped
public class CartBean extends AbstractBean {

    private static final long serialVersionUID = 2576703536386888771L;

    @Autowired
    private IUserProductService userProductService;
    @Autowired
    private IUserService userService;

    private Product productSelected = new Product();
    private List<Product> productsSelected = new ArrayList<Product>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Override
    @PostConstruct
    protected void init() {
	super.init();
    }

    public void saveCart() {
	try {
	    User user = userService.getUserLogged();
	    List<UserProduct> userProducts = new ArrayList<UserProduct>();
	    for (Product product : productsSelected) {

		UserProduct userProduct = new UserProduct();
		userProduct.setDate(new Date());
		UserProductId id = new UserProductId();
		id.setProduct(product);
		id.setUser(user);
		userProduct.setId(id);
		userProducts.add(userProduct);
	    }
	    userProductService.clear(user.getId());
	    userProductService.save(userProducts);
	    UtilJSF.FaceMessage("Cart saved");
	} catch (BusinessException e) {
	    UtilJSF.FaceMessage(e.getMessage());
	}
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
