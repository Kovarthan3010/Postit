package com.projectposter.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectposter.DAO.User;
import com.projectposter.Service.userService;

@RestController
public class UserController {
	
	@Autowired
	private userService userservice;
	
	@PostMapping(value="/register",consumes="application/json")
	public String register(@RequestBody User user)
	{
		String result=userservice.register(user);
		return result;
	}
}