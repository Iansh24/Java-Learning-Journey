package org.learning.Multithreading15;

import java.util.Scanner;
//multithreading  == concurrent execution
//multithreading != parallel execution
/////////////////////////***THREADS***///////////////////////////

// creating child class object is equivalent to creating parent class object
// all properties and methods of thread class are now in alpha class
class Alpha1 extends Thread {
    @Override //run function coming from runnable to thread class
    public void run() {
        // this run method has to do the task which is present inside the banking method
        banking();
    }
    public void banking()
    {
        //activity 1
        System.out.println("Banking activity started");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user no : 4");
        int userNo =  4;
        System.out.println("Enter the Password:ansh");
        String password = "ansh";
        System.out.println("Collect Your cash!");
        System.out.println("Banking activity Terminated!");
    }
}

class Beta1 extends Thread {
    @Override
    public void run() {
        try {
            printingStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printingStars() throws InterruptedException {
        //activity 2
        System.out.println("Printing activity started...");
        for(int i=0; i<=4; i++){
            System.out.println("*");
            Thread.sleep(4000);
        }
        System.out.println("Printing activity Terminated!");
    }
}

class Gamma1 extends Thread {
    @Override
    public void run() {
        try {
            focus();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void focus() throws InterruptedException {
        //activity 3
        System.out.println("Printing Important message started...");
        for(int i=0; i<=4; i++){
            System.out.println("Don't give up!");
            Thread.sleep(4000);
        }
        System.out.println("Printing Important message Terminated!");
    }
}

/////////////////////////***RUNNABLE***///////////////////////////

class Alpha2 implements Runnable {
    @Override //run function coming from runnable to thread class
    public void run() {
        // this run method has to do the task which is present inside the banking method
        banking();
    }
    public void banking()
    {
        //activity 1
        System.out.println("Banking activity started");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user no : 4");
        int userNo =  4;
        System.out.println("Enter the Password");
        int password = sc.nextInt();
        System.out.println("Collect Your cash!");
        System.out.println("Banking activity Terminated!");
    }
}

class Beta2 implements Runnable {
    @Override
    public void run() {
        try {
            printingStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printingStars() throws InterruptedException {
        //activity 2
        System.out.println("Printing activity started...");
        for(int i=0; i<=4; i++){
            System.out.println("*");
            Thread.sleep(4000);
        }
        System.out.println("Printing activity Terminated!");
    }
}

class Gamma2 implements Runnable {
    @Override
    public void run() {
        try {
            focus();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void focus() throws InterruptedException {
        //activity 3
        System.out.println("Printing Important message started...");
        for(int i=0; i<=4; i++){
            System.out.println("Don't give up!");
            Thread.sleep(4000);
        }
        System.out.println("Printing Important message Terminated!");
    }
}

/////////////////////////***RUNNABLE2.0***///////////////////////////
class Alpha3 implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if(threadName.equals("BANKING")){
            banking();
        } else if(threadName.equals("STAR")){
            printingStars();
        } else{
            focus();
        }
    }
        void banking()
        {
            //activity 1
            System.out.println("Banking activity started");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user no : 4");
            int userNo =  4;
            System.out.println("Enter the Password");
            int password = sc.nextInt();
            System.out.println("Collect Your cash!");
            System.out.println("Banking activity Terminated!");
        }
        public void printingStars(){
            //activity 2
            System.out.println("Printing activity started...");
            for(int i=0; i<=4; i++){
                System.out.println("*");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Printing activity Terminated!");
        }
        public void focus() {
            //activity 3
            System.out.println("Printing Important message started...");
            for(int i=0; i<=4; i++){
                System.out.println("Don't give up!");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Printing Important message Terminated!");
        }
    }

/////////////////////////***RUNNABLE3.0***///////////////////////////
/*
class MyCar implements Runnable {
    @Override
    //SYNCHRONIZE means applying a lock
    //in this environment, at a time only 1 thread will get executed
    //whichever thread will get a chance, will start running the run() method
    //if a thread is geeting delayed, other threads will not get into the run method

    //StringBuffer	| StringBuilder
    //1)Thread-safe	| Not thread-safe
    //2)Synchronized	| Not synchronized
    //3)Safer when multiple threads access the same object | Faster when working in a single-threaded environment
    //4)Slightly slower due to synchronization overhead	Generally faster

    synchronized public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has entered parking lot");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has entered into car");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has started to drive the car");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + "has came back and parked the car");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
*/
/////////////////////////***RUNNABLE4.0***///////////////////////////
class MyCar implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has entered parking lot");
            Thread.sleep(4000);
            synchronized(this)
            {
            System.out.println(Thread.currentThread().getName() + " has entered into car");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " has started to drive the car");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + "has came back and parked the car");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


public class Threading1 {
/*    public void example1() throws InterruptedException {
        System.out.println("Application started...");
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        //Thread priority ranges from 1 to 10, with 5 as the default, but priority does not guarantee execution order.
        Thread.sleep(5000); //throws InterruptedException as system is sleeping
        thread.setName("Telusko"); //we can change name and priority of threads in java as required
        thread.setPriority(4);
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println("Application Terminated...");
    }
*/

    public static void main(String[] args) throws InterruptedException {
       /////////////////////////***THREADS***///////////////////////////
/*      System.out.println("Application started...");
        //three new threads we created
        Alpha1 a = new  Alpha1();
        Beta1 b = new  Beta1();
        Gamma1 g = new  Gamma1();
//      start() gives life to thread
//      with the help of start threads are getting handed over to ThreadScheduler
        a.start(); //giving life to new thread 1 with start method
        b.start(); //thread 2
        g.start(); //thread 3
//      which thread will get executed first .. i don't have control over it but CPU's time cycle will not get wasted
//      if there is a slight delay in any thread then another thread will get executed
//      a.banking();
//      b.printingStars();
//      g.focus();
        System.out.println("Application Terminated...");
*/
        /////////////////////////***RUNNABLE***///////////////////////////
/*      //MAIN THREAD is the one who will complete his execution first
        System.out.println("Application started...");
        //three new threads we created
        Alpha2 a = new  Alpha2();
        Beta2 b = new  Beta2();
        Gamma2 g = new  Gamma2();
        //task is inside the run method and that run method is available inside the object which is referred by a
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(g);
        //giving life to thread with start() method
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println(t3.isAlive());
        t1.start(); //t1 thread chalu ho ja
        System.out.println(t1.isAlive());
        t1.join(); //t1 khatam hoga tabhi aage jayega thread
        t2.start();
        t3.start();
        // join() makes the current thread wait until the specified thread completes its execution.
        t2.join();
        t3.join();
        System.out.println(t2.isAlive());
        System.out.println(t3.isAlive());
        System.out.println("Application Terminated!");
*/
        /////////////////////////***RUNNABLE2.0***///////////////////////////
        //cpu is getting utilized but behaviour is not good
/*      System.out.println("Application Terminated!");
        Alpha3 a = new Alpha3();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);
        t1.setName("BANKING");
        t2.setName("STAR");
        t3.setName("FOCUS ");
        t1.start();
        t2.start();
        t3.start();
*/
        /////////////////////////***RUNNABLE3.0***///////////////////////////
/*      //behaviour is not good so we will use synchronized
        MyCar car = new MyCar();
        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);
        t1.setName("CHILD1");
        t2.setName("CHILD2");
        t3.setName("CHILD3");
        t1.start();
        t2.start();
        t3.start();
*/
        /////////////////////////***RUNNABLE4.0***///////////////////////////
        //behaviour is not good so we will use synchronized
        //Runnable r = () -> System.out.println("Hello World");
        //Thread t = new Thread(() -> System.out.println("Hello World"));
        MyCar car = new MyCar();
        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);
        t1.setName("CHILD1");
        t2.setName("CHILD2");
        t3.setName("CHILD3");
        t1.start();
        t2.start();
        t3.start();
    }
}
