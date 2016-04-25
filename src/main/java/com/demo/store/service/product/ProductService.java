package com.demo.store.service.product;

import com.demo.store.entity.product.Product;
import com.demo.store.service.AbstractDataService;

public class ProductService extends AbstractDataService<Product> {
	@Override
	protected String getFindAllQuery() {
		return "SELECT prod FROM Product prod";
	}
	@Override
	protected Class<Product> getType() {
		return Product.class;
	}
	
}
