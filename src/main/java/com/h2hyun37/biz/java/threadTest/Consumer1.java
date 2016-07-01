package com.h2hyun37.biz.java.threadTest;

public class Consumer1 implements Runnable {

	ResourceQueue1<Integer> queue;

	public Consumer1(ResourceQueue1<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {

			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			System.out.println("[" + Thread.currentThread().getName() + "] ready to get from queue");

			Integer data;
			try {
				data = queue.get();
				System.out.println("[" + Thread.currentThread().getName() + "] pop : " + data);


			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}


		}

	}

}
