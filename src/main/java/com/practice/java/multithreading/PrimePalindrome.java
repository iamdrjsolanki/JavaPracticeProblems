package com.practice.java.multithreading;

public class PrimePalindrome {

	public static void main(String[] args) {
		//PrimePalindrome obj = new PrimePalindrome();
		
		PrimeNumber prime = new PrimeNumber();
		Thread t1 = new Thread(prime);
		t1.start();
		
		PalindromeNumber palin = new PalindromeNumber();
		Thread t2 = new Thread(palin);
		t2.start();
		
		//to make it sequentially
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class PrimeNumber implements Runnable {
	public void run() {
		for(int i=1; i<=1000; i++) {
			boolean flag = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) 
				System.out.println("The number " + i + " is a prime number.");
		}
	}
}

class PalindromeNumber implements Runnable {
	public void run() {
		for(int i=1; i<=1000; i++) {
			if(i >= 10) {
				StringBuilder n = new StringBuilder().append(String.valueOf(i));
				if(n.toString().equals(n.reverse().toString())) 
					System.out.println("The number " + n.reverse().toString() + " is palindrome");
			}
		}
	}
}
