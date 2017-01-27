package rbn.edu.beans.product;

import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbn.edu.model.Product;
import rbn.edu.service.IProductService;
import rbn.edu.util.UtilJSF;

@Component
@RequestScoped
public class ProductListBean {

    @Autowired
    protected IProductService productService;

    public List<Product> getProducts() {
	return productService.getAll();
    }

    public String remove() {
	Long id = Long.valueOf(UtilJSF.getParameters().get("id"));
	productService.remove(id);
	return "productAdd.xhtml";
    }
}
