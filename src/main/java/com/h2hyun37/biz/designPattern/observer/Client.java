package com.h2hyun37.biz.designPattern.observer;

public class Client {

	public static void main(String[] args) {

		Subject subject = new Subject();

		AccSumObserver observer1 = new AccSumObserver(subject);
		NumberChangeObserver observer2 = new NumberChangeObserver(subject);

		subject.attach(observer1);
		subject.attach(observer2);

		for (int i : new int[] { 1, 4, 6, 99, 3, 0, 10000 }) {
			System.out.println("in client : subject.setNumber(" + i + ")");
			subject.setNumber(i);
		}

		subject.detach(observer1);

		for (int i : new int[] { 44, 2, 1 }) {
			System.out.println("in client : subject.setNumber(" + i + ")");
			subject.setNumber(i);
		}

	}

}
