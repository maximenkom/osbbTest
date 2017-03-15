package com.osbbTest.dao;

public interface CrudDao<E> {
	void add(E entity);
	void update(E entity);
	void delete(E entity);
}
