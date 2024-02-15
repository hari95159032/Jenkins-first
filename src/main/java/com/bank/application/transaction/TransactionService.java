package com.bank.application.transaction;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.application.user.User;
import com.bank.application.user.UserRepository;
import com.bank.application.user.UserService;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	User user;
	
	String beginTransaction(Transaction transaction, String type, Integer userId) {
		
		if(type.equalsIgnoreCase("deposit")){
			return depositeAmount(transaction, userId);
		}else if(type.equalsIgnoreCase("withdraw")) {
			return withdrawAmount(transaction, userId);
		}else if(type.equalsIgnoreCase("Transfer")) {
			return moneyTransfer(transaction, userId);
		}else {
			return " Please enter correct required type to proceed transaction";
		}
	}
	
	
	String depositeAmount(Transaction transaction, Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		Double currentBalance = user.get().getBalance()+transaction.getTrAmount();
		user.get().setBalance(currentBalance);
		userRepo.save(user.get());
		repo.save(transaction);
		return "Amount deposited successfully";
	}
	
	String withdrawAmount(Transaction transaction,Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		if(user.get().getBalance()<transaction.getTrAmount()) {
			return "Your balance is low";
		}else {
			Double currentBalance = user.get().getBalance()-transaction.getTrAmount();
			user.get().setBalance(currentBalance);
			userRepo.save(user.get());
			repo.save(transaction);
			return "Amount withdrawn successfully";
		}
	}
	
	String moneyTransfer(Transaction transaction, Integer userId) {
		String result = withdrawAmount(transaction, userId);
		if(result.equalsIgnoreCase("Amount withdrawn successfully")) {
			depositeAmount(transaction, transaction.getTrParty());
			return "Money transfered successfully";
		}else {
			return result;
		}
	}
	
	
	
	
}
