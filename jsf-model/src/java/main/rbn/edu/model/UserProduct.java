package rbn.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CAP_CUSTOMER_PRODUCT")
@AssociationOverrides({ @AssociationOverride(name = "id.customer", joinColumns = @JoinColumn(name = User.PK)),
	@AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = Product.PK)) })
public class UserProduct implements Serializable {

    private static final long serialVersionUID = -533496301514736714L;

    @EmbeddedId
    private UserProductId id;

    @Column(name = "CAP_DATE")
    private Date date;

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public UserProductId getId() {
	return id;
    }

    public void setId(UserProductId id) {
	this.id = id;
    }

}
