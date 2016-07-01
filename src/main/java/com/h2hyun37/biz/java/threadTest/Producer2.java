package com.h2hyun37.biz.java.threadTest;

public class Producer2 implements Runnable {

	ResourceQueue2<Integer> queue;

	public Producer2(ResourceQueue2<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		int i = 0;
		while (!Thread.interrupted()) {
			i++;
			System.out.println("[" + Thread.currentThread().getName() + "] : produce : " + i);
			queue.put(i);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}

		}

	}

}
