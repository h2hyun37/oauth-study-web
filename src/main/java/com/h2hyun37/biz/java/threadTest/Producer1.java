package com.h2hyun37.biz.java.threadTest;

public class Producer1 implements Runnable {

	ResourceQueue1<Integer> queue;

	public Producer1(ResourceQueue1<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		int i = 0;
		while (true) {
			i++;
			System.out.println("[" + Thread.currentThread().getName() + "] : produce : " + i);
			queue.put(i);

			// try {
			// Thread.sleep(300);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// break;
			// }

		}

	}

}
