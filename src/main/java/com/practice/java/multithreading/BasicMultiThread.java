package com.practice.java.multithreading;

import java.util.concurrent.CountDownLatch;

public class BasicMultiThread {
	
	Object obj = new Object();
	
	static CountDownLatch latch = new CountDownLatch(4);

	public static void main(String[] args) throws InterruptedException {
		
		BasicMultiThread bmt = new BasicMultiThread();
		
		ThreadTask tt1 = bmt.new ThreadTask(1);
		ThreadTask tt2 = bmt.new ThreadTask(2);
		ThreadTask tt3 = bmt.new ThreadTask(3);
		ThreadTask tt4 = bmt.new ThreadTask(4);
		
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);
		Thread t3 = new Thread(tt3);
		Thread t4 = new Thread(tt4); 
		
		t1.start(); t2.start(); t3.start(); t4.start();
		//Thread.sleep(15000);
		BasicMultiThread.latch.await();
		System.out.println(Employee.count);
	}
	
	public class ThreadTask implements Runnable {
		private int pos;
		
		ThreadTask(int pos) {
			this.pos = pos;
		}

		@Override
		public void run() {
			synchronized (obj) {
				System.out.println("Current Thread: " + Thread.currentThread().getName());
				if(pos % 2 == 0) {
					Employee e = new Employee();
					e.setName("ABC"+pos);
					try {
						Thread.sleep(3000);
						BasicMultiThread.latch.countDown();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(e.toString());
				} else {
					Employee e = new Employee();
					e.setName("DEF"+pos);
					try {
						Thread.sleep(3000);
						BasicMultiThread.latch.countDown();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(e.toString());
				}
			}
		}
		
	}

}

class Employee {
	public static int count = 0;
	private String name;
	
	{
		count+=1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
}