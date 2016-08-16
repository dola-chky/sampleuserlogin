package com.dola.userlogin.service;

import java.util.List;

import com.dola.userlogin.model.User;

public interface UserService {
	 	User findById(long id);
     
	    User findByName(String name);
	     
	    void createUser(User user);
	     
	 
	    List<User> findAllUsers(); 
	    
	     
	    public boolean isUserExist(User user);
	    
	    public boolean isUserValid(User user);
}
