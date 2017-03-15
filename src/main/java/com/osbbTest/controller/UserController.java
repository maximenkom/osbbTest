package com.osbbTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osbbTest.model.User;
import com.osbbTest.sevice.UserService;


@Controller
public class UserController {
	 @Autowired
	 private UserService userService;
	 
	 @RequestMapping(value = "/userpage", method = RequestMethod.GET)
	 public String showAdminPage(ModelMap model) {	
			String email = getLoggedInUserName();		 
		 	User user = userService.getUserByEmail(email);	
	        model.put("name",  email);	    
	        model.put("firstname",  user.getFirstname());
	        model.put("lastname",  user.getLastname());	    
	        model.put("email",  user.getEmail());	    
	        return "welcome";
	 }
	 
	 private String getLoggedInUserName() {
	        Object principal = SecurityContextHolder.getContext()
	                .getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails)
	            return ((UserDetails) principal).getUsername();

	        return principal.toString();
	    }
}
