package org.learn.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample implements Runnable {
	
	//ThreadLocal<Double> threadLocal = ThreadLocal.withInitial(()->19.98);
	AtomicInteger threadLocal = new AtomicInteger(1);

	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName());
//		threadLocal.set(Math.random());
//		System.out.println(threadLocal.get());
		System.out.println(threadLocal.incrementAndGet());
	}
	
	public static void main(String[] args) {
		ThreadLocalExample r = new ThreadLocalExample();
		//r.threadLocal.set(1.2);
//		Thread thread1 = new Thread(r);
//		Thread thread2 = new Thread(r);
//		thread1.start();
//		thread2.start();
		
		Executor executor = Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++){
			executor.execute(r::run);
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//System.out.println(r.threadLocal.get());
		System.out.println(r.threadLocal.get());
	}

}
