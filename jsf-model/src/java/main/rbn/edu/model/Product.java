package rbn.edu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import rbn.edu.enums.ProductType;

@Entity
@Table(name = "PRO_PRODUCT")
@AttributeOverrides({ @AttributeOverride(name = AbstracEntity.PK, column = @Column(name = "PRO_ID")) })
public class Product extends AbstracEntity<Long> {

    private static final long serialVersionUID = -3721178740679096393L;

    @Column(name = "PRO_NAME", nullable = false)
    private String name;

    @Column(name = "PRO_VALUE", nullable = false, precision = 10, scale = 2)
    private Double value;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "PRO_TYPE", nullable = false)
    private ProductType productType;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Double getValue() {
	return value;
    }

    public void setValue(Double value) {
	this.value = value;
    }

    public ProductType getProductType() {
	return productType;
    }

    public void setProductType(ProductType productType) {
	this.productType = productType;
    }

}
