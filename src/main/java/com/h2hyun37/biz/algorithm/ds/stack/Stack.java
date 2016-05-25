package com.h2hyun37.biz.algorithm.ds.stack;


public class Stack {

	private int[] stack;
	private int top = -1;
	private int maxSize = -1;

	public Stack(int size) {
		stack = new int[size];
		maxSize = size;
	}

	public void push(int element) throws ArrayIndexOutOfBoundsException {

		// if (top >= maxSize) {
		// throw new StackOverflowError("stack overflow. size == " + top + ", maxSize == " + maxSize);
		// }

		stack[++top] = element;
	}

	public int pop() throws ArrayIndexOutOfBoundsException {
		int popValue = stack[top];
		top--;
		return popValue;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);

		int[] numbers = new int[] { 6, 78, 30, 26, 2, 77, 59, 11, 190, 76 };

		for (int number : numbers) {
			System.out.println("push number : " + number);
			stack.push(number);
		}

		for (int idx = 0; idx < numbers.length; idx++) {
			System.out.println("pop number : " + stack.pop());
		}

		// exception test
		System.out.println("pop number : " + stack.pop());

	}



}
