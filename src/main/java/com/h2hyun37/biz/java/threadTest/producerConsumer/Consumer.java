package com.h2hyun37.biz.java.threadTest.producerConsumer;

public class Consumer implements Runnable {

	ResourceQueue<Character> queue;

	public Consumer(ResourceQueue<Character> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {

			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }

			// System.out.println("[" + Thread.currentThread().getName() + "] ready to get from queue");

			Character data = null;
			data = queue.get();
			System.out.println("[" + Thread.currentThread().getName() + "] get : " + data);

		}

	}

}
