package com.h2hyun37.biz.java.threadTest;

public class ProducerConsumerManager {

	public static void main(String[] args) {

		ResourceQueue<Character> queue;

		// queue = new ResourceQueueByInterrupted<>();
		queue = new ResourceQueueByPolling<>();

		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);

		Thread producerThread = new Thread(producer, "producer");
		Thread consumerThread1 = new Thread(consumer1, "consumer1");
		Thread consumerThread2 = new Thread(consumer2, "consumer2");

		producerThread.start();

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		consumerThread1.start();
		consumerThread2.start();

	}

}
