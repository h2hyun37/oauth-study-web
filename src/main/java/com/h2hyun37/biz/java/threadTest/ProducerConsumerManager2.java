package com.h2hyun37.biz.java.threadTest;

public class ProducerConsumerManager2 {

	public static void main(String[] args) {

	ResourceQueue2<Character> queue = new ResourceQueue2<>();

		Producer2 producer = new Producer2(queue);
		Consumer2 consumer1 = new Consumer2(queue);
		Consumer2 consumer2 = new Consumer2(queue);

		Thread producerThread = new Thread(producer, "producer");
		Thread consumerThread1 = new Thread(consumer1, "consumer1");
		Thread consumerThread2 = new Thread(consumer2, "consumer2");

		producerThread.start();

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		consumerThread1.start();
		consumerThread2.start();

	}

}
