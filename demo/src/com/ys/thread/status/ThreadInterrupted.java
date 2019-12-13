package com.ys.thread.status;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * created by yuans on 2019/12/6
 **/
public class ThreadInterrupted {
    public static void main(String[] args) {
//        Thread thread1 = new Thread(()->{
//            try {
//                Thread.currentThread().join();
//                Thread.currentThread().wait();
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                System.out.println("线程被中断");
//            }
//        },"Thread-1");
//        thread1.start();
//        thread1.interrupt();
        Thread thread2 = new Thread(()->{
            while(!Thread.interrupted()){
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        },"Thread-2");
        thread2.start();
    }
}
