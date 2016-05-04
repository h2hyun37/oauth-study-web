package com.sktechx.java.pattern.observer;


public class AccSumObserver implements Observer {

	private Subject subject;
	private int sum = 0;


	public AccSumObserver(Subject subject) {
		System.out.println("AccSumObserver created");
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println("AccSumObserver update()");

		int number = subject.getNumber();
		sum += number;

		System.out.println("total number sum");
		System.out.println("sum = " + sum);
	}


}
