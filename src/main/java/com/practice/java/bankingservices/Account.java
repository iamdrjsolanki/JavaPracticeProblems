package com.practice.java.bankingservices;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	private String accountId;
	private long balance;
	public ReentrantLock lockObject;
	
	public Account(String accountId, long balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.lockObject = new ReentrantLock();
	}
	
	public long getBalance() {
		return balance;
	}
	public String getAccountId() {
		return accountId;
	}
	
	public void deposit(long amt) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance += amt;
	}
	
	public void withdraw(long amt) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance -= amt;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", lockObject=" + lockObject + "]";
	}

}
