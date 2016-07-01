package com.h2hyun37.biz.java.threadTest;

import java.util.LinkedList;

public class ResourceQueue2<T> {

	private LinkedList<T> list = new LinkedList<T>();

	public synchronized void put(T element) {
		System.out.println("[" + Thread.currentThread().getName() + "] : put()");
		list.addLast(element);
		this.notify();
		System.out.println("[" + Thread.currentThread().getName() + "] : put() finished");
	}

	public synchronized T get() throws InterruptedException {

		System.out.println("[" + Thread.currentThread().getName() + "] : get()");

		T t = null;

		if (list.isEmpty()) {
			System.out.println("[" + Thread.currentThread().getName() + "] : wait()");
			this.wait();
			System.out.println("[" + Thread.currentThread().getName() + "] : wait() finished");
		}

		System.out.println("[" + Thread.currentThread().getName() + "] : get() finished");

		return list.removeFirst();
	}

}
