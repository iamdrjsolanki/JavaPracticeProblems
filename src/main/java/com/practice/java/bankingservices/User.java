package com.practice.java.bankingservices;

import java.util.List;

public class User implements Runnable {
	
	private int userId;
	private String userName;
	private List<Transactions> transactions;
	private BankingServices service;
	
	public User(int userId, String userName, List<Transactions> transactions, BankingServices service) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.transactions = transactions;
		this.service = service;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public void run() {
		System.out.println("Calling Thread: " + Thread.currentThread().getName());
		for(Transactions transaction : this.transactions) {
			System.out.println("Transacting: "+transaction.toString());
			this.service.transfer(transaction.getFrom(), transaction.getTo(), transaction.getAmount());
		}
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", transactions=" + transactions + ", service="
				+ service + "]";
	}

}
