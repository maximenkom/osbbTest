package com.osbbTest.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osbbTest.model.Counter;
import com.osbbTest.model.User;
import com.osbbTest.sevice.CounterService;
import com.osbbTest.sevice.UserService;


@Controller
public class UserController {
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private CounterService counterService;
	 
	 @RequestMapping(value = "/userpage", method = RequestMethod.GET)
	 public String showAdminPage(ModelMap model) {	
			String email = getLoggedInUserName();		 
		 	User user = userService.getUserByEmail(email);	
		 	List<Counter> usersCounters = new ArrayList<>();
	        usersCounters=userService.getUserCountersByID(user.getId());
	        model.put("name",  email);	    
	        model.put("firstname",  user.getFirstname());
	        model.put("lastname",  user.getLastname());	    
	        model.put("email",  user.getEmail()); 
	        model.put("countersList",  usersCounters);	
	        return "welcome";
	 }
	 
	 @RequestMapping(value = "/counter", method = RequestMethod.POST)
	 public String counterData(@RequestParam Long id, Double amount, ModelMap model ) {	
		 System.out.println("id "+id+" amount "+amount);
		Double payment = counterService.toPay(id, amount);
		 counterService.updateCounter(id, amount);
		 String email = getLoggedInUserName();		 
		 	User user = userService.getUserByEmail(email);	
		 	List<Counter> usersCounters = new ArrayList<>();
	        usersCounters=userService.getUserCountersByID(user.getId());
	        model.put("name",  email);	    
	        model.put("firstname",  user.getFirstname());
	        model.put("lastname",  user.getLastname());	    
	        model.put("email",  user.getEmail()); 
	        model.put("countersList",  usersCounters);	
	        model.put("payment", "To pay for "+counterService.getCounterById(id).getServiceType().getServiceName()+" "+new DecimalFormat("##.##").format(payment));	
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
