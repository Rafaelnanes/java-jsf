package rbn.edu.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.CollectionUtils;

import rbn.edu.enums.PaymentEnum;

public class Payment implements Serializable {

    private static final long serialVersionUID = -5870895692436138557L;

    private PaymentEnum type;

    private List<UserProduct> userProducts;

    public PaymentEnum getType() {
	return type;
    }

    public void setType(PaymentEnum type) {
	this.type = type;
    }

    public List<UserProduct> getUserProducts() {
	return userProducts;
    }

    public void setUserProducts(List<UserProduct> userProducts) {
	this.userProducts = userProducts;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	if (type != null) {
	    sb.append("Type: ");
	    sb.append(type.toString());
	}
	if (!CollectionUtils.isEmpty(userProducts)) {
	    sb.append(", products size: ");
	    sb.append(userProducts.size());
	}
	return sb.toString();
    }

}
