package com.osbbTest.dao;

import java.util.List;

import com.osbbTest.model.Counter;

public interface CounterDao extends CrudDao<Counter>{
	
	List<Counter> getCountersByUsersId(Long id);
	
	Counter getCounterById(Long id);
}
