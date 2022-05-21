package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FSmain{
	
	public static void main(String[] args) {
		LocalDateTime localTime = LocalDateTime.now();
		
		Directory root = new Directory(null, "Root", 0, localTime);
		
		Directory applications = new Directory(root, "Desktop", 0, localTime);
		root.appendChild(applications);
		File a = new File(applications, "a", 1, localTime);
		applications.appendChild(a);
		
		Directory home = new Directory (root, "Home", 0, localTime);
		root.appendChild(home);
		File b = new File(home, "b", 2, localTime);
		home.appendChild(b);
		
		
		ArrayList<Thread> threads = new ArrayList<>();
		
		
		Runnable runn = () -> {
			System.out.println("Directory Names are :" + root.getName()+','+applications.getName()+','+home.getName());
			
			
			System.out.println("File Names are:" + a.getName() + ',' + b.getName());
			
			System.out.println("Total Children of applications: " + applications.countChildren());
			
			
		};
		
		for(int i = 0; i <= 3; i++) {
			Thread t = new Thread(runn);
			threads.add(t);
			t.start();
		}
		
		for(Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
