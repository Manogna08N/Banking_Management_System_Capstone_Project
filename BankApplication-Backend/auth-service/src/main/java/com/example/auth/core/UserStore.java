package com.example.auth.core;


import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class UserStore {
	private final Map<String, User> users = new HashMap<>();

	  public UserStore() {
	    
	    users.put("admin@bank.test", new User("admin@bank.test", "admin123", "ADMIN"));
	    
	  }

	  public Optional<User> findByEmail(String email) {
	    return Optional.ofNullable(users.get(email));
	  }

	  public boolean exists(String email) {
	    return users.containsKey(email);
	  }

	  public User addUser(String email, String password) {
	    User u = new User(email, password, "USER");
	    users.put(email, u);
	    return u;
	  }

}
