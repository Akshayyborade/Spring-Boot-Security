package com.springSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.model.User;
import com.springSecurity.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServices userServices;
    @GetMapping
	public List<User> gerUsers(){
		return userServices.getUsers();
	}
    @GetMapping("user")
	public User getUser(@RequestBody String email) {
		return userServices.getUser(email);
	}
    @PostMapping
    public String setUser(@RequestBody User user) {
    	userServices.setUser(user);
    	return "user added sucessfully";
    }
	

}
