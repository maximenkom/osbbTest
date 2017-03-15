package com.osbbTest.dao;

import java.util.List;

import com.osbbTest.model.House;
import com.osbbTest.model.User;

public interface HouseDao extends CrudDao<House>{
	List<House> getAll();
	  public House getById(Long id);
	  House getHouseByUserId(Long id);
}
