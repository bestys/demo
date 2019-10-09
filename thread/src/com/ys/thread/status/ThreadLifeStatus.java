package com.ys.thread.status;

import java.util.concurrent.TimeUnit;

public class ThreadLifeStatus {
	
	public static ThreadLifeStatus lockObj = new ThreadLifeStatus();
	
	private static volatile boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> { // jps��jstack����۲��߳�״̬
			while(flag) { // �۲��߳�runnable״̬
			}
			try {
				TimeUnit.SECONDS.sleep(10); // �۲��߳�timed_waiting״̬
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"Thread-0").start();
		
		new Thread(()-> {
			synchronized (lockObj) {
				while(flag) {
					
				}
				try {
					lockObj.wait(); // �۲��߳�waiting״̬
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"Thread-1").start();
		new Thread(()-> {
			synchronized (lockObj) { // �۲��߳�block״̬
				while(flag) {
					
				}
				lockObj.notify(); 
			}
		},"Thread-2").start();
		TimeUnit.SECONDS.sleep(20);
		flag = false;
		
	}
}
