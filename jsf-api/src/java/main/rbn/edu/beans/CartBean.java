package rbn.edu.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.util.CollectionUtils;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.Product;
import rbn.edu.model.User;
import rbn.edu.model.UserProduct;
import rbn.edu.service.IUserProductService;
import rbn.edu.service.IUserService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@SessionScoped
public class CartBean {

    @ManagedProperty(value = "#{userProductService}")
    private IUserProductService userProductService;

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    private Product productSelected = new Product();
    private List<Product> productsSelected = new ArrayList<Product>();
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private User user;

    @PostConstruct
    protected void init() {
	user = userService.getUserLogged();
	List<UserProduct> cartItens = userProductService.getByUser(user.getId());
	if (!CollectionUtils.isEmpty(cartItens)) {
	    for (UserProduct up : cartItens) {
		productsSelected.add(up.getProduct());
		totalPrice = totalPrice.add(up.getProduct().getValue());
	    }
	}

    }

    public void saveCart() {
	try {
	    List<UserProduct> userProducts = new ArrayList<UserProduct>();
	    for (Product product : productsSelected) {
		UserProduct userProduct = new UserProduct();
		userProduct.setProduct(product);
		userProduct.setUser(user);
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

    public String redirectToPay() {
	saveCart();
	return "paymentCenter.xhtml";
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

    public void setUserProductService(IUserProductService userProductService) {
	this.userProductService = userProductService;
    }

    public void setUserService(IUserService userService) {
	this.userService = userService;
    }

}
