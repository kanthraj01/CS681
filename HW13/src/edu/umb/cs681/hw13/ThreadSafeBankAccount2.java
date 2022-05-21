package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	Condition sufficientFundsCondition = lock.newCondition();
	Condition belowUpperLimitFundsCondition = lock.newCondition();


	public void withdraw(double amount){
		lock.lock();
		try{

			System.out.print("Current balance (w): " + balance);
			while(balance <= 0) {
				try {
					sufficientFundsCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}
			
			balance = balance - amount;
			belowUpperLimitFundsCondition.signalAll();
		}finally{
			lock.unlock();
		}
	}
	
	public void deposit(double amount){
		lock.lock();
		try{
			System.out.println("Current balance (d): " + balance);
			
			while(balance >= 400) {
				
				try {
					System.out.println(Thread.currentThread().toString() + " Balance is over 400");
					belowUpperLimitFundsCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}
			
			balance = balance + amount;
			System.out.println("New balance (d): " + balance);
			sufficientFundsCondition.signalAll();
		}finally{
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args){
		
		
		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();	
		
		
        WithdrawRunnable withdrawRunnable = new WithdrawRunnable(bankAccount);
        DepositRunnable depositRunnable = new DepositRunnable(bankAccount);
		
		Thread d1 = new Thread(depositRunnable);
		Thread d2 = new Thread(depositRunnable);
		Thread d3 = new Thread(depositRunnable);
		Thread d4 = new Thread(depositRunnable);
		Thread d5 = new Thread(depositRunnable);
		Thread w1 = new Thread(withdrawRunnable);
		Thread w2 = new Thread(withdrawRunnable);
		Thread w3 = new Thread(withdrawRunnable);
		Thread w4 = new Thread(withdrawRunnable);
		Thread w5 = new Thread(withdrawRunnable);
		
		d1.start();
		w1.start();
		d2.start();
		w2.start();
		d3.start();
		w3.start();
		d4.start();
		w4.start();
		d5.start();
		w5.start();
		
		withdrawRunnable.setDone();
		depositRunnable.setDone();
		
		d1.interrupt();
		w1.interrupt();
		d2.interrupt();
		w2.interrupt();
		d3.interrupt();
		w3.interrupt();
		d4.interrupt();
		w4.interrupt();
		d5.interrupt();
		w5.interrupt();
		
		try {
			d1.join();
			w1.join();
			d2.join();
			w2.join();
			d3.join();
			w3.join();
			d4.join();
			w4.join();
			d5.join();
			w5.join();
		}catch(InterruptedException e) {
			return;
		}
		
		
		
	}
}
