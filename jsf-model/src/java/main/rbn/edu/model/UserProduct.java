package rbn.edu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAP_CUSTOMER_PRODUCT")
@AttributeOverrides({ @AttributeOverride(name = AbstractEntity.PK, column = @Column(name = "CAP_ID")) })
public class UserProduct extends AbstractEntity<Long> {

    private static final long serialVersionUID = -533496301514736714L;

    @ManyToOne
    @JoinColumn(name = "CAP_" + User.PK)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CAP_" + Product.PK)
    private Product product;

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

}
