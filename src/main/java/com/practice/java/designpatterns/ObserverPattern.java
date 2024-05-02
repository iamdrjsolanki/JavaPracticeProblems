package com.practice.java.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		
	}

}

class Subscriber {
	String name;
	Channel channel;
	
	public void update() {
		System.out.println("Video Uploaded");
	}
	
	public void subscribeChannel(Channel ch) {
		channel = ch;
		System.out.println("Channel Subscribed");
	}
}

class Channel {
	String title;
	List<Subscriber> subs = new ArrayList<>();
	
	public void subscribe(Subscriber sub) {
		subs.add(sub);
	}
	
	public void unsubscribe(Subscriber sub) {
		subs.remove(sub);
	}
	
	public void notifySubs() {
		for(Subscriber sub : subs) {
			sub.update();
		}
	}
	
	public void upload(String title) {
		this.title = title;
		notifySubs();
	}
}