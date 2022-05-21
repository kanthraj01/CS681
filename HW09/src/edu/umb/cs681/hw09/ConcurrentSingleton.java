package edu.umb.cs681.hw09;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton {
	private ConcurrentSingleton(){};
	private static AtomicReference<ConcurrentSingleton> instance = new AtomicReference<>();
	
	public static AtomicReference<ConcurrentSingleton> getInstance(){
		ConcurrentSingleton cs = instance.get();
		
		if(instance.compareAndSet(null, cs)){ 
			cs = new ConcurrentSingleton();
			instance.set(cs);
		}
		
		return instance;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			
			new Thread( 
					()->{System.out.println(ConcurrentSingleton.getInstance());}).start();
			
		}
		

	}

}
