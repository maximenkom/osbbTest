package com.osbbTest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osbbTest.dao.HouseDao;
import com.osbbTest.model.User;
import com.osbbTest.sevice.HouseService;
import com.osbbTest.sevice.UserService;


@Controller
public class ManagerController {
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private HouseService houseService;
	
	 @RequestMapping(value = "/managerpage", method = RequestMethod.GET)
	 public String showAdminPage(ModelMap model) {	
		 	List<User> usersList = userService.getAll();
		 	String email = getLoggedInUserName();		 
		 //	User user = userService.getUserByEmail(email);	
		 //	houseService.getHouseByUsersId(user.getId());
		 //	Long houseId = houseDao.getHouseByUserId(user.getId());
		 //	System.out.println(houseService.getHouseByUsersId(user.getId()).getId());
		// 	usersList = userService.getHouseUsers(Long.valueOf("1"));		 
	        model.put("name", email);	 
	        model.put("users", usersList);
	        System.out.println(usersList);
	        return "manager";
	 }
	 
	 private String getLoggedInUserName() {
	        Object principal = SecurityContextHolder.getContext()
	                .getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails)
	            return ((UserDetails) principal).getUsername();

	        return principal.toString();
	    }
}
