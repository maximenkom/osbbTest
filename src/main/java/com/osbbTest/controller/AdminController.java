package com.osbbTest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osbbTest.model.House;
import com.osbbTest.model.User;
import com.osbbTest.sevice.HouseService;



@Controller
public class AdminController {
	
	@Autowired
	private HouseService houseService;

	 @RequestMapping(value = "/adminpage", method = RequestMethod.GET)
	 public String showAdminPage(ModelMap model) {	
		 List<House> housesList = new ArrayList<>();
		 housesList = houseService.getAll();		 
	       
	        model.put("housesList",  housesList);	 	    
	        model.put("welcome", "Welcome "+ getLoggedInUserName());	    
	        
	        return "admin";
	 }
	 
	 @RequestMapping(value = "/adminpage", method = RequestMethod.POST)
	 public String addHouse(@RequestParam String adress, ModelMap model ) {	
		 houseService.add(adress);
	     model.put("message", "House added successfully "+ adress);	     
		 List<House> housesList = new ArrayList<>();
		 housesList = houseService.getAll();		 
	       
	        model.put("housesList",  housesList);	
		 model.put("welcome", getLoggedInUserName());	
		 
	        return "admin";
	 }
	 
	 @RequestMapping(value = "/deleteHouse", method = RequestMethod.POST)
	 public String deleteHouse(@RequestParam Long id, ModelMap model ) {
		 houseService.deleteById(id);
		 model.put("message", "House deleted successfully ");	  
		 List<House> housesList = new ArrayList<>();
		 housesList = houseService.getAll();		
		 model.put("housesList",  housesList);	
		 model.put("welcome", getLoggedInUserName());			
	        return "admin";
	 }
	 
	 private String getLoggedInUserName() {
	        Object principal = SecurityContextHolder.getContext()
	                .getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails)
	            return ((UserDetails) principal).getUsername();

	        return principal.toString();
	    }
	 
	 
	 
}
