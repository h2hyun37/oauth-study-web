package com.h2hyun37.biz.algorithm.ds.queue;


public class Queue {

	private int[] queue;
	private int front = -1;
	private int rear = -1;
	private int size = 0;

	public Queue(int size) {
		queue = new int[size];
	}

	public void put(int element) throws ArrayIndexOutOfBoundsException {

		if (front == -1) {
			front++;
		}
		queue[++rear] = element;
		size++;
	}

	public int get() throws ArrayIndexOutOfBoundsException {
		int returnValue = queue[front];

		if (size > 1) {
			for (int idx = 1; idx <= rear; idx++) {
				queue[idx - 1] = queue[idx];
			}
		} else {
			front--;
		}
		rear--;
		size--;

		return returnValue;
	}

	public static void main(String[] args) throws InterruptedException {
		Queue queue = new Queue(10);

		int[] numbers = new int[] { 6, 78, 30, 26, 2, 77, 59, 11, 190, 76 };

		System.out.println("put number : ");
		for (int number : numbers) {
			System.out.print(number + ",");
			queue.put(number);
		}
		System.out.println();


		System.out.println("get number : ");
		for (int idx = 0; idx < numbers.length; idx++) {
			System.out.print(queue.get() + ",");
		}
		System.out.println();

		Thread.sleep(1000);

		// exception test
		System.out.println("get number : " + queue.get());

	}



}
