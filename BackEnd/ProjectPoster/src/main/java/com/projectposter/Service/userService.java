package com.projectposter.Service;

import java.security.Principal;

import com.projectposter.DAO.User;

public interface userService {

	String register(User user);
    String user(Principal principal);
}
