package com.osbbTest.sevice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbbTest.dao.CounterDao;
import com.osbbTest.dao.HouseDao;
import com.osbbTest.dao.UserDao;
import com.osbbTest.dto.UserDTO;
import com.osbbTest.model.Counter;
import com.osbbTest.model.House;
import com.osbbTest.model.Role;
import com.osbbTest.model.User;



@Service(value = "userService")
@Transactional
public class UserService {	

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private CounterDao counterDao;

	public void addUserDTO(UserDTO userDTO) {
		User user = new User(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getPassword(), userDTO.getEmail(), userDTO.isEnabled(), userDTO.getRoomNumber());
		add(user);
		House house = houseDao.getById(userDTO.getHouseId());
		List<User> users = house.getUsers();// new ArrayList<>();
		users.add(user);
		house.setUsers(users);
		houseDao.update(house);
	}	
	
	public void add(User user) {
		    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			Set<Role> roles = new HashSet<>();
			roles.add(Role.ROLE_USER);
 			user.setRoles(roles);	 		
 			userDao.add(user);
	}
	
	public void update(User user) {
		userDao.update(user);}
	
	public void delete(User user) {
	    userDao.delete(user);}
		
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
		
	public User getById(long i) {
		return userDao.getById(i);
	}
	
	public List<User> getHouseUsers(Long houseId) {
		return	userDao.getAllByHouseId(houseId);
	}
	public List<Counter> getUserCountersByID(Long id) {
		return counterDao.getCountersByUsersId(id);
	}
}
