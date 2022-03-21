package edu.umb.cs681.hw07;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread() ;
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        Thread t4 = new Thread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}