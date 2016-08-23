package interviewq;

import java.util.Vector;

/**
 * Created by jay on 8/22/16.
 * Producer customer model is useful for multi-thread event handling
 * Target:
 * > Practice the multi-thread
 */
public class Producer_Customer_Model {

    private final int QUEUE_SIZE = 4;
    private Vector ShareQueue = new Vector<>();
    private final Thread producer_t;
    private final Thread customer_t;
    //Set the delay time for analysis
    private final int p_delay_time = 1000;
    private final int c_delay_time = 0;
    //Total records to be handled
    public final static int MAX_DATA = 100;

    Producer_Customer_Model(){
        producer_t = new Thread(new Producer(ShareQueue, QUEUE_SIZE, p_delay_time));
        customer_t = new Thread(new Customer(ShareQueue, QUEUE_SIZE, c_delay_time));

    }

    public void start(){
        producer_t.start();
        customer_t.start();
    }

}

class Producer implements Runnable {

    private Vector PShareq;
    private int PSize;
    private int PDelay;

    Producer(Vector shareq, int size, int delay_time){
        PShareq = shareq;
        PSize = size;
        PDelay = delay_time;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < Producer_Customer_Model.MAX_DATA) {
            synchronized (PShareq) {
                while (PShareq.size() == PSize) { //full
                    try {
                        System.out.println("Producer is full... wait!");
                        PShareq.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (PShareq) {
                System.out.println("Producer : add " + count);
                PShareq.add(count);
                PShareq.notifyAll();
            }

            if (PDelay != 0) {
                try {
                    Thread.sleep(PDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count++;
        }
        System.out.println("Producer finish......");
    }
}

class Customer implements Runnable{

    private Vector CShareq;
    private int CSize;
    private int CDelay;
    Customer (Vector shareq, int size, int delay_time){
        CShareq = shareq;
        CSize = size;
        CDelay = delay_time;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < Producer_Customer_Model.MAX_DATA) {
            synchronized (CShareq) {
                while (CShareq.isEmpty()) { //Empty
                    try {
                        System.out.println("Consumer is empty... wait!");
                        CShareq.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            synchronized (CShareq) {
                System.out.println("Consumer : consume " + count);
                CShareq.remove(0);
                CShareq.notifyAll();
            }

            if (CDelay != 0) {
                try {
                    Thread.sleep(CDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
        }

        System.out.println("Consumer finish......");
    }
}