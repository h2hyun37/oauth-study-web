package com.h2hyun37.biz.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NumberChangeObserver implements Observer {

	private Subject subject;
	List<Integer> list = new ArrayList<>();


	public NumberChangeObserver(Subject subject) {
		System.out.println("NumberChangeObserver created");
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println("NumberChangeObserver update()");
		int number = subject.getNumber();
		list.add(number);

		System.out.println("number change history");
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) {
				System.out.print(" ==> ");
			}
			System.out.print(list.get(i));
		}
		System.out.println();

	}


}
