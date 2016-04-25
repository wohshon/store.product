package com.demo.store.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author wohshon
 *
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements GenericEntity<T> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5604007637459212032L;
	@Column(name="name")
	private String name;

	
	/* (non-Javadoc)
	 * @see com.demo.store.entity.GenericEntity#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.demo.store.entity.GenericEntity#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name=name;
	}

}
