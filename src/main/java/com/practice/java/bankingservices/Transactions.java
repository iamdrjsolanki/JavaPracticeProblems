package com.practice.java.bankingservices;

public class Transactions {
	
	private Account to;
	private Account from;
	private long amount;
	
	public Transactions(Account from, Account to, long amount) {
		super();
		this.to = to;
		this.from = from;
		this.amount = amount;
	}
	
	public Account getTo() {
		return to;
	}
	public void setTo(Account to) {
		this.to = to;
	}
	public Account getFrom() {
		return from;
	}
	public void setFrom(Account from) {
		this.from = from;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [to=" + to + ", from=" + from + ", amount=" + amount + "]";
	}

}
