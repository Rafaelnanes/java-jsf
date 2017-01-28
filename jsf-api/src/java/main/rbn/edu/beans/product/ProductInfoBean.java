package rbn.edu.beans.product;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductInfoBean extends AbstractProductBean {

    private static final long serialVersionUID = -462161027450780784L;

    public String redirectToInfo() throws IOException {
	return "productInfo.xhtml";
    }

}
