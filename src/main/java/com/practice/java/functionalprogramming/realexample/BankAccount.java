package com.practice.java.functionalprogramming.realexample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class BankAccount {

    private int id;
    private double balance;
    private String accountName;
    final Lock lock = new ReentrantLock();

    BiFunction<Double, Double, Double> withdrawFunction = (a, b) -> a - b;
    BiFunction<Double, Double, Double> depositFunction = (a, b) -> a + b;

    public BankAccount(int id, double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public boolean withdraw(double amount) throws InterruptedException {
        if(this.lock.tryLock()) {
            Thread.sleep(1000);
            if(checkBalance(amount)) {
                this.balance = withdrawFunction.apply(this.balance, amount);
                this.lock.unlock();
                return true;
            } else {
                this.lock.unlock();
                return false;
            }
        }
        return false;
    }

    public boolean deposit(double amount) throws InterruptedException {
        if(this.lock.tryLock()) {
            Thread.sleep(1000);
            if(checkBalance(amount)) {
                this.balance = depositFunction.apply(this.balance, amount);
                this.lock.unlock();
                return true;
            } else {
                this.lock.unlock();
                return false;
            }
        }
        return false;
    }

    public boolean checkBalance(double amount) {
        return this.balance >= amount;
    }

    public boolean transfer(BankAccount to, double amount) throws InterruptedException {
        if(withdraw(amount)) {
            System.out.println("Withdrawing amount " + amount + " from account " + this.accountName);
            if(to.deposit(amount)) {
                System.out.println("Depositing amount " + amount + " to account " + to.getAccountName());
                return true;
            } else {
                System.out.println("Failed to acquire both locks revert the transaction of amount " + amount +
                            " to account " + this.accountName);
                while(!deposit(amount))
                    continue;
            }
        }
        return false;
    }

}
