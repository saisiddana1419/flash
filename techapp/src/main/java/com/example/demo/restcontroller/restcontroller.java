package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.User;
import com.example.demo.userservice.Userservice;

@org.springframework.web.bind.annotation.RestController
public class restcontroller {
	@Autowired
Userservice userser;
	@RequestMapping("/")
	public String home()
	{
		return "welcome";
	}
	@RequestMapping("/usersave")
	public String saveuser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
	{
		User user=new User(username,firstname,lastname,age,password);
		userser.saveuser(user);
		return "user saved";
	}
	
	
}
