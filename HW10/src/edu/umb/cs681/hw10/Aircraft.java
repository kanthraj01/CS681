package edu.umb.cs681.hw10;

import java.util.concurrent.atomic.AtomicReference;

public class Aircraft {

	private AtomicReference<Position> position = new AtomicReference<>(); 
	public Aircraft(Position p){ 
		
		position = new AtomicReference<>(p); 
		
	} 

	public void setPosition(Position pos){

		position.set(pos);; 

	}
		

	public Position getPosition(){ 
		
		return position.get();
	
	}

}
