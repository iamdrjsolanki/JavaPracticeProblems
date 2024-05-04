package com.practice.java.functionalprogramming.realexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {

    public static void main(String[] args) {

        AccountFactory accountFactory = BankAccount::new;
        BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "StudentA");
        BankAccount universityBankAccount = accountFactory.getBankAccount(2, 500000, "University");

        BiPredicate<Double, Double> checkIfBalanceGreaterThanAmount = (bal, amt) -> bal > amt;

        BiConsumer<String, Double> printBalance = (x, y) -> System.out.println(x + y);

        BiConsumer<BankAccount, BankAccount> printFinalMsg = (x, y) -> System.out.println("Ending balance of student account" +
                ": " + studentBankAccount.getBalance() +  " University Account: " + universityBankAccount.getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says executing transfer");
            try {
                double amount = 10000;
                while(!studentBankAccount.transfer(universityBankAccount, amount)) {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    if(studentBankAccount.checkBalance(amount)) {
                        continue;
                    } else {
                        printBalance.accept(Thread.currentThread().getName() + " says Insufficient Balance to " +
                                "transfer amount ", amount);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printBalance.accept(Thread.currentThread().getName() + " says transfer is successful in account ",
                    universityBankAccount.getBalance());
        });

        for(int i=0; i<10; i++) {
            executorService.submit(t1);
        }

        executorService.shutdown();

        try {
            while(!executorService.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Still waiting for termination");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        printFinalMsg.accept(studentBankAccount, universityBankAccount);

    }

}
