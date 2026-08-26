package org.learning.Multithreading;

public class part1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started...");
        // Thread.sleep(5000); throws InterruptedException as system is sleeping
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        //Thread priority ranges from 1 to 10, with 5 as the default, but priority does not guarantee execution order.
        thread.sleep(5000);
        thread.setName("Telusko"); //we can change name and priority of threads in java as required
        thread.setPriority(4);
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println("Application Terminated...");
    }
}
