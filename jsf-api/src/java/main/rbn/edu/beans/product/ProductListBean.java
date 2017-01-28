package rbn.edu.beans.product;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import rbn.edu.beans.AbstractBean;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;
import rbn.edu.util.UtilJSF;

@ManagedBean
@ViewScoped
public class ProductListBean extends AbstractBean {

    private static final long serialVersionUID = 4088777198917593829L;

    @Autowired
    protected IProductService productService;

    @PostConstruct
    @Override
    protected void init() {
	super.init();
    }

    public List<Product> getProducts() {
	return productService.getAll();
    }

    public void remove() {
	Long id = Long.valueOf(UtilJSF.getParameters().get("id"));
	productService.remove(id);
	UtilJSF.FaceMessage("Product removed");
    }

}
