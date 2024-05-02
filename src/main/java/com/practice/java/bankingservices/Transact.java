package com.practice.java.bankingservices;

import java.util.ArrayList;
import java.util.List;

public class Transact {
	
	static List<Account> accounts = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		
		BankingServices service = new BankingServices();
		
		Account a = new Account("a", 1000);
		Account b = new Account("b", 1000);
		Account c = new Account("c", 1000);
		Account d = new Account("d", 1000);
		Account e = new Account("e", 1000);
		Account f = new Account("f", 1000);
		
		accounts.add(a); accounts.add(b); accounts.add(c); accounts.add(d); accounts.add(e); accounts.add(f);
		
		List<Transactions> list1 = new ArrayList<>();
		list1.add(new Transactions(a, b, 100));
		list1.add(new Transactions(b, c, 100));
		User user1 = new User(1, "User1", list1, service);
		
		List<Transactions> list2 = new ArrayList<>();
		list2.add(new Transactions(a, b, 100));
		list2.add(new Transactions(b, a, 100));
		User user2 = new User(2, "User2", list2, service);
		
		List<Transactions> list3 = new ArrayList<>();
		list3.add(new Transactions(d, e, 100));
		list3.add(new Transactions(e, f, 100));
		list3.add(new Transactions(f, a, 100));
		User user3 = new User(3, "User3", list3, service);
		
		System.out.println("Sum of balances of all accounts at init: "+ getSumOfBalancesOfAllAccounts());
		
		Thread t1 = new Thread(user1);
		Thread t2 = new Thread(user2);
		Thread t3 = new Thread(user3);
		
		t1.start();
		t2.start(); 
		t3.start();		
	}
	
	public static long getSumOfBalancesOfAllAccounts() {
		long sum = 0l;
		for(Account account : Transact.accounts) {
			sum += account.getBalance();
		}
		return sum;
	}

}
