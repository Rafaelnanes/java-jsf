package rbn.edu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomerProductId implements Serializable {

    private static final long serialVersionUID = -1233677136776599826L;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Product product;

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

}
