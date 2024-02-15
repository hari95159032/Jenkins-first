package com.bank.application.transaction;

import java.time.LocalDateTime;

import com.bank.application.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trId;
	
	private LocalDateTime trDate;
	
	private Double trAmount;
	
	private String trType;
	
	private Integer trParty;


	@ManyToOne
	private User user;



	public Transaction(LocalDateTime trDate, Double trAmount, String trType, Integer trParty, Integer userId) {
		super();
		this.trDate = trDate;
		this.trAmount = trAmount;
		this.trType = trType;
		this.trParty = trParty;
		this.user =new User(userId);
	}







	public Integer getTrId() {
		return trId;
	}







	public void setTrId(Integer trId) {
		this.trId = trId;
	}







	public LocalDateTime getTrDate() {
		return trDate;
	}







	public void setTrDate(LocalDateTime trDate) {
		this.trDate = trDate;
	}







	public Double getTrAmount() {
		return trAmount;
	}







	public void setTrAmount(Double trAmount) {
		this.trAmount = trAmount;
	}







	public String getTrType() {
		return trType;
	}







	public void setTrType(String trType) {
		this.trType = trType;
	}







	public Integer getTrParty() {
		return trParty;
	}







	public void setTrParty(Integer trParty) {
		this.trParty = trParty;
	}







	public User getUser() {
		return user;
	}







	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Transaction [trId=" + trId + ", trDate=" + trDate + ", trAmount=" + trAmount + ", trType=" + trType
				+ ", trParty=" + trParty + ", user=" + user + "]";
	}

	Transaction(){
		
	}
	

}
