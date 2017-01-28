package rbn.edu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserProductId implements Serializable {

    private static final long serialVersionUID = -1233677136776599826L;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
