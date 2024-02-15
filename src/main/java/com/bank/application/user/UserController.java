package com.bank.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/users/signIn/{email}/{password}")
	String signIn(@PathVariable String email,@PathVariable String password) {
		return service.signIn(email, password);
	}

	@PostMapping("/users")
	String addNewUser(@RequestBody User user) {
		return service.addNewUser(user);
	}
	
	@GetMapping("/users")
	Iterable<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@PutMapping("/users")
	User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
}
