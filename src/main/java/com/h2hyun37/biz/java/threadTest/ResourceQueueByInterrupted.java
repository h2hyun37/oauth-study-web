package com.h2hyun37.biz.java.threadTest;

import java.util.LinkedList;
import java.util.Random;

public class ResourceQueueByInterrupted<T> implements ResourceQueue<T> {

	private LinkedList<T> list = new LinkedList<T>();

	@Override
	public synchronized void put(T element) {
		System.out.println("[" + Thread.currentThread().getName() + "] : put()");
		list.addLast(element);
		this.notify();
		System.out.println("[" + Thread.currentThread().getName() + "] : put() finished");
	}

	@Override
	public synchronized T get() {

		System.out.println("[" + Thread.currentThread().getName() + "] : get()");

		if (list.isEmpty()) {
			Random random = new Random();
			int randNum = random.nextInt(100);
			System.out.println("[" + Thread.currentThread().getName() + "] : wait() (random Number : " + randNum + ")");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[" + Thread.currentThread().getName() + "] : wait() finished (random Number : " + randNum + ")");
		}

		System.out.println("[" + Thread.currentThread().getName() + "] : get() finished");

		T t = list.removeFirst();
		return t;
	}

}
