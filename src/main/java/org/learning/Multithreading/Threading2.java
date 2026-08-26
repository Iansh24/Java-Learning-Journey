package org.learning.Multithreading;

///////////////////////**********States of a Thread********///////////////////////
/* Everytime we create a thread it goes through certain states
1) NEW STATE
2)RUNNABLE STATE
3)RUNNING STATE -> IN THIS STATE,THREAD CAN GO TO BLOCKED STATE
I)BLOCKED STATE : IF REQUIRED RESOURCE IS NOT AVAILABLE
II)WAIT STATE : THREAD GOES IN THIS STATE IF IT IS ENCOUNTERING WAIT() METHOD
III)SLEEP STATE : THREAD GOES IN THIS STATE IF IT IS ENCOUNTERING SLEEP() METHOD
4)DEAD STATE-TASK OVER THEN IT WILL DIE
*/

class Library implements Runnable {
    String res1 = new String("Java");
    String res2 = new String("DSA");
    String res3 = new String("SpringBoot");

    @Override
    //whichever thread gets a chance will get a chance wil exeute the body of run method
    //3)Running state
    public void run() {
        String name = Thread.currentThread().getName();
        if(name.equals("Student1")){
            try
            {
                System.out.println("Student1 got into library!");
                Thread.sleep(3000); //searching book
                synchronized (res1) {
                    System.out.println("Student1 has acquired " + res1);
                    Thread.sleep(3000);
                    synchronized (res2) {
                        System.out.println("Student1 has acquired " + res2);
                        Thread.sleep(3000);
                        synchronized (res3) {
                            System.out.println("Student1 has acquired " + res3);
                        }
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try {
                System.out.println("Student2 got into library!");
                Thread.sleep(3000);
                synchronized (res1) {
                    System.out.println("Student2 has acquired " + res1);
                    Thread.sleep(3000);
                    synchronized (res2) {
                        System.out.println("Student2 has acquired " + res2);
                        Thread.sleep(3000);
                        synchronized (res3) {
                            System.out.println("Student2 has acquired " + res3);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
/*
        else{ // Deadlock is a phenomenon in multithreading where two or more threads are permanently blocked
            { // because each thread is waiting for a resource/lock held by another thread.
            try {
                System.out.println("Student2 got into library!");
                Thread.sleep(3000);
                synchronized (res3) {
                    System.out.println("Student2 has acquired " + res3);
                    Thread.sleep(3000);
                    synchronized (res2) {
                        System.out.println("Student2 has acquired " + res2);
                        Thread.sleep(3000);
                        synchronized (res1) {
                            System.out.println("Student2 has acquired " + res1);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
 */
    }
    //once task is over it will go to:
    //4)Dead state
}

///////////////////////**********DAEMON THREAD********///////////////////////
/* --Garbage Collector is a JVM-managed background process/thread
     that runs as a daemon-like service and automatically reclaims memory occupied by unreachable objects.
   --A race condition occurs when multiple threads access and modify the same shared resource concurrently,
     and the final result depends on the order/timing in which the threads execute.
   --what was happening in our code is saving and spell checking is getting doe before typing
     which is wrong so we made secondary activity as daemon thread because of which
     they will get executed at last in Sequential manner
   --Typing is main activity && spell checking and auto-saving is secondary activity.
     Secondary activity should get executed once like daemon threads
     priority of daemon thread should be lower than 5
   --Daemon threads get executed the same no of times as of primary thread
 */
class MSWord extends Thread {
    @Override
    public void run() {
    String name  = Thread.currentThread().getName();
    if(name.equals("TYPE")){
        typing();
    } else if (name.equals("SPELL")) {
        spellCheck();
    } else{
        autoSaving();
    }
    }
    public static void typing() {
        try
        {
            for(int i=0; i<3; i++){
                System.out.println("Typing...");
                Thread.sleep(3000);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void spellCheck() {
        try
        {
            for(;;){
                System.out.println("Spelling Check...");
                Thread.sleep(3000);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void autoSaving() {
        try
        {
            for(;;){
                System.out.println("Auto saving ...");
                Thread.sleep(3000);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


public class Threading2 {
    public static void main(String[] args) {
    ///////////////////**********States of a Thread********//////////////////
/*
    Library lib = new Library();
    //1)New state
    Thread t1 = new Thread(lib);
    Thread t2 = new Thread(lib);
    //2)Runnable state
    t1.setName("Student1");
    t2.setName("Student2");
    t1.start();
    t2.start();
*/
    ///////////////////**********States of a Thread********//////////////////
    MSWord ms1 = new MSWord();
    MSWord ms2 = new MSWord();
    MSWord ms3 = new MSWord();
    ms1.setName("TYPE");
    ms2.setName("SPELL");
    ms3.setName("SAVING");
    ms2.setDaemon(true);
    ms3.setDaemon(true);
    ms2.setPriority(4); //ms2 has higher priority than ms3
    ms3.setPriority(3);
    ms1.start();
    ms2.start();
    ms3.start();
    }
}
