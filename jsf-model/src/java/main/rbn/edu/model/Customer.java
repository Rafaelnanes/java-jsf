package rbn.edu.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUS_CUSTOMER")
@AttributeOverrides({ @AttributeOverride(name = AbstractEntity.PK, column = @Column(name = Customer.PK)) })
public class Customer extends AbstractEntity<Long> {

    private static final long serialVersionUID = -8613133866202943705L;
    public static final String PK = "CUS_ID";

    @Column(name = "CUS_NAME")
    private String name;

    @Column(name = "CUS_EMAIL", unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.customer")
    private List<CustomerProduct> customerProducts;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public List<CustomerProduct> getCustomerProducts() {
	return customerProducts;
    }

    public void setCustomerProducts(List<CustomerProduct> customerProducts) {
	this.customerProducts = customerProducts;
    }

}
