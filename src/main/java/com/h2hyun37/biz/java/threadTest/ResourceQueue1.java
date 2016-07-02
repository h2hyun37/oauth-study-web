package com.h2hyun37.biz.java.threadTest;

import java.util.LinkedList;

public class ResourceQueue1<T> {

	private LinkedList<T> list = new LinkedList<T>();

	private static Object lockObj = new Object();

	public void put(T element) {
		synchronized (lockObj) {
	    System.out.println("[" + Thread.currentThread().getName() + "] put() : " + element);
			list.addLast(element);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public T get() throws InterruptedException {

		synchronized (lockObj) {

	    System.out.println("[" + Thread.currentThread().getName() + "] get()");

			T t = null;
			if (!list.isEmpty()) {
				t = list.removeFirst();
			}
			Thread.sleep(500);

			return t;
		}
	}

}
