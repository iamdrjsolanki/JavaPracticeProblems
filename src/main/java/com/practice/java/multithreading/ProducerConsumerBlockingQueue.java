package com.practice.java.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<Double> que = new ArrayBlockingQueue<Double>(2);
		
		ProducerBQ p = new ProducerBQ(que);
		Thread p1 = new Thread(p);
		
		ConsumerBQ c1 = new ConsumerBQ(que);
		ConsumerBQ c2 = new ConsumerBQ(que);
		ConsumerBQ c3 = new ConsumerBQ(que);
		ConsumerBQ c4 = new ConsumerBQ(que);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		
		p1.start();
		t1.start(); t2.start(); t3.start(); t4.start();
		
	}

}

class ProducerBQ implements Runnable {
	BlockingQueue<Double> que;
	public ProducerBQ(BlockingQueue<Double> que) {
		this.que = que;
	}
	@Override
	public void run() {
		//synchronized (que) {
			while(true) {
				try {
					que.put(Math.random() * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			System.out.println("New Queue after producing: ");
//			System.out.println(que.toString());	
		//}
	}
}

class ConsumerBQ implements Runnable {
	BlockingQueue<Double> que;
	public ConsumerBQ(BlockingQueue<Double> que) {
		this.que = que;
	}
	@Override
	public void run() {
		System.out.println("Attempting to get the lock to consume.");
		synchronized (que) {
			System.out.println("Trying to consume in 3 seconds");
			try {
				Thread.sleep(3000);
				System.out.println("Consumed "+ que.take() + " from the queue by thread " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
