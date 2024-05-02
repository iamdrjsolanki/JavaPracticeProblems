package com.practice.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*A user requesting 5 servers concurrently 
 * to download an image
 * Using executor service*/

public class ConcurrentServerCalls {

	public static void main(String[] args) {
		
		List<String> servers = new ArrayList<String>();
		servers.add("Server A"); servers.add("Server B"); servers.add("Server C");
		servers.add("Server D"); servers.add("Server E");
		
		List<String> users = new ArrayList<String>();
		users.add("User 1"); users.add("User 2"); users.add("User 3");
		
		RequestServer serve = new RequestServer(servers);
		
		for(String user : users) {
			System.out.println("Requesting for user: " + user);
			serve.requestingServersConcurrently(user);
		}
		
		//This will shutdown the executor service as soon as all the active threads have completed their task
		//CountdownLatch can also be used to keep the main thread on wait until all the threads completed the tasks.
		System.out.println("Shuting down after completion");
		serve.shutdownService();		
	}

}

class RequestServer {
	List<String> servers;
	ExecutorService exec;
	
	public RequestServer(List<String> servers) {
		this.servers = servers;
		exec = Executors.newFixedThreadPool(this.servers.size());
	}
	
	void requestingServersConcurrently(String user) {
		try {
			exec.submit(() -> {
				//synchronized (servers) {
					int i = 0;
					for(String server : this.servers) {
						i+=1;
						System.out.println("User " + user + " calling " + server + " to download the image....");
						try {
							Thread.sleep(2000);
							System.out.println("Starting to dowload image " + i + " from server " + server);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				//}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void shutdownService() {
		exec.shutdown();
	}
}
