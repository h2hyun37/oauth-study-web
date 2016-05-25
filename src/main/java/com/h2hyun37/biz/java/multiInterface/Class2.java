package com.h2hyun37.biz.java.multiInterface;

public class Class2 implements Interface2 {

	private String name = "kook2222";

	@Override
	public void printUserInfo() {

		System.out.println("name = " + name);
		System.out.println("name2 == " + name2);
	}


}
