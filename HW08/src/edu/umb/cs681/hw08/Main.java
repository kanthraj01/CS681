package edu.umb.cs681.hw08;

public class Main {
    public static void main(String[] args) {
        RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread = new Thread(gen);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.setDone();
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        gen.getPrimeFactors().forEach( (Long primeFactor)-> System.out.print(primeFactor + ", ") );
        System.out.println("Total number of factors " + gen.getPrimeFactors().size() + "\n");
    }
}