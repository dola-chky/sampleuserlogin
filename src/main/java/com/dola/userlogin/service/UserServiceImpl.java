package com.dola.userlogin.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.dola.userlogin.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	private static final AtomicLong counter = new AtomicLong();
    
    private static List<User> users;
     
    static{
        users= populateDummyUsers();
    }
 
    public List<User> findAllUsers() {
        return users;
    }
     
    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
     
    public User findByName(String name) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getUsername())!=null;
    }
    
    public boolean isUserValid(User user) {
        User user1 = this.findByName(user.getUsername());
        if(user.getPassword().equals(user1.getPassword())){
        	return true;
        }
        return false;
    }
     
    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam", "1234", "sam@abc.com", "Sam Morrison", "19/01/1980", "nerd"));
        users.add(new User(counter.incrementAndGet(),"Tomy", "4321", "tomy@abc.com", "Tomy Brian", "14/04/1990", "handsome"));
        users.add(new User(counter.incrementAndGet(),"Kelly", "1432", "kelly@abc.com", "Kelly zones", "18/03/1985", "cute"));
        return users;
    }

	public void createUser(User user) {
		  user.setId(counter.incrementAndGet());
	      users.add(user);
		
	}
}
