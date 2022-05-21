package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
	
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	protected Directory parent;
	protected ReentrantLock lock = new ReentrantLock();
	
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
		
		
	}
	
	public Directory getParent() {
		
		return this.parent;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	
	public void setParent(Directory newParent) {
		this.parent = newParent;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setCreationTime(LocalDateTime newCreationTime) {
		this.creationTime = newCreationTime;
	}
	
	public abstract boolean isDirectory();


}
