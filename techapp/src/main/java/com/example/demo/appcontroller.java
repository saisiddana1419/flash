package com.example.demo;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modal.User;
import com.example.demo.userservice.Userservice;

@Controller
public class appcontroller {
	@Autowired
  private Userservice userser;
  @RequestMapping("/welcome")
  public String home1(HttpServletRequest request)
  
  {
	  request.setAttribute("mode", "mode_home");
	  return "welcome";
  }
  @RequestMapping("/register")
  public String home2(HttpServletRequest request)
  
  {
	  request.setAttribute("mode", "mode_register");
	  return "welcome";
  }
  @PostMapping("/save-user")
  public String home3(@ModelAttribute User user,BindingResult bind,HttpServletRequest request)
  
  {userser.saveuser(user);
	  request.setAttribute("mode", "mode_home");
	  return "welcome";
  }
  @GetMapping("/show-user")
	public String showAllUsers(HttpServletRequest request) {
	  request.setAttribute("users",userser.showusers());
		request.setAttribute("mode", "show-users");
		return "welcome";
	}
  @RequestMapping("/delete-user")
	public String showAllUsers1(HttpServletRequest request,@RequestParam int id) {
	  userser.delete(id);
	  request.setAttribute("users",userser.showusers());
		request.setAttribute("mode", "show-users");
		return "welcome";
	}
  @RequestMapping("/edit-user")
	public String showAllUsers2(HttpServletRequest request,@RequestParam int id) {
	  
	  request.setAttribute("user",userser.update(id));
		request.setAttribute("mode", "mode_update");
		return "welcome";
	}
  @RequestMapping("/login")
  public String home3(HttpServletRequest request)
  
  {
	  request.setAttribute("mode", "login-user");
	  return "welcome";
  }
  @RequestMapping("/loginuser")
  public String h3(@ModelAttribute User user,HttpServletRequest request)
  {
	  if(userser.findByUsernamendPassword(user.getUsername(), user.getPassword())!=null) {
		  System.out.println("hi");
			return "home";
		}
	  else
	  {
		  request.setAttribute("error", "Invalid,Username Or Password");
		  request.setAttribute("mode", "login-user");
	  }
	 return "welcome";
  }
	
}
