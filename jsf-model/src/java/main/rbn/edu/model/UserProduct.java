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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	UserProduct other = (UserProduct) obj;
	if (date == null) {
	    if (other.date != null)
		return false;
	} else if (!date.equals(other.date))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
