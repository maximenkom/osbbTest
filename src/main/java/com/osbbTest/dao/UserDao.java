package com.osbbTest.dao;

import java.util.List;

import com.osbbTest.model.User;

public interface UserDao  extends CrudDao<User>{
	
	List<User> getAll();

	User getById(Long id);
	
	User getUserByEmail(String email);
	
	List<User> getAllByHouseId(Long id);
	
}
