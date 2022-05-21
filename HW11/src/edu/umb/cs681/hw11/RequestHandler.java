package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

    private boolean isDone = false;
    private static ArrayList<Path> files = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    
	public void setDone(){
		lock.lock();
		try {
			isDone = true;
		}
		finally {
			lock.unlock();
		}
	}
	

	public void run() {
		AccessCounter counter = AccessCounter.getInstance();
		
		while(true) {
			
			if(isDone) { 
				
				System.out.println("count - a.html : " + counter.getCount(Paths.get("a.html")));
				System.out.println("count - b.html : " + counter.getCount(Paths.get("b.html")));
				System.out.println("count - c.html : " + counter.getCount(Paths.get("c.html")));
				
				break;
			}
			
			int random = (int) (Math.random() * 2);
			Path path = files.get(random);
			
			counter.increment(path);
			counter.getCount(path);		
			
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				
			}
			
		}

	}
	public static void main(String[] args){
			
			ArrayList<Thread> threads = new ArrayList<>();
			
			files.add(Paths.get("a.html"));
			files.add(Paths.get("b.html"));
			files.add(Paths.get("c.html"));
			
			RequestHandler request = new RequestHandler();
			
			for(int i = 0; i <= 11; i++) {
				Thread t = new Thread(request);
				threads.add(t);
				t.start();
			}
			
			for(Thread t : threads) {
				
				try {
				t.interrupt();
				request.setDone();
				t.join();
			
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
	
			
		}


}
