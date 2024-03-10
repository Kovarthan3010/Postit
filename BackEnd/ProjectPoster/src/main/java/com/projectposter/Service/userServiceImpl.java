package com.projectposter.Service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectposter.DAO.User;
import com.projectposter.DAO.userRepo;

@Service
public class userServiceImpl implements userService{

	
	
	@Autowired
	userRepo userrepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	
	@Override
    public String register(User user) {
	user.setUserPassword(encoder.encode(user.getUserPassword()));
	userrepo.save(user);
    return "User Added Successfully";
	}



	@Override
	public String user(Principal principal) {
		// TODO Auto-generated method stub
		return principal.getName();
	}

}
