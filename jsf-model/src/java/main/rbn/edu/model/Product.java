package rbn.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rbn.edu.enums.ProductType;

@Entity
@Table(name = "PRO_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRO_ID")
    private long id;

    @Column(name = "PRO_NAME", nullable = false)
    private String name;

    @Column(name = "PRO_VALUE", nullable = false, precision = 10, scale = 2)
    private Double value;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "PRO_TYPE", nullable = false)
    private ProductType productType;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

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
