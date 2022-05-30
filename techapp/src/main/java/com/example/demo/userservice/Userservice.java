package com.example.demo.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.User;
import com.example.demo.repository.userreposirtory;




@Service
@Transactional
public class Userservice {
	@Autowired
userreposirtory userrep;
	public void saveuser(User user) {
		// TODO Auto-generated method stub
		userrep.save(user);
		
	}
	public List<User> showusers(){
		List<User> users = new ArrayList<User>();
		for(User user : userrep.findAll()) {
			users.add(user);
		}
		
		return users;
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		userrep.deleteById(id);
		
	}
	
	public User update(int id) {
		// TODO Auto-generated method stub
		return userrep.findById(id).orElse(null);
	}
	public User findByUsernamendPassword(String username,String password)
	{
		return userrep.findByUsernameAndPassword(username,password);
	}

}
