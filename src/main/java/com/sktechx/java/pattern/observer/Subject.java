package com.sktechx.java.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private int number = 0;
	private List<Observer> observers = new ArrayList<>();

	public void attach(Observer observer) {
		System.out.println("observer [" + observer.getClass() + "] added");
		observers.add(observer);
	}

	public void detach(Observer observer) {
		System.out.println("observer [" + observer.getClass() + "] removed");
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			System.out.println("notify to observer [" + observer.getClass().getName() + "]");
			observer.update();
		}
	}

	public void setNumber(int num) {
		number = num;
		System.out.println();
		notifyObservers();
		System.out.println("=======================\n");
	}

	public int getNumber() {
		return number;
	}

}
