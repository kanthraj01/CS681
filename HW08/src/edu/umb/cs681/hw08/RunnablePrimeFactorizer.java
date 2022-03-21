package edu.umb.cs681.hw08;


// Generates prime factors of a given number (dividend)
// Factorization is performed in the range of 2 and Math.sqrt(dividend)
//
// When only one thread is used for factorization, create a Runnable as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend));
// The thread performs factorization for the entire range of 2 and sqrt(dividend).
//
// When two threads are used for factorization, create two Runnables as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend)/2);
//     new RunnablePrimeFactorizer(dividend, 1+(long)Math.sqrt(dividend)/2, (long)Math.sqrt(dividend));

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {

    public RunnablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend);
        if (from >= 2 && to >= from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException(
                    "must be greater or equal to 2. check for to and from dates");
        }
    }

    protected boolean isEven(long n){
        if(n%2 == 0){ return true; }
        else{ return false; }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while( dividend != 1 && divisor <= to ){
            if( divisor > 2 && isEven(divisor)) {
                divisor++;
                continue;
            }
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
        System.out.println("number of threads: " + Thread.currentThread().getId() + " has generated " + factors);
    }
}