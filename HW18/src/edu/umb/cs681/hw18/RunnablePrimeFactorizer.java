package edu.umb.cs681.hw18;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {
	
	public RunnablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend);
		if (from >= 2 && to >= from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException(
				"error");
		}
	}
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}

	public void generatePrimeFactors() {
		long divisor = from;
	    while( dividend != 1 && divisor <= to ){
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    }
		}
	}
	
	public void run() {
		generatePrimeFactors();
	}

	public static void main(String[] args) {
		
		LinkedList<RunnablePrimeFactorizer> runnables = new LinkedList<RunnablePrimeFactorizer>();


		runnables.add( new RunnablePrimeFactorizer(808, 2, (long)Math.sqrt(808)/2 ));
		runnables.add( new RunnablePrimeFactorizer(808, 1+(long)Math.sqrt(808)/2, (long)Math.sqrt(808) ));
		
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.execute(runnables.get(0));
		
		executor.execute(runnables.get(1));
		
		executor.shutdown();
		

		LinkedList<Long> factors2 = new LinkedList<Long>();
		runnables.forEach( (factorizer) -> factors2.addAll(factorizer.getPrimeFactors()) );
		System.out.println("Final result for 808: " + factors2);
		
		

		
		
	}
}
