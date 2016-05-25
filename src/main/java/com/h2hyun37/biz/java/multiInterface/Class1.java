package com.h2hyun37.biz.java.multiInterface;

public class Class1 implements Interface1, Interface2 {

	private int number;

	private String name = "kook";

	@Override
	public void printUserInfo() {

		System.out.println("name = " + name);
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

}
