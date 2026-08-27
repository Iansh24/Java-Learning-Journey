package org.learning.Multithreading15;

///////////////////////**********Inter Thread Communication********///////////////////////
/*
   -There is no communication between consumer & producer.
    both consumer & producer are not even seeing what they are consuming & producing.
   -things should be like if producer produced data 1 then consumer should consume data 1
    and then only producer should move ahead by  incrementing data.
   -Wait() & notify() can be used in synchronize environment only
*/
class Producer extends Thread{
    Queue q;
    int i = 1;
    public Producer(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        while(true){
            q.produce(i++);
        }
    }
}

class Consumer extends Thread{
    Queue q;
    public Consumer(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        while(true){
            q.consume();
        }
    }
}

class Queue extends Thread{
    int data;
    boolean flag = false;
    synchronized public void produce(int i){
        try {
            if(flag) {
                System.out.println("producer is in waiting state");
                wait();
            } else {
                data = i;
                System.out.println("I Have produced data!:" + data);
                flag = true;
                notify();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    synchronized void consume(){
        try
        {
            if(!flag) {
                System.out.println("consumer is in waiting state");
                wait();
            } else {
                System.out.println("I Have Consumed data!:" + data);
                flag = false;
                notify();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class Threading3 {
    public static void main(String[] args){
        Queue q = new Queue();
        new Producer(q).start();
        new Consumer(q).start();

//        Producer p = new Producer(q);
//        Consumer c = new Consumer(q);
//        p.start();
//        c.start();
    }
}
