package com.practice.java.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerWaitNotify {

	public static void main(String[] args) {
		
		List<Double> queue = new ArrayList<Double>();
		Producer p1 = new Producer(queue, 2);
		
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		Consumer c4 = new Consumer(queue);
		
		Thread pT1 = new Thread(p1);
		pT1.start();
		
		Thread cT1 = new Thread(c1);
		Thread cT2 = new Thread(c2);
		Thread cT3 = new Thread(c3);
		Thread cT4 = new Thread(c4);
		cT1.start(); cT2.start(); cT3.start(); cT4.start();
		
	}

}

class Consumer implements Runnable {
	
	List<Double> que;

	public Consumer(List<Double> que) {
		super();
		this.que = que;
	}
	
	@Override
	public void run() {
		synchronized (que) {
			while(que.isEmpty()) {
				try {
					que.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Trying to consume in 3 seconds");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumed "+ que.remove(0) + " from the queue by thread " + Thread.currentThread().getName());
			que.notifyAll();
		}
	}

}

class Producer implements Runnable {
	
	int qsize;
	List<Double> que;

	public Producer(List<Double> que, int size) {
		super();
		this.que = que;
		this.qsize = size;
	}
	
	@Override
	public void run() {
		synchronized (que) {
			while(true) {
				if(que.size() == qsize) {
					try {
						que.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Double i = Math.random() * 100;
					que.add(i);
					que.notifyAll();
				}
				System.out.println("New Queue after producing: ");
				System.out.println(que.toString());
			}
		}
	}

}