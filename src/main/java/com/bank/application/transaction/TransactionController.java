package com.bank.application.transaction;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.application.user.User;

@RestController
@RequestMapping("api/v1")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	
	@PostMapping("transaction/{type}/{userId}")
	String beginTransaction(@RequestBody Transaction transaction,@PathVariable String type,@PathVariable Integer userId) {
		
		transaction.setUser(new User(userId));
		transaction.setTrType(type);
		transaction.setTrDate(LocalDateTime.now());
		return service.beginTransaction(transaction, type, userId);
	}

}
