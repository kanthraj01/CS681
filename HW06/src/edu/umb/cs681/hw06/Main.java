package edu.umb.cs681.hw06;

public class Main {
    public static void main(String[] args) {
        RunnableCancellablePrimeFactorizer gen = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread = new Thread(gen);
        thread.start();
        gen.setDone();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.getPrimeFactors().forEach( (Long primeFactors)-> System.out.print(primeFactors+ ", ") );
        System.out.println("\n" + gen.getPrimeFactors().size() + " prime factors are found.");
    }
}