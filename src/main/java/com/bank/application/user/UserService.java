package com.bank.application.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	String signIn(String email, String password) {
		Optional<User> existUser = repo.findByEmail(email);
		if(existUser.isPresent() && existUser.get().getPassword().equals(password)) {
			return "User signin successfully";
		}else {
			return "User not exist";
		}
	}
	
	String addNewUser(User user) {
		Optional<User> existEmail = repo.findByEmail(user.getEmail());
		if(existEmail.isPresent()) {
			return "User already registered";
		}else {
			repo.save(user);
			return "New User details added"; 
		}
	}
	
	Iterable<User> getAllUsers() {
		return repo.findAll();
	}
	
	User updateUser(User user) {
		return repo.save(user);
	}

}
