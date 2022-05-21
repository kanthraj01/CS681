package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	private AccessCounter() {};
	private static AccessCounter instance = null;
	
	
	private  ReentrantLock Lock = new ReentrantLock();
	private static ReentrantLock staticLock = new ReentrantLock();	
	
	private HashMap<Path, Integer> hmap = new HashMap<Path, Integer>();
	
	
	public static AccessCounter getInstance(){
		staticLock.lock();
		try{
			if(instance==null){ instance = new AccessCounter(); }
			return instance;
		}finally{
			staticLock.unlock();
		}
	}
	
	public void increment(Path path) {
		Lock.lock();
		try {
			if(hmap.get(path) != null) {
				
				hmap.put(path, hmap.get(path) + 1);
				
			}else {
				hmap.put(path,  1);
			}
			
		}finally {
			Lock.unlock();
		}
	}
	
	public int getCount(Path path) {
		Lock.lock();
		try {
			if(hmap.get(path) != null) {
				
				return hmap.get(path);
				
			}else {
				return 0;
			}
			
		}finally {
			Lock.unlock();
		}
		
		
	}

}
