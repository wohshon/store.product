package com.demo.store.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author virtuser
 *
 */
@MappedSuperclass
public abstract class AbstractGeneratedIdEntity extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7615846377514215474L;
	@Id
	@Column(name="id")
	protected Long Id;
	
	public void setId(Long id) {
		this.Id=id;
	}

}
