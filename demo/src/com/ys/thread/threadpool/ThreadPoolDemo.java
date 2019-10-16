package com.ys.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new MyThread());
        }
        executorService.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
    }
}
