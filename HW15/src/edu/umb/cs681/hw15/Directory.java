package edu.umb.cs681.hw15;


import java.time.LocalDateTime;
import java.util.LinkedList;
public class Directory extends FSElement {
	
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	
	public Directory (Directory parent, String name, int size, LocalDateTime creationTime) {
		
		super(parent, name, size, creationTime);
	}
	
	public LinkedList<FSElement> getChildren() {
		lock.lock();
		try {
			return this.children;
		}finally {
			lock.unlock();
		}
	}
	
	public void appendChild(FSElement child) {
		lock.lock();
		try {
			this.children.add(child);
			child.setParent(this);
		}finally {
			lock.unlock();
		}
		
		
	}
	
	public int countChildren() {
		lock.lock();
		try {
			return this.children.size();
		}finally {
			lock.unlock();
		}
		
		
	}
	
	public LinkedList<Directory> getSubDirectories(){
		lock.lock();
		try {
			LinkedList<Directory> subDirectories = new LinkedList<Directory>();
			
			for(FSElement f : this.children) {
			
				if(f instanceof Directory) {
					
					Directory directory = (Directory)f;
					subDirectories.add(directory);
					
				}
			}
			
			return subDirectories;
		}finally {
			lock.unlock();
		}
		
		
	}
	
	public LinkedList<File> getFiles(){
		lock.lock();
		try {
			LinkedList<File> files = new LinkedList<File>();
			
			for(FSElement f : this.children) {
			
				if(f instanceof File) {
					
					File file = (File)f;
					files.add(file);
					
				}
			}
			
			return files;
		} finally {
			lock.unlock();
		}
		
		
	}
	
	
	public int getTotalSize() {
		lock.lock();
		try {
			int totalSize = 0;
			
			for(FSElement f : this.children) {
				
				totalSize = totalSize + f.getSize(); 
			
			}
			
			for(Directory d : this.getSubDirectories()) {
				totalSize = totalSize + d.getTotalSize();
			}
			
			return totalSize;
		}finally {
			lock.unlock();
		}

		
	}

	public boolean isDirectory() {
        lock.lock();
        try {
            return true;
        } finally {
            lock.unlock();
        }

    }

}
