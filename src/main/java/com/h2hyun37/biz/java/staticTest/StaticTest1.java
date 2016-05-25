package com.h2hyun37.biz.java.staticTest;

public class StaticTest1 {

	private int instanceNumber = 123;

	private static int staticNumber = 456;

	public void accessFromInstanceMethod() {

		System.out.println("accessFromInstanceMethod()");
		System.out.println("instanceNumber : " + instanceNumber);
		System.out.println("staticNumber : " + staticNumber);
	}

	public static void accessFromStaticMethod() {

		System.out.println("accessFromStaticMethod()");
		// System.out.println("instanceNumber : " + instanceNumber);
		System.out.println("staticNumber : " + staticNumber);
	}

	public static void main(String[] args) {

		StaticTest1 staticTest1 = new StaticTest1();

		staticTest1.accessFromInstanceMethod();
		StaticTest1.accessFromStaticMethod();

	}

}
