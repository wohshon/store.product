package com.demo.store.entity;

import java.io.Serializable;

/**
 * @author wohshon
 * Generic base class for all Entities
 */
public interface GenericEntity<T> extends Serializable {
	T getId();
	String getName();
	void setName(String name);	
}
