package com.dell.simplilearn.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dell.simplilearn.model.User;

@Component
public class UserService {

	private static int usersCount = 5;
	
	private static List<User> users = new ArrayList<User>();
	
	static  {
		users.add(new User(1, "John", new Date()));
		
		users.add(new User(2, "Bob", new Date()));
		
		users.add(new User(3, "Alice", new Date()));
		
		users.add(new User(4, "Robert", new Date()));
		
		users.add(new User(5, "Jack", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		
		users.add(user);
		
		return user;
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
}
