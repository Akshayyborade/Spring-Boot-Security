package com.springSecurity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springSecurity.model.User;
@Service
public class UserServices {
	List<User> users=new ArrayList<>();
	public UserServices() {
		
		users.add(new User(1,"Akshay", "boradeakshay11@gmail.com", "12345"));
		users.add(new User(2, "Kiran", "kiran@gmail.com", "789456"));
	}
	public List<User> getUsers(){
		return users;
	}
	public User getUser(String email) {
		return users.stream().filter(user-> email.equals(user.getEmail())).findFirst().orElse(null);
		
	}
	
	public void setUser(User user) {
		users.add(user);
	}

}
