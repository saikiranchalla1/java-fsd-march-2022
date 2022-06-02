package com.dell.simplilearn.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dell.simplilearn.model.User;
import com.dell.simplilearn.repository.UserRepository;

@Component
public class UserService {

	private static int usersCount = 5;
	
	private static List<User> users = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
	
	static  {
		users.add(new User(1, "John", new Date()));
		
		users.add(new User(2, "Bob", new Date()));
		
		users.add(new User(3, "Alice", new Date()));
		
		users.add(new User(4, "Robert", new Date()));
		
		users.add(new User(5, "Jack", new Date()));
	}
	
	public List<User> findAll() {
//		return users;
		return userRepository.findAll();
	}
	
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public void deleteById(int id) {
//		Iterator<User> iterator = users.iterator();
//		
//		while (iterator.hasNext()) {
//			User user = iterator.next();
//			if (user.getId() == id) {
//				iterator.remove();
//				return user;
//			}
//		}
//		
//		return null;
		userRepository.deleteById(id);
		
	}
}
