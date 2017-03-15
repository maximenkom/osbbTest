package com.osbbTest.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.osbbTest.dto.UserDTO;
import com.osbbTest.model.House;
import com.osbbTest.model.User;
import com.osbbTest.sevice.HouseService;
import com.osbbTest.sevice.UserService;

@Controller
public class LoginController {
	
	 @Autowired
	    private UserService userService;
	 
	 @Autowired
	    private HouseService houseService;
	
	   private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/registration", method= RequestMethod.GET)
	public String getRegistrationPage(Model model){
		 model.addAttribute("houses", houseService.getAll());
		 model.addAttribute("userForm", new UserDTO());
		return "registration";
	}
	
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public ModelAndView registration(@ModelAttribute("userForm") UserDTO userForm, Model model) {	       
		
		  System.out.println("house "+userForm.getHouseId());
	      
	        userService.addUserDTO(userForm);	     
	      
	        ModelAndView modelandView = new ModelAndView();
			
	        modelandView.addObject("error", "User added successfully, now you can login");
		
			
	        modelandView.setViewName("login");

			return modelandView;
	        
	        
	      //  return "redirect:/login";
	    }
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String showWelcomePage(ModelMap model) {	
		return getRedirectPath();
	}
		  
	 
	 private String getRedirectPath() {
			UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Set<String> authorities = new HashSet<>();
			for (GrantedAuthority authority : principal.getAuthorities()) {
				authorities.add(authority.getAuthority());
			}
			if (authorities.contains("ROLE_ADMIN")) {
				return "redirect:/adminpage";
			} else if (authorities.contains("ROLE_MANAGER")) {
				  
				return "redirect:/managerpage";
			} else {
				return "redirect:/userpage";
			}
		}
	 	 
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
			}
			
			model.setViewName("login");

			return model;

		}
		
		private String getErrorMessage(HttpServletRequest request, String key) {

			Exception exception = (Exception) request.getSession().getAttribute(key);

			String error = "";
			if (exception instanceof BadCredentialsException) {
				error = "Invalid username or password!";
			} else if (exception instanceof LockedException) {
				error = exception.getMessage();
			} else {
				error = "Invalid username or password!";
			}

			return error;
		}
	 
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public String logout(HttpServletRequest request,
	            HttpServletResponse response) {	
		
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);	
	        }	       
	        return "redirect:/";
	    }	 	 
	 
}
