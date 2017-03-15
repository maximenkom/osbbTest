package com.osbbTest.sevice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbbTest.dao.HouseDao;
import com.osbbTest.model.House;


@Service(value = "houseService")
@Transactional
public class HouseService {
	@Autowired
	private HouseDao houseDao;
	
	
	public void deleteById(Long id) {
		House houseById = houseDao.getById(id);
		System.out.println(houseById);
		houseDao.delete(houseById);
	}
	
	public void add(String adress) {		
		House house = new House();
		house.setAdress(adress);
 			houseDao.add(house);
	}
	
	public void update(House house) {
		houseDao.update(house);}
	
	public void delete(House house) {
		houseDao.delete(house);}
		
	public List<House> getAll() {
		return houseDao.getAll();
	}
	
	public House getHouseByUsersId(Long usersId){
	return 	houseDao.getHouseByUserId(usersId);
	}
}
