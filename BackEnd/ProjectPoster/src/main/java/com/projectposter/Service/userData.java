package com.projectposter.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectposter.DAO.User;
import com.projectposter.DAO.userRepo;

@Service
public class userData implements UserDetailsService {

	@Autowired
	private userRepo UserRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=UserRepo.findByuserName(username);
		if(user.isPresent())
		{
		return new UserToUserDetailConverter(user.get());
		}
		else
		{
		throw new UsernameNotFoundException(""+username+" not registered. Please register and login");
		}
	}

}
