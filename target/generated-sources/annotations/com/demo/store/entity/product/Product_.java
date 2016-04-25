package com.demo.store.entity.product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ extends com.demo.store.entity.AbstractGeneratedIdEntity_ {

	public static volatile SingularAttribute<Product, Double> unitPrice;
	public static volatile SingularAttribute<Product, String> uom;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, String> shortDescription;

}

