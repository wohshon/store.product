package com.demo.store.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import com.demo.store.entity.AbstractGeneratedIdEntity;


public abstract class AbstractDataService<E extends AbstractGeneratedIdEntity> implements DataService<E>{

	@PersistenceContext(unitName="products", type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	protected abstract Class<E> getType();
	protected abstract String getFindAllQuery();
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Override
	public E add(E entity) {
		this.getEntityManager().persist(entity);
		this.getEntityManager().flush();
 		return entity;
	}
	@Override
	public E get(E entity) {
		return this.getEntityManager().find(getType(),entity.getId());
	}

	@Override
	public List<E> getAllEntities() {
		Query q=entityManager.createQuery(getFindAllQuery());
		List<E> results=q.getResultList();
		return results;
	}

	@Override
	public List<E> query(Object... param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E remove(E entity) {
		entity=this.get(entity);
		this.getEntityManager().remove(entity);
		return entity;
	}
}

/*
 * if did not use @Stateless at the calling class, need to use user transaction
 	@Override
	public E add(E entity) {
		UserTransaction txn=null;
		try {
			txn = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			txn.begin();
			this.getEntityManager().persist(entity);
			this.getEntityManager().flush();
			txn.commit();
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			//do I want to close the em here??
		}
		
		return entity;
	}
  
 * */
