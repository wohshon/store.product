package com.demo.store.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.demo.store.entity.AbstractGeneratedIdEntity;

@Entity
@Table(name="products")
public class Product extends AbstractGeneratedIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2757629634550945418L;

	
	@Column(name="description")
	private String description;
	@Column(name="shortDescription")
	private String shortDescription;
	@Column(name="price")
	private Double unitPrice;
	@Column(name="uom")
	private String uom;
	@Override
	public Long getId() {
		return this.Id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}

	
}
