package com.h2hyun37.biz.java.threadTest.producerConsumer;

import java.util.LinkedList;

public class ResourceQueueByPolling<T> implements ResourceQueue<T> {

	private LinkedList<T> list = new LinkedList<T>();

	private static Object lockObj = new Object();

	@Override
	public void put(T element) {

		try {
			putElement(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void putElement(T element) throws InterruptedException {
		synchronized (lockObj) {
			System.out.println("[" + Thread.currentThread().getName() + "] put() : " + element);
			list.addLast(element);
			Thread.sleep(100);
		}
	}

	@Override
	public T get() {

		T t = null;

		try {
			t = getElement();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return t;
	}

	public T getElement() throws InterruptedException {
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
