package rbn.edu.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import rbn.edu.enums.ProductTypeEnum;

@Entity
@Table(name = "PRO_PRODUCT")
@AttributeOverrides({ @AttributeOverride(name = AbstracEntity.PK, column = @Column(name = "PRO_ID")) })
public class Product extends AbstracEntity<Long> {

    private static final long serialVersionUID = -3721178740679096393L;

    @Column(name = "PRO_NAME", nullable = false)
    private String name;

    @Column(name = "PRO_VALUE", nullable = false, precision = 10, scale = 2)
    private BigDecimal value;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "PRO_TYPE", nullable = false)
    private ProductTypeEnum productType;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BigDecimal getValue() {
	return value;
    }

    public void setValue(BigDecimal value) {
	this.value = value;
    }

    public ProductTypeEnum getProductType() {
	return productType;
    }

    public void setProductType(ProductTypeEnum productType) {
	this.productType = productType;
    }

}
