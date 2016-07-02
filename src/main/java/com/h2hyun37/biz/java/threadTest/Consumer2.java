package com.h2hyun37.biz.java.threadTest;

public class Consumer2 implements Runnable {

    ResourceQueue2<Character> queue;

    public Consumer2(ResourceQueue2<Character> queue) {
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

	    // System.out.println("[" + Thread.currentThread().getName() + "]
	    // ready to get from queue");

	    Character data;
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
