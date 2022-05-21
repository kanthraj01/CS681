package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable{
    private ThreadSafeBankAccount2 account = null;
	
	private AtomicBoolean done = new AtomicBoolean(false);
	
	public DepositRunnable(ThreadSafeBankAccount2 account) {
		this.account = account;
	}
	
	public void setDone() {
		this.done.set(true);
	}
	
	
	public void run(){
		
		while(true) {
			
			if(done.get()) {
				break;
			}
			account.deposit(150);
			
			try{
				Thread.sleep(2000);
			}catch(InterruptedException exception){}
		}

	}
}