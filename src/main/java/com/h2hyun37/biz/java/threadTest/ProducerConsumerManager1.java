package com.h2hyun37.biz.java.threadTest;

public class ProducerConsumerManager1 {

	public static void main(String[] args) {

		ResourceQueue1<Integer> queue = new ResourceQueue1<>();

		Producer1 producer = new Producer1(queue);
		Consumer1 consumer1 = new Consumer1(queue);
		Consumer1 consumer2 = new Consumer1(queue);

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
