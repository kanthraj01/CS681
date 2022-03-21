package edu.umb.cs681.hw04;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n Using one main thread \n");
        RunnablePrimeGenerator gen = new RunnablePrimeGenerator(1L, 2_000_000L);
        Thread thread = new Thread(gen);
        long start = System.currentTimeMillis();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {}
        long end = System.currentTimeMillis();
        float time1 = (end - start) / 1000F;
        long primeNum = gen.getPrimes().size() ;
        System.out.println("\n" + " Total Prime Numbers: " + primeNum);
        System.out.println("Time taken with single thread: " + time1 + " seconds");
        System.out.println("\n-------------------------------------------------\n");

        System.out.println("\n Using Two threads and a main thread \n");
        RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1L, 1_000_000L);
        RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(1_000_000L, 2_000_000L);
        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        end = System.currentTimeMillis();
        float time2 = (end - start) / 1000F;

        primeNum = gen1.getPrimes().size() + gen2.getPrimes().size() ;
        System.out.println("\n" + " Total Prime Numbers: " + primeNum);
        System.out.println("Time taken with double thread: " + time2 + " seconds");
        System.out.println("\n-------------------------------------------------\n");


        System.out.println("\n Using four threads and a main thread \n");
        RunnablePrimeGenerator gen3 = new RunnablePrimeGenerator(1L, 5_00_000L);
        RunnablePrimeGenerator gen4 = new RunnablePrimeGenerator(5_00_000L, 1_000_000L);
        RunnablePrimeGenerator gen5 = new RunnablePrimeGenerator(1_000_000L, 1_500_000L);
        RunnablePrimeGenerator gen6 = new RunnablePrimeGenerator(1_500_000L, 2_000_000L);
        Thread t3 = new Thread(gen3);
        Thread t4 = new Thread(gen4);
        Thread t5 = new Thread(gen5);
        Thread t6 = new Thread(gen6);

        start = System.currentTimeMillis();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {}
        end = System.currentTimeMillis();
        float time3 = (end - start) / 1000F;

        primeNum = gen3.getPrimes().size() + gen4.getPrimes().size()+gen5.getPrimes().size() + gen6.getPrimes().size()  ;
        System.out.println("\n" + " Total Prime Numbers: " + primeNum);
        System.out.println("Time taken with four threads: " + time3 + " seconds");
        System.out.println("\n-------------------------------------------------\n");

    }
}