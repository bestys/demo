package com.ys.thread.status;

import java.util.concurrent.TimeUnit;

public class ThreadLifeStatus {
	
	public static ThreadLifeStatus lockObj = new ThreadLifeStatus();
	
	private static volatile boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> { // jps和jstack命令观察线程状态
			while(flag) { // 观察线程runnable状态
			}
			try {
				TimeUnit.SECONDS.sleep(10); // 观察线程timed_waiting状态
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"Thread-0").start();
		
		new Thread(()-> {
			synchronized (lockObj) {
				while(flag) {
					
				}
				try {
					lockObj.wait(); // 观察线程waiting状态
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"Thread-1").start();
		new Thread(()-> {
			synchronized (lockObj) { // 观察线程block状态
				while(flag) {
					
				}
				lockObj.notify(); 
			}
		},"Thread-2").start();
		TimeUnit.SECONDS.sleep(20);
		flag = false;
		
	}
}
